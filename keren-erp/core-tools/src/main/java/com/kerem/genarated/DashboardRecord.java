//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.24 at 01:34:02 PM WAT 
//


package com.kerem.genarated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.keren.net/keren}dashboard" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="label" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="parent_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="action_ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="entity_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="model_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="method_ref" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dashboard"
})
@XmlRootElement(name = "dashboardRecord")
public class DashboardRecord {

    protected List<Dashboard> dashboard;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "label")
    protected String label;
    @XmlAttribute(name = "parent_ref")
    protected String parentRef;
    @XmlAttribute(name = "action_ref")
    protected String actionRef;
    @XmlAttribute(name = "entity_ref", required = true)
    protected String entityRef;
    @XmlAttribute(name = "model_ref", required = true)
    protected String modelRef;
    @XmlAttribute(name = "method_ref", required = true)
    protected String methodRef;

    /**
     * Gets the value of the dashboard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dashboard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDashboard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Dashboard }
     * 
     * 
     */
    public List<Dashboard> getDashboard() {
        if (dashboard == null) {
            dashboard = new ArrayList<Dashboard>();
        }
        return this.dashboard;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the parentRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentRef() {
        return parentRef;
    }

    /**
     * Sets the value of the parentRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentRef(String value) {
        this.parentRef = value;
    }

    /**
     * Gets the value of the actionRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionRef() {
        return actionRef;
    }

    /**
     * Sets the value of the actionRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionRef(String value) {
        this.actionRef = value;
    }

    /**
     * Gets the value of the entityRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEntityRef() {
        return entityRef;
    }

    /**
     * Sets the value of the entityRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEntityRef(String value) {
        this.entityRef = value;
    }

    /**
     * Gets the value of the modelRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModelRef() {
        return modelRef;
    }

    /**
     * Sets the value of the modelRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModelRef(String value) {
        this.modelRef = value;
    }

    /**
     * Gets the value of the methodRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMethodRef() {
        return methodRef;
    }

    /**
     * Sets the value of the methodRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMethodRef(String value) {
        this.methodRef = value;
    }

}
