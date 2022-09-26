
package myweather.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "NewWSDLFile", targetNamespace = "http://www.example.org/NewWSDLFile/", wsdlLocation = "file:/C:/Users/a881146/OneDrive%20-%20Atos/Desktop/WeatherApp/src/main/resources/NewWSDLFile.wsdl")
public class NewWSDLFile_Service
    extends Service
{

    private final static URL NEWWSDLFILE_WSDL_LOCATION;
    private final static WebServiceException NEWWSDLFILE_EXCEPTION;
    private final static QName NEWWSDLFILE_QNAME = new QName("http://www.example.org/NewWSDLFile/", "NewWSDLFile");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/a881146/OneDrive%20-%20Atos/Desktop/WeatherApp/src/main/resources/NewWSDLFile.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        NEWWSDLFILE_WSDL_LOCATION = url;
        NEWWSDLFILE_EXCEPTION = e;
    }

    public NewWSDLFile_Service() {
        super(__getWsdlLocation(), NEWWSDLFILE_QNAME);
    }

    public NewWSDLFile_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), NEWWSDLFILE_QNAME, features);
    }

    public NewWSDLFile_Service(URL wsdlLocation) {
        super(wsdlLocation, NEWWSDLFILE_QNAME);
    }

    public NewWSDLFile_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, NEWWSDLFILE_QNAME, features);
    }

    public NewWSDLFile_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NewWSDLFile_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns NewWSDLFile
     */
    @WebEndpoint(name = "NewWSDLFileSOAP")
    public NewWSDLFile getNewWSDLFileSOAP() {
        return super.getPort(new QName("http://www.example.org/NewWSDLFile/", "NewWSDLFileSOAP"), NewWSDLFile.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns NewWSDLFile
     */
    @WebEndpoint(name = "NewWSDLFileSOAP")
    public NewWSDLFile getNewWSDLFileSOAP(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.example.org/NewWSDLFile/", "NewWSDLFileSOAP"), NewWSDLFile.class, features);
    }

    private static URL __getWsdlLocation() {
        if (NEWWSDLFILE_EXCEPTION!= null) {
            throw NEWWSDLFILE_EXCEPTION;
        }
        return NEWWSDLFILE_WSDL_LOCATION;
    }

}