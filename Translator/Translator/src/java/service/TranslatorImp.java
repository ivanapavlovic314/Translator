
package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import javax.jws.WebService;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@WebService(endpointInterface="service.Translator")
public class TranslatorImp implements Translator {
    File xmlDoc = null;    
    InputSource is=null;
    XPathFactory factory = null;
    XPath path = null;
    XPathExpression xPathExpression = null;
    Object result = null;    
    NodeList nodeList = null;
    String a="";
    
    public String prevod (String word, String lang1, String lang2) throws XPathExpressionException {
        try {
        
        xmlDoc = new File("dictionary.xml");
        
        is = new InputSource(new FileInputStream(xmlDoc));
        factory = XPathFactory.newInstance();
        path = factory.newXPath();
        xPathExpression = path.compile("//word["+ lang1 + "='" + word + "']/" + lang2);
        
        result = xPathExpression.evaluate(is,XPathConstants.NODESET);
        
        nodeList = (NodeList)result;
        
        a=nodeList.item(0).getTextContent();
                
        return a;   
        }
        
        catch (NullPointerException | FileNotFoundException ex) {
            return "Trazena rec ne postoji u ovom recniku";
        }
    }
    
    @Override
    public String translate_ENG2GER (String word, String English, String German) throws InvocationTargetException, FileNotFoundException, XPathExpressionException, NullPointerException{
        
        return prevod(word, English, German);         
    }

    @Override
    public String translate_GER2ENG (String word, String German, String English) throws InvocationTargetException, FileNotFoundException, XPathExpressionException, NullPointerException{
        
        return prevod(word, German, English);    
    }
   
}
