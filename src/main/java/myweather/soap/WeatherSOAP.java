
package myweather.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WeatherSOAP", targetNamespace = "http://www.example.org/WeatherSOAP/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WeatherSOAP {


    /**
     * 
     * @param parameters
     * @return
     *     returns myweather.GetWeatherResponse
     * @throws GetWeatherRequestFaultMessage
     */
    @WebMethod(operationName = "GetWeatherOperation", action = "http://www.example.org/WeatherSOAP/GetWeatherOperation")
    @WebResult(name = "GetWeatherResponse", targetNamespace = "http://www.example.org/WeatherSOAP/", partName = "parameters")
    public GetWeatherResponse getWeatherOperation(
        @WebParam(name = "GetWeatherRequest", targetNamespace = "http://www.example.org/WeatherSOAP/", partName = "parameters")
        GetWeatherRequest parameters)
        throws GetWeatherRequestFaultMessage
    ;

}
