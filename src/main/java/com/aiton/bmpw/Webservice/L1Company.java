/**
 * L1Company.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aiton.bmpw.Webservice;

public class L1Company  implements java.io.Serializable {
    private java.lang.String AID;

    private java.lang.String companyName;

    private java.lang.String zoneCode;

    public L1Company() {
    }

    public L1Company(
           java.lang.String AID,
           java.lang.String companyName,
           java.lang.String zoneCode) {
           this.AID = AID;
           this.companyName = companyName;
           this.zoneCode = zoneCode;
    }


    /**
     * Gets the AID value for this L1Company.
     * 
     * @return AID
     */
    public java.lang.String getAID() {
        return AID;
    }


    /**
     * Sets the AID value for this L1Company.
     * 
     * @param AID
     */
    public void setAID(java.lang.String AID) {
        this.AID = AID;
    }


    /**
     * Gets the companyName value for this L1Company.
     * 
     * @return companyName
     */
    public java.lang.String getCompanyName() {
        return companyName;
    }


    /**
     * Sets the companyName value for this L1Company.
     * 
     * @param companyName
     */
    public void setCompanyName(java.lang.String companyName) {
        this.companyName = companyName;
    }


    /**
     * Gets the zoneCode value for this L1Company.
     * 
     * @return zoneCode
     */
    public java.lang.String getZoneCode() {
        return zoneCode;
    }


    /**
     * Sets the zoneCode value for this L1Company.
     * 
     * @param zoneCode
     */
    public void setZoneCode(java.lang.String zoneCode) {
        this.zoneCode = zoneCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof L1Company)) return false;
        L1Company other = (L1Company) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.AID==null && other.getAID()==null) || 
             (this.AID!=null &&
              this.AID.equals(other.getAID()))) &&
            ((this.companyName==null && other.getCompanyName()==null) || 
             (this.companyName!=null &&
              this.companyName.equals(other.getCompanyName()))) &&
            ((this.zoneCode==null && other.getZoneCode()==null) || 
             (this.zoneCode!=null &&
              this.zoneCode.equals(other.getZoneCode())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAID() != null) {
            _hashCode += getAID().hashCode();
        }
        if (getCompanyName() != null) {
            _hashCode += getCompanyName().hashCode();
        }
        if (getZoneCode() != null) {
            _hashCode += getZoneCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(L1Company.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("XMJDT online ticket web service", "L1Company"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AID");
        elemField.setXmlName(new javax.xml.namespace.QName("XMJDT online ticket web service", "AID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("companyName");
        elemField.setXmlName(new javax.xml.namespace.QName("XMJDT online ticket web service", "CompanyName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zoneCode");
        elemField.setXmlName(new javax.xml.namespace.QName("XMJDT online ticket web service", "ZoneCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
