package com.kruma.core.configuration;

import com.kruma.core.configuration.manager.ApplicationManager;
import com.kruma.core.configuration.manager.ConnectionManager;
import com.kruma.core.configuration.manager.ServiceManager;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

/**
 * Created by John on 22/06/2016.
 */
public class ConfigurationManager {

    private static final String str_Path = "kruma.config";
    private ConnectionManager obj_ConnectionsManager; //Administrador de conexiones
    private ServiceManager obj_ServiceManager; //Administrador de conexiones
    private ApplicationManager obj_ApplicationManager; //Administrador de aplicacion
    private static ConfigurationManager obj_ConfigurationManager;

    public static ConfigurationManager getDefault() {
        if (obj_ConfigurationManager == null)
            obj_ConfigurationManager = new ConfigurationManager();
        return obj_ConfigurationManager;
    }

    private String getConfigSection(String str_pNombre) throws Exception {

        String str_Result = "";

        //Se obtiene el nodo SECTION
        XPath obj_XPath = XPathFactory.newInstance().newXPath();
        String str_Expression = String.format("/Configuration/Section[@Name='%s']", str_pNombre);
        Node obj_Node = (Node) obj_XPath.evaluate(str_Expression,
                new InputSource(App.getContext().getAssets().open(this.str_Path))
                , XPathConstants.NODE);

        //Conversion de XML a STRING
        javax.xml.transform.Transformer obj_Serializer = TransformerFactory.newInstance().newTransformer();
        obj_Serializer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

        if (obj_Node != null) {
            for (int i = 0;i < obj_Node.getChildNodes().getLength(); i++) {
                Node obj_ChilNode = obj_Node.getChildNodes().item(i);
                if (obj_ChilNode.getNodeType() == Node.ELEMENT_NODE) {
                    StringWriter sw_Resultado = new StringWriter();
                    obj_Serializer.transform(new DOMSource(obj_ChilNode), new StreamResult(sw_Resultado));
                    str_Result = sw_Resultado.toString();
                    break;
                }
            }
        }
        return str_Result;
    }

    public ApplicationManager getApplicationManager(){
        try {
            if (obj_ApplicationManager == null) {
                String str_Nodo = getConfigSection("Application");
                if (str_Nodo.length() > 0) {
                    Serializer obj_Serializer = new Persister();
                    obj_ApplicationManager = obj_Serializer.read(ApplicationManager.class, str_Nodo);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return obj_ApplicationManager;
    }

    public ServiceManager getServiceManager() {
        try {
            if (obj_ServiceManager == null) {
                String str_Nodo = getConfigSection("Service");
                if (str_Nodo.length() > 0) {
                    Serializer obj_Serializer = new Persister();
                    obj_ServiceManager = obj_Serializer.read(ServiceManager.class, str_Nodo);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return obj_ServiceManager;
    }

    public ConnectionManager getConnectionsManager(){
        try {
            if (obj_ConnectionsManager == null) {
                String str_Nodo = getConfigSection("Connection");
                if (str_Nodo.length() > 0) {
                    Serializer obj_Serializer = new Persister();
                    obj_ConnectionsManager = obj_Serializer.read(ConnectionManager.class, str_Nodo);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return obj_ConnectionsManager;
    }
}

