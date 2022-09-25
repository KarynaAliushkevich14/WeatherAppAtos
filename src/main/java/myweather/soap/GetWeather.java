
package myweather.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cityWithSelectionName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="correlationId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cityWithSelectionName",
    "correlationId"
})
@XmlRootElement(name = "getWeather")
public class GetWeather {

    @XmlElement(required = true, nillable = true)
    protected String cityWithSelectionName;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer correlationId;

    /**
     * Gets the value of the cityWithSelectionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityWithSelectionName() {
        return cityWithSelectionName;
    }

    /**
     * Sets the value of the cityWithSelectionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityWithSelectionName(String value) {
        this.cityWithSelectionName = value;
    }

    /**
     * Gets the value of the correlationId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCorrelationId() {
        return correlationId;
    }

    /**
     * Sets the value of the correlationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCorrelationId(Integer value) {
        this.correlationId = value;
    }

}
