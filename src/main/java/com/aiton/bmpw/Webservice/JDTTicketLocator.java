/**
 * JDTTicketLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aiton.bmpw.Webservice;

public class JDTTicketLocator extends org.apache.axis.client.Service implements com.aiton.bmpw.Webservice.JDTTicket {

    public JDTTicketLocator() {
    }


    public JDTTicketLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public JDTTicketLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for JDTTicketSoap12
    private java.lang.String JDTTicketSoap12_address = "http://www.aiton.com.cn:808/JDTTicket.asmx";

    public java.lang.String getJDTTicketSoap12Address() {
        return JDTTicketSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String JDTTicketSoap12WSDDServiceName = "JDTTicketSoap12";

    public java.lang.String getJDTTicketSoap12WSDDServiceName() {
        return JDTTicketSoap12WSDDServiceName;
    }

    public void setJDTTicketSoap12WSDDServiceName(java.lang.String name) {
        JDTTicketSoap12WSDDServiceName = name;
    }

    public com.aiton.bmpw.Webservice.JDTTicketSoap_PortType getJDTTicketSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(JDTTicketSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getJDTTicketSoap12(endpoint);
    }

    public com.aiton.bmpw.Webservice.JDTTicketSoap_PortType getJDTTicketSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.aiton.bmpw.Webservice.JDTTicketSoap12Stub _stub = new com.aiton.bmpw.Webservice.JDTTicketSoap12Stub(portAddress, this);
            _stub.setPortName(getJDTTicketSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setJDTTicketSoap12EndpointAddress(java.lang.String address) {
        JDTTicketSoap12_address = address;
    }


    // Use to get a proxy class for JDTTicketSoap
    private java.lang.String JDTTicketSoap_address = "http://www.aiton.com.cn:808/JDTTicket.asmx";

    public java.lang.String getJDTTicketSoapAddress() {
        return JDTTicketSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String JDTTicketSoapWSDDServiceName = "JDTTicketSoap";

    public java.lang.String getJDTTicketSoapWSDDServiceName() {
        return JDTTicketSoapWSDDServiceName;
    }

    public void setJDTTicketSoapWSDDServiceName(java.lang.String name) {
        JDTTicketSoapWSDDServiceName = name;
    }

    public com.aiton.bmpw.Webservice.JDTTicketSoap_PortType getJDTTicketSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(JDTTicketSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getJDTTicketSoap(endpoint);
    }

    public com.aiton.bmpw.Webservice.JDTTicketSoap_PortType getJDTTicketSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.aiton.bmpw.Webservice.JDTTicketSoap_BindingStub _stub = new com.aiton.bmpw.Webservice.JDTTicketSoap_BindingStub(portAddress, this);
            _stub.setPortName(getJDTTicketSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setJDTTicketSoapEndpointAddress(java.lang.String address) {
        JDTTicketSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.aiton.bmpw.Webservice.JDTTicketSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.aiton.bmpw.Webservice.JDTTicketSoap12Stub _stub = new com.aiton.bmpw.Webservice.JDTTicketSoap12Stub(new java.net.URL(JDTTicketSoap12_address), this);
                _stub.setPortName(getJDTTicketSoap12WSDDServiceName());
                return _stub;
            }
            if (com.aiton.bmpw.Webservice.JDTTicketSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.aiton.bmpw.Webservice.JDTTicketSoap_BindingStub _stub = new com.aiton.bmpw.Webservice.JDTTicketSoap_BindingStub(new java.net.URL(JDTTicketSoap_address), this);
                _stub.setPortName(getJDTTicketSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("JDTTicketSoap12".equals(inputPortName)) {
            return getJDTTicketSoap12();
        }
        else if ("JDTTicketSoap".equals(inputPortName)) {
            return getJDTTicketSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "JDTTicket");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "JDTTicketSoap12"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "JDTTicketSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("JDTTicketSoap12".equals(portName)) {
            setJDTTicketSoap12EndpointAddress(address);
        }
        else 
if ("JDTTicketSoap".equals(portName)) {
            setJDTTicketSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
