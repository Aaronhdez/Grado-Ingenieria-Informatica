/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twoStepTransform;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.stream.StreamSource;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;



/**
 *
 * @author Entrar
 */
public class XsltTransformer {

    private final String secondStepFile;
    private final String firstStepFile;
    private final String htmlToTransform;

    public XsltTransformer(String firstStepFile, String secondStepFile, String htmlToTransform) {
        this.firstStepFile = firstStepFile;
        this.secondStepFile = secondStepFile;
        this.htmlToTransform = htmlToTransform;
    }
    
    public String twoStepTransform(HttpServletRequest request, 
                                        HttpServletResponse response) 
                                        throws TransformerException, URISyntaxException
    {
        //FIRST STEP
        StringReader firstStepReader = new StringReader(htmlToTransform);
        StringWriter firstStepWriter = new StringWriter();
        stepTransformation(firstStepReader, firstStepWriter, firstStepFile);
        
        //SECOND STEP
        StringReader secondStepReader = new StringReader(firstStepWriter.toString());
        StringWriter secondStepWriter = new StringWriter();
        return stepTransformation(secondStepReader, secondStepWriter, secondStepFile);
    }
    
    private String stepTransformation(StringReader reader, StringWriter writer, String xslFilename) {
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer(
                    new StreamSource(new File(getClass().getResource(xslFilename).toURI())));
            transformer.transform(new StreamSource(reader), new StreamResult(writer));
            return writer.toString();
        } catch (TransformerException | URISyntaxException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(XsltTransformer.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

}
