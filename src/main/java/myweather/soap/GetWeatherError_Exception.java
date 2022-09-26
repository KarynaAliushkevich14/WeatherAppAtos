
package myweather.soap;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "getWeatherError", targetNamespace = "http://www.example.org/NewWSDLFile/")
public class GetWeatherError_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private GetWeatherError faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public GetWeatherError_Exception(String message, GetWeatherError faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public GetWeatherError_Exception(String message, GetWeatherError faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: net.atos.weatherApi.GetWeatherError
     */
    public GetWeatherError getFaultInfo() {
        return faultInfo;
    }

}