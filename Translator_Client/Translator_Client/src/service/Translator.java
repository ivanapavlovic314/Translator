
package service;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.xpath.XPathExpressionException;

@WebService
public interface Translator {
    
    @WebMethod
    String translate_ENG2GER (String word, String English, String German) throws InvocationTargetException, FileNotFoundException, XPathExpressionException, NullPointerException;
    
    @WebMethod
    String translate_GER2ENG (String word, String German, String English) throws InvocationTargetException, FileNotFoundException, XPathExpressionException, NullPointerException;


}
