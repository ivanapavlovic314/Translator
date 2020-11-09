package service;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.xpath.XPathExpressionException;


public class main {

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     * @throws java.lang.reflect.InvocationTargetException
     * @throws java.io.FileNotFoundException
     * @throws javax.xml.xpath.XPathExpressionException
     */
    public static void main(String[] args) throws MalformedURLException, InvocationTargetException, FileNotFoundException, XPathExpressionException {
     
        URL url = new URL("http://localhost:8080//Translator/TranslatorImpService?wsdl");
        
        QName qname = new QName("http://service/","TranslatorImpService");
        
        Service service = Service.create(url, qname);
        
        QName port = new QName("http://service/","TranslatorImpPort");
        
        Translator t = service.getPort(port,Translator.class);
        
        
        System.out.println(t.translate_ENG2GER("sladoled","English","German"));
        System.out.println(t.translate_GER2ENG("strand","German","English"));
  
    }
    
}
