<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://tempuri.org/" xmlns:s2="http://tempuri.org/AbstractTypes" xmlns:s1="XMJDT online ticket web service" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" targetNamespace="http://tempuri.org/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://tempuri.org/">
      <s:import namespace="XMJDT online ticket web service" />
      <s:element name="GetL1Companys">
        <s:complexType />
      </s:element>
      <s:element name="GetL1CompanysResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetL1CompanysResult" type="tns:ArrayOfL1Company" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfL1Company">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="L1Company" nillable="true" type="s1:L1Company" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetCompanyStationsByZone">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="companyCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="zoneCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetCompanyStationsByZoneResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetCompanyStationsByZoneResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetBookTicketState">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="getTicketCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetBookTicketStateResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetBookTicketStateResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetExecuteScheduleSeats">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="scheduleCompanyCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="executeScheduleID" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetExecuteScheduleSeatsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetExecuteScheduleSeatsResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetCompanyAllStations">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="companyCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetCompanyAllStationsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetCompanyAllStationsResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetSellableScheduleByStartCityName">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="executeDate" type="s:dateTime" />
            <s:element minOccurs="0" maxOccurs="1" name="startCityName" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="endSiteNamePart" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetSellableScheduleByStartCityNameResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetSellableScheduleByStartCityNameResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SellTicket_NoBill">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="scheduleCompanyCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="executeScheduleID" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="startSiteID" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="endSiteID" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="fullTickets" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="halfTicket" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="carryChild" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="phoneNumber" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="passengerIdentitys" type="tns:ArrayOfString" />
            <s:element minOccurs="0" maxOccurs="1" name="passengerNames" type="tns:ArrayOfString" />
            <s:element minOccurs="1" maxOccurs="1" name="insured" type="s:boolean" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfString">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="string" nillable="true" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="SellTicket_NoBillResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SellTicket_NoBillResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SellTicket_NoBill_Booking">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="scheduleCompanyCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="executeScheduleID" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="startSiteID" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="endSiteID" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="fullTickets" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="halfTicket" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="carryChild" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="phoneNumber" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="passengerIdentitys" type="tns:ArrayOfString" />
            <s:element minOccurs="0" maxOccurs="1" name="passengerNames" type="tns:ArrayOfString" />
            <s:element minOccurs="1" maxOccurs="1" name="insured" type="s:boolean" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SellTicket_NoBill_BookingResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SellTicket_NoBill_BookingResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SellTicket_NoBill_Cancel">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="scheduleCompanyCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="bookLogAID" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SellTicket_NoBill_CancelResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SellTicket_NoBill_CancelResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SellTicket_NoBill_Confirm">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="scheduleCompanyCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="bookLogAID" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SellTicket_NoBill_ConfirmResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SellTicket_NoBill_ConfirmResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirm">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="scheduleCompanyCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="bookLogID" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirmResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirmResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetBookTicketStateByBookTicketAID">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="bookTicketAID" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetBookTicketStateByBookTicketAIDResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetBookTicketStateByBookTicketAIDResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetBounceTicketChargeByBookLogAID">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="bookTicketAID" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetBounceTicketChargeByBookLogAIDResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetBounceTicketChargeByBookLogAIDResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ExecuteBounceTicketByBookLogAID">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="bookTicketAID" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ExecuteBounceTicketByBookLogAIDResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ExecuteBounceTicketByBookLogAIDResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ResignSchedule">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="scheduleCompanyCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ticketID" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="executeScheduleID" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="startSiteID" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="endSiteID" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ResignScheduleResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ResignScheduleResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="BlankoutTicket">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="scheduleCompanyCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="ticketID" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="BlankoutTicketResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="BlankoutTicketResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMySelledTickets">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="startDate" type="s:dateTime" />
            <s:element minOccurs="1" maxOccurs="1" name="endDate" type="s:dateTime" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMySelledTicketsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetMySelledTicketsResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMySelledTickets_AccountChecking">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="startDate" type="s:dateTime" />
            <s:element minOccurs="1" maxOccurs="1" name="endDate" type="s:dateTime" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMySelledTickets_AccountCheckingResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetMySelledTickets_AccountCheckingResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetBookLogBy_DateSellerCompanyCode">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="startDate" type="s:dateTime" />
            <s:element minOccurs="1" maxOccurs="1" name="endDate" type="s:dateTime" />
            <s:element minOccurs="0" maxOccurs="1" name="scheduleCompanyCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetBookLogBy_DateSellerCompanyCodeResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetBookLogBy_DateSellerCompanyCodeResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetBookLogBy_DateSellerCompanyCode_ConfirmedOnly">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="startDate" type="s:dateTime" />
            <s:element minOccurs="1" maxOccurs="1" name="endDate" type="s:dateTime" />
            <s:element minOccurs="0" maxOccurs="1" name="scheduleCompanyCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetBookLogBy_DateSellerCompanyCode_ConfirmedOnlyResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetBookLogBy_DateSellerCompanyCode_ConfirmedOnlyResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetTakeTicketLogByCode">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="getTicketCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetTakeTicketLogByCodeResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetTakeTicketLogByCodeResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMyDeposits">
        <s:complexType />
      </s:element>
      <s:element name="GetMyDepositsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetMyDepositsResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMySelledTickets_NonConfirmed">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="startDate" type="s:dateTime" />
            <s:element minOccurs="1" maxOccurs="1" name="endDate" type="s:dateTime" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetMySelledTickets_NonConfirmedResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetMySelledTickets_NonConfirmedResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetCompanyEndSiteByZone">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="scheduleCompanyCode" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="zoneID" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetCompanyEndSiteByZoneResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetCompanyEndSiteByZoneResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetExecuteScheduleInfoForSellByID">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="scheduleCompanyCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="executeScheduleID" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="startSiteID" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="endSiteID" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetExecuteScheduleInfoForSellByIDResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetExecuteScheduleInfoForSellByIDResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetAllSchedule">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="scheduleCompanyCode" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="executeDate" type="s:dateTime" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetAllScheduleResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetAllScheduleResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="QuerySellTicketResult">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="scheduleCompanyCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="executeScheduleID" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="startSiteID" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="endSiteID" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="fullTickets" type="s:int" />
            <s:element minOccurs="1" maxOccurs="1" name="carryChild" type="s:int" />
            <s:element minOccurs="0" maxOccurs="1" name="phoneNumber" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="QuerySellTicketResultResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="QuerySellTicketResultResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetTicketByBillNumber">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="startNumber" type="s:long" />
            <s:element minOccurs="1" maxOccurs="1" name="endNumber" type="s:long" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetTicketByBillNumberResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetTicketByBillNumberResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetAuthorL1Companys">
        <s:complexType />
      </s:element>
      <s:element name="GetAuthorL1CompanysResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetAuthorL1CompanysResult" type="tns:ArrayOfL1Company" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetAvailableZones">
        <s:complexType />
      </s:element>
      <s:element name="GetAvailableZonesResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetAvailableZonesResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetCompanySubZone">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="companyCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetCompanySubZoneResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetCompanySubZoneResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="QueryTicket">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="getTicketCodeOrAID" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="QueryTicketResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="QueryTicketResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="QueryBookLog">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="getTicketCodeOrAID" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="QueryBookLogResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="QueryBookLogResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetZonesTree">
        <s:complexType />
      </s:element>
      <s:element name="GetZonesTreeResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetZonesTreeResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetZones">
        <s:complexType />
      </s:element>
      <s:element name="GetZonesResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetZonesResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetStationSiteID">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="companyCode" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetStationSiteIDResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetStationSiteIDResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetSites">
        <s:complexType />
      </s:element>
      <s:element name="GetSitesResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetSitesResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetSellableSchedule_1410">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="scheduleCompanyCode" type="s:string" />
            <s:element minOccurs="1" maxOccurs="1" name="executeDate" type="s:dateTime" />
            <s:element minOccurs="0" maxOccurs="1" name="startSiteNamePart" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="endSiteNamePart" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetSellableSchedule_1410Response">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetSellableSchedule_1410Result" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ConfirmTicket">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ticketIDs" type="tns:ArrayOfString" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ConfirmTicketResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ConfirmTicketResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ClearDataPersistence">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="adminPassword" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ClearDataPersistenceResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="ClearDataPersistenceResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="CheckCompanyIdentity">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="companyCode" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="password" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="CheckCompanyIdentityResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="CheckCompanyIdentityResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ArrayOfL1Company" nillable="true" type="tns:ArrayOfL1Company" />
      <s:element name="string" nillable="true" type="s:string" />
    </s:schema>
    <s:schema elementFormDefault="qualified" targetNamespace="XMJDT online ticket web service">
      <s:complexType name="L1Company">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="AID" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="CompanyName" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ZoneCode" type="s:string" />
        </s:sequence>
      </s:complexType>
    </s:schema>
    <s:schema targetNamespace="http://tempuri.org/AbstractTypes">
      <s:import namespace="http://schemas.xmlsoap.org/soap/encoding/" />
      <s:complexType name="StringArray">
        <s:complexContent mixed="false">
          <s:restriction base="soapenc:Array">
            <s:sequence>
              <s:element minOccurs="0" maxOccurs="unbounded" name="String" type="s:string" />
            </s:sequence>
          </s:restriction>
        </s:complexContent>
      </s:complexType>
    </s:schema>
  </wsdl:types>
  <wsdl:message name="GetL1CompanysSoapIn">
    <wsdl:part name="parameters" element="tns:GetL1Companys" />
  </wsdl:message>
  <wsdl:message name="GetL1CompanysSoapOut">
    <wsdl:part name="parameters" element="tns:GetL1CompanysResponse" />
  </wsdl:message>
  <wsdl:message name="GetCompanyStationsByZoneSoapIn">
    <wsdl:part name="parameters" element="tns:GetCompanyStationsByZone" />
  </wsdl:message>
  <wsdl:message name="GetCompanyStationsByZoneSoapOut">
    <wsdl:part name="parameters" element="tns:GetCompanyStationsByZoneResponse" />
  </wsdl:message>
  <wsdl:message name="GetBookTicketStateSoapIn">
    <wsdl:part name="parameters" element="tns:GetBookTicketState" />
  </wsdl:message>
  <wsdl:message name="GetBookTicketStateSoapOut">
    <wsdl:part name="parameters" element="tns:GetBookTicketStateResponse" />
  </wsdl:message>
  <wsdl:message name="GetExecuteScheduleSeatsSoapIn">
    <wsdl:part name="parameters" element="tns:GetExecuteScheduleSeats" />
  </wsdl:message>
  <wsdl:message name="GetExecuteScheduleSeatsSoapOut">
    <wsdl:part name="parameters" element="tns:GetExecuteScheduleSeatsResponse" />
  </wsdl:message>
  <wsdl:message name="GetCompanyAllStationsSoapIn">
    <wsdl:part name="parameters" element="tns:GetCompanyAllStations" />
  </wsdl:message>
  <wsdl:message name="GetCompanyAllStationsSoapOut">
    <wsdl:part name="parameters" element="tns:GetCompanyAllStationsResponse" />
  </wsdl:message>
  <wsdl:message name="GetSellableScheduleByStartCityNameSoapIn">
    <wsdl:part name="parameters" element="tns:GetSellableScheduleByStartCityName" />
  </wsdl:message>
  <wsdl:message name="GetSellableScheduleByStartCityNameSoapOut">
    <wsdl:part name="parameters" element="tns:GetSellableScheduleByStartCityNameResponse" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBillSoapIn">
    <wsdl:part name="parameters" element="tns:SellTicket_NoBill" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBillSoapOut">
    <wsdl:part name="parameters" element="tns:SellTicket_NoBillResponse" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_BookingSoapIn">
    <wsdl:part name="parameters" element="tns:SellTicket_NoBill_Booking" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_BookingSoapOut">
    <wsdl:part name="parameters" element="tns:SellTicket_NoBill_BookingResponse" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_CancelSoapIn">
    <wsdl:part name="parameters" element="tns:SellTicket_NoBill_Cancel" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_CancelSoapOut">
    <wsdl:part name="parameters" element="tns:SellTicket_NoBill_CancelResponse" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_ConfirmSoapIn">
    <wsdl:part name="parameters" element="tns:SellTicket_NoBill_Confirm" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_ConfirmSoapOut">
    <wsdl:part name="parameters" element="tns:SellTicket_NoBill_ConfirmResponse" />
  </wsdl:message>
  <wsdl:message name="SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirmSoapIn">
    <wsdl:part name="parameters" element="tns:SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirm" />
  </wsdl:message>
  <wsdl:message name="SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirmSoapOut">
    <wsdl:part name="parameters" element="tns:SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirmResponse" />
  </wsdl:message>
  <wsdl:message name="GetBookTicketStateByBookTicketAIDSoapIn">
    <wsdl:part name="parameters" element="tns:GetBookTicketStateByBookTicketAID" />
  </wsdl:message>
  <wsdl:message name="GetBookTicketStateByBookTicketAIDSoapOut">
    <wsdl:part name="parameters" element="tns:GetBookTicketStateByBookTicketAIDResponse" />
  </wsdl:message>
  <wsdl:message name="GetBounceTicketChargeByBookLogAIDSoapIn">
    <wsdl:part name="parameters" element="tns:GetBounceTicketChargeByBookLogAID" />
  </wsdl:message>
  <wsdl:message name="GetBounceTicketChargeByBookLogAIDSoapOut">
    <wsdl:part name="parameters" element="tns:GetBounceTicketChargeByBookLogAIDResponse" />
  </wsdl:message>
  <wsdl:message name="ExecuteBounceTicketByBookLogAIDSoapIn">
    <wsdl:part name="parameters" element="tns:ExecuteBounceTicketByBookLogAID" />
  </wsdl:message>
  <wsdl:message name="ExecuteBounceTicketByBookLogAIDSoapOut">
    <wsdl:part name="parameters" element="tns:ExecuteBounceTicketByBookLogAIDResponse" />
  </wsdl:message>
  <wsdl:message name="ResignScheduleSoapIn">
    <wsdl:part name="parameters" element="tns:ResignSchedule" />
  </wsdl:message>
  <wsdl:message name="ResignScheduleSoapOut">
    <wsdl:part name="parameters" element="tns:ResignScheduleResponse" />
  </wsdl:message>
  <wsdl:message name="BlankoutTicketSoapIn">
    <wsdl:part name="parameters" element="tns:BlankoutTicket" />
  </wsdl:message>
  <wsdl:message name="BlankoutTicketSoapOut">
    <wsdl:part name="parameters" element="tns:BlankoutTicketResponse" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTicketsSoapIn">
    <wsdl:part name="parameters" element="tns:GetMySelledTickets" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTicketsSoapOut">
    <wsdl:part name="parameters" element="tns:GetMySelledTicketsResponse" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTickets_AccountCheckingSoapIn">
    <wsdl:part name="parameters" element="tns:GetMySelledTickets_AccountChecking" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTickets_AccountCheckingSoapOut">
    <wsdl:part name="parameters" element="tns:GetMySelledTickets_AccountCheckingResponse" />
  </wsdl:message>
  <wsdl:message name="GetBookLogBy_DateSellerCompanyCodeSoapIn">
    <wsdl:part name="parameters" element="tns:GetBookLogBy_DateSellerCompanyCode" />
  </wsdl:message>
  <wsdl:message name="GetBookLogBy_DateSellerCompanyCodeSoapOut">
    <wsdl:part name="parameters" element="tns:GetBookLogBy_DateSellerCompanyCodeResponse" />
  </wsdl:message>
  <wsdl:message name="GetBookLogBy_DateSellerCompanyCode_ConfirmedOnlySoapIn">
    <wsdl:part name="parameters" element="tns:GetBookLogBy_DateSellerCompanyCode_ConfirmedOnly" />
  </wsdl:message>
  <wsdl:message name="GetBookLogBy_DateSellerCompanyCode_ConfirmedOnlySoapOut">
    <wsdl:part name="parameters" element="tns:GetBookLogBy_DateSellerCompanyCode_ConfirmedOnlyResponse" />
  </wsdl:message>
  <wsdl:message name="GetTakeTicketLogByCodeSoapIn">
    <wsdl:part name="parameters" element="tns:GetTakeTicketLogByCode" />
  </wsdl:message>
  <wsdl:message name="GetTakeTicketLogByCodeSoapOut">
    <wsdl:part name="parameters" element="tns:GetTakeTicketLogByCodeResponse" />
  </wsdl:message>
  <wsdl:message name="GetMyDepositsSoapIn">
    <wsdl:part name="parameters" element="tns:GetMyDeposits" />
  </wsdl:message>
  <wsdl:message name="GetMyDepositsSoapOut">
    <wsdl:part name="parameters" element="tns:GetMyDepositsResponse" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTickets_NonConfirmedSoapIn">
    <wsdl:part name="parameters" element="tns:GetMySelledTickets_NonConfirmed" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTickets_NonConfirmedSoapOut">
    <wsdl:part name="parameters" element="tns:GetMySelledTickets_NonConfirmedResponse" />
  </wsdl:message>
  <wsdl:message name="GetCompanyEndSiteByZoneSoapIn">
    <wsdl:part name="parameters" element="tns:GetCompanyEndSiteByZone" />
  </wsdl:message>
  <wsdl:message name="GetCompanyEndSiteByZoneSoapOut">
    <wsdl:part name="parameters" element="tns:GetCompanyEndSiteByZoneResponse" />
  </wsdl:message>
  <wsdl:message name="GetExecuteScheduleInfoForSellByIDSoapIn">
    <wsdl:part name="parameters" element="tns:GetExecuteScheduleInfoForSellByID" />
  </wsdl:message>
  <wsdl:message name="GetExecuteScheduleInfoForSellByIDSoapOut">
    <wsdl:part name="parameters" element="tns:GetExecuteScheduleInfoForSellByIDResponse" />
  </wsdl:message>
  <wsdl:message name="GetAllScheduleSoapIn">
    <wsdl:part name="parameters" element="tns:GetAllSchedule" />
  </wsdl:message>
  <wsdl:message name="GetAllScheduleSoapOut">
    <wsdl:part name="parameters" element="tns:GetAllScheduleResponse" />
  </wsdl:message>
  <wsdl:message name="QuerySellTicketResultSoapIn">
    <wsdl:part name="parameters" element="tns:QuerySellTicketResult" />
  </wsdl:message>
  <wsdl:message name="QuerySellTicketResultSoapOut">
    <wsdl:part name="parameters" element="tns:QuerySellTicketResultResponse" />
  </wsdl:message>
  <wsdl:message name="GetTicketByBillNumberSoapIn">
    <wsdl:part name="parameters" element="tns:GetTicketByBillNumber" />
  </wsdl:message>
  <wsdl:message name="GetTicketByBillNumberSoapOut">
    <wsdl:part name="parameters" element="tns:GetTicketByBillNumberResponse" />
  </wsdl:message>
  <wsdl:message name="GetAuthorL1CompanysSoapIn">
    <wsdl:part name="parameters" element="tns:GetAuthorL1Companys" />
  </wsdl:message>
  <wsdl:message name="GetAuthorL1CompanysSoapOut">
    <wsdl:part name="parameters" element="tns:GetAuthorL1CompanysResponse" />
  </wsdl:message>
  <wsdl:message name="GetAvailableZonesSoapIn">
    <wsdl:part name="parameters" element="tns:GetAvailableZones" />
  </wsdl:message>
  <wsdl:message name="GetAvailableZonesSoapOut">
    <wsdl:part name="parameters" element="tns:GetAvailableZonesResponse" />
  </wsdl:message>
  <wsdl:message name="GetCompanySubZoneSoapIn">
    <wsdl:part name="parameters" element="tns:GetCompanySubZone" />
  </wsdl:message>
  <wsdl:message name="GetCompanySubZoneSoapOut">
    <wsdl:part name="parameters" element="tns:GetCompanySubZoneResponse" />
  </wsdl:message>
  <wsdl:message name="QueryTicketSoapIn">
    <wsdl:part name="parameters" element="tns:QueryTicket" />
  </wsdl:message>
  <wsdl:message name="QueryTicketSoapOut">
    <wsdl:part name="parameters" element="tns:QueryTicketResponse" />
  </wsdl:message>
  <wsdl:message name="QueryBookLogSoapIn">
    <wsdl:part name="parameters" element="tns:QueryBookLog" />
  </wsdl:message>
  <wsdl:message name="QueryBookLogSoapOut">
    <wsdl:part name="parameters" element="tns:QueryBookLogResponse" />
  </wsdl:message>
  <wsdl:message name="GetZonesTreeSoapIn">
    <wsdl:part name="parameters" element="tns:GetZonesTree" />
  </wsdl:message>
  <wsdl:message name="GetZonesTreeSoapOut">
    <wsdl:part name="parameters" element="tns:GetZonesTreeResponse" />
  </wsdl:message>
  <wsdl:message name="GetZonesSoapIn">
    <wsdl:part name="parameters" element="tns:GetZones" />
  </wsdl:message>
  <wsdl:message name="GetZonesSoapOut">
    <wsdl:part name="parameters" element="tns:GetZonesResponse" />
  </wsdl:message>
  <wsdl:message name="GetStationSiteIDSoapIn">
    <wsdl:part name="parameters" element="tns:GetStationSiteID" />
  </wsdl:message>
  <wsdl:message name="GetStationSiteIDSoapOut">
    <wsdl:part name="parameters" element="tns:GetStationSiteIDResponse" />
  </wsdl:message>
  <wsdl:message name="GetSitesSoapIn">
    <wsdl:part name="parameters" element="tns:GetSites" />
  </wsdl:message>
  <wsdl:message name="GetSitesSoapOut">
    <wsdl:part name="parameters" element="tns:GetSitesResponse" />
  </wsdl:message>
  <wsdl:message name="GetSellableSchedule_1410SoapIn">
    <wsdl:part name="parameters" element="tns:GetSellableSchedule_1410" />
  </wsdl:message>
  <wsdl:message name="GetSellableSchedule_1410SoapOut">
    <wsdl:part name="parameters" element="tns:GetSellableSchedule_1410Response" />
  </wsdl:message>
  <wsdl:message name="ConfirmTicketSoapIn">
    <wsdl:part name="parameters" element="tns:ConfirmTicket" />
  </wsdl:message>
  <wsdl:message name="ConfirmTicketSoapOut">
    <wsdl:part name="parameters" element="tns:ConfirmTicketResponse" />
  </wsdl:message>
  <wsdl:message name="ClearDataPersistenceSoapIn">
    <wsdl:part name="parameters" element="tns:ClearDataPersistence" />
  </wsdl:message>
  <wsdl:message name="ClearDataPersistenceSoapOut">
    <wsdl:part name="parameters" element="tns:ClearDataPersistenceResponse" />
  </wsdl:message>
  <wsdl:message name="CheckCompanyIdentitySoapIn">
    <wsdl:part name="parameters" element="tns:CheckCompanyIdentity" />
  </wsdl:message>
  <wsdl:message name="CheckCompanyIdentitySoapOut">
    <wsdl:part name="parameters" element="tns:CheckCompanyIdentityResponse" />
  </wsdl:message>
  <wsdl:message name="GetL1CompanysHttpGetIn" />
  <wsdl:message name="GetL1CompanysHttpGetOut">
    <wsdl:part name="Body" element="tns:ArrayOfL1Company" />
  </wsdl:message>
  <wsdl:message name="GetCompanyStationsByZoneHttpGetIn">
    <wsdl:part name="companyCode" type="s:string" />
    <wsdl:part name="zoneCode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetCompanyStationsByZoneHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetBookTicketStateHttpGetIn">
    <wsdl:part name="getTicketCode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetBookTicketStateHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetExecuteScheduleSeatsHttpGetIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="executeScheduleID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetExecuteScheduleSeatsHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetCompanyAllStationsHttpGetIn">
    <wsdl:part name="companyCode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetCompanyAllStationsHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetSellableScheduleByStartCityNameHttpGetIn">
    <wsdl:part name="executeDate" type="s:string" />
    <wsdl:part name="startCityName" type="s:string" />
    <wsdl:part name="endSiteNamePart" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetSellableScheduleByStartCityNameHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBillHttpGetIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="executeScheduleID" type="s:string" />
    <wsdl:part name="startSiteID" type="s:string" />
    <wsdl:part name="endSiteID" type="s:string" />
    <wsdl:part name="fullTickets" type="s:string" />
    <wsdl:part name="halfTicket" type="s:string" />
    <wsdl:part name="carryChild" type="s:string" />
    <wsdl:part name="phoneNumber" type="s:string" />
    <wsdl:part name="passengerIdentitys" type="s2:StringArray" />
    <wsdl:part name="passengerNames" type="s2:StringArray" />
    <wsdl:part name="insured" type="s:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBillHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_BookingHttpGetIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="executeScheduleID" type="s:string" />
    <wsdl:part name="startSiteID" type="s:string" />
    <wsdl:part name="endSiteID" type="s:string" />
    <wsdl:part name="fullTickets" type="s:string" />
    <wsdl:part name="halfTicket" type="s:string" />
    <wsdl:part name="carryChild" type="s:string" />
    <wsdl:part name="phoneNumber" type="s:string" />
    <wsdl:part name="passengerIdentitys" type="s2:StringArray" />
    <wsdl:part name="passengerNames" type="s2:StringArray" />
    <wsdl:part name="insured" type="s:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_BookingHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_CancelHttpGetIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="bookLogAID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_CancelHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_ConfirmHttpGetIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="bookLogAID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_ConfirmHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirmHttpGetIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="bookLogID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirmHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetBookTicketStateByBookTicketAIDHttpGetIn">
    <wsdl:part name="bookTicketAID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetBookTicketStateByBookTicketAIDHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetBounceTicketChargeByBookLogAIDHttpGetIn">
    <wsdl:part name="bookTicketAID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetBounceTicketChargeByBookLogAIDHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="ExecuteBounceTicketByBookLogAIDHttpGetIn">
    <wsdl:part name="bookTicketAID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="ExecuteBounceTicketByBookLogAIDHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="ResignScheduleHttpGetIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="ticketID" type="s:string" />
    <wsdl:part name="executeScheduleID" type="s:string" />
    <wsdl:part name="startSiteID" type="s:string" />
    <wsdl:part name="endSiteID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="ResignScheduleHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="BlankoutTicketHttpGetIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="ticketID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="BlankoutTicketHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTicketsHttpGetIn">
    <wsdl:part name="startDate" type="s:string" />
    <wsdl:part name="endDate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTicketsHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTickets_AccountCheckingHttpGetIn">
    <wsdl:part name="startDate" type="s:string" />
    <wsdl:part name="endDate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTickets_AccountCheckingHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetBookLogBy_DateSellerCompanyCodeHttpGetIn">
    <wsdl:part name="startDate" type="s:string" />
    <wsdl:part name="endDate" type="s:string" />
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetBookLogBy_DateSellerCompanyCodeHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetBookLogBy_DateSellerCompanyCode_ConfirmedOnlyHttpGetIn">
    <wsdl:part name="startDate" type="s:string" />
    <wsdl:part name="endDate" type="s:string" />
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetBookLogBy_DateSellerCompanyCode_ConfirmedOnlyHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetTakeTicketLogByCodeHttpGetIn">
    <wsdl:part name="getTicketCode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetTakeTicketLogByCodeHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetMyDepositsHttpGetIn" />
  <wsdl:message name="GetMyDepositsHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTickets_NonConfirmedHttpGetIn">
    <wsdl:part name="startDate" type="s:string" />
    <wsdl:part name="endDate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTickets_NonConfirmedHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetCompanyEndSiteByZoneHttpGetIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="zoneID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetCompanyEndSiteByZoneHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetExecuteScheduleInfoForSellByIDHttpGetIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="executeScheduleID" type="s:string" />
    <wsdl:part name="startSiteID" type="s:string" />
    <wsdl:part name="endSiteID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetExecuteScheduleInfoForSellByIDHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetAllScheduleHttpGetIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="executeDate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetAllScheduleHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="QuerySellTicketResultHttpGetIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="executeScheduleID" type="s:string" />
    <wsdl:part name="startSiteID" type="s:string" />
    <wsdl:part name="endSiteID" type="s:string" />
    <wsdl:part name="fullTickets" type="s:string" />
    <wsdl:part name="carryChild" type="s:string" />
    <wsdl:part name="phoneNumber" type="s:string" />
  </wsdl:message>
  <wsdl:message name="QuerySellTicketResultHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetTicketByBillNumberHttpGetIn">
    <wsdl:part name="startNumber" type="s:string" />
    <wsdl:part name="endNumber" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetTicketByBillNumberHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetAuthorL1CompanysHttpGetIn" />
  <wsdl:message name="GetAuthorL1CompanysHttpGetOut">
    <wsdl:part name="Body" element="tns:ArrayOfL1Company" />
  </wsdl:message>
  <wsdl:message name="GetAvailableZonesHttpGetIn" />
  <wsdl:message name="GetAvailableZonesHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetCompanySubZoneHttpGetIn">
    <wsdl:part name="companyCode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetCompanySubZoneHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="QueryTicketHttpGetIn">
    <wsdl:part name="getTicketCodeOrAID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="QueryTicketHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="QueryBookLogHttpGetIn">
    <wsdl:part name="getTicketCodeOrAID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="QueryBookLogHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetZonesTreeHttpGetIn" />
  <wsdl:message name="GetZonesTreeHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetZonesHttpGetIn" />
  <wsdl:message name="GetZonesHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetStationSiteIDHttpGetIn">
    <wsdl:part name="companyCode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetStationSiteIDHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetSitesHttpGetIn" />
  <wsdl:message name="GetSitesHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetSellableSchedule_1410HttpGetIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="executeDate" type="s:string" />
    <wsdl:part name="startSiteNamePart" type="s:string" />
    <wsdl:part name="endSiteNamePart" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetSellableSchedule_1410HttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="ConfirmTicketHttpGetIn">
    <wsdl:part name="ticketIDs" type="s2:StringArray" />
  </wsdl:message>
  <wsdl:message name="ConfirmTicketHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="ClearDataPersistenceHttpGetIn">
    <wsdl:part name="adminPassword" type="s:string" />
  </wsdl:message>
  <wsdl:message name="ClearDataPersistenceHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="CheckCompanyIdentityHttpGetIn">
    <wsdl:part name="companyCode" type="s:string" />
    <wsdl:part name="password" type="s:string" />
  </wsdl:message>
  <wsdl:message name="CheckCompanyIdentityHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetL1CompanysHttpPostIn" />
  <wsdl:message name="GetL1CompanysHttpPostOut">
    <wsdl:part name="Body" element="tns:ArrayOfL1Company" />
  </wsdl:message>
  <wsdl:message name="GetCompanyStationsByZoneHttpPostIn">
    <wsdl:part name="companyCode" type="s:string" />
    <wsdl:part name="zoneCode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetCompanyStationsByZoneHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetBookTicketStateHttpPostIn">
    <wsdl:part name="getTicketCode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetBookTicketStateHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetExecuteScheduleSeatsHttpPostIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="executeScheduleID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetExecuteScheduleSeatsHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetCompanyAllStationsHttpPostIn">
    <wsdl:part name="companyCode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetCompanyAllStationsHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetSellableScheduleByStartCityNameHttpPostIn">
    <wsdl:part name="executeDate" type="s:string" />
    <wsdl:part name="startCityName" type="s:string" />
    <wsdl:part name="endSiteNamePart" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetSellableScheduleByStartCityNameHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBillHttpPostIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="executeScheduleID" type="s:string" />
    <wsdl:part name="startSiteID" type="s:string" />
    <wsdl:part name="endSiteID" type="s:string" />
    <wsdl:part name="fullTickets" type="s:string" />
    <wsdl:part name="halfTicket" type="s:string" />
    <wsdl:part name="carryChild" type="s:string" />
    <wsdl:part name="phoneNumber" type="s:string" />
    <wsdl:part name="passengerIdentitys" type="s2:StringArray" />
    <wsdl:part name="passengerNames" type="s2:StringArray" />
    <wsdl:part name="insured" type="s:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBillHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_BookingHttpPostIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="executeScheduleID" type="s:string" />
    <wsdl:part name="startSiteID" type="s:string" />
    <wsdl:part name="endSiteID" type="s:string" />
    <wsdl:part name="fullTickets" type="s:string" />
    <wsdl:part name="halfTicket" type="s:string" />
    <wsdl:part name="carryChild" type="s:string" />
    <wsdl:part name="phoneNumber" type="s:string" />
    <wsdl:part name="passengerIdentitys" type="s2:StringArray" />
    <wsdl:part name="passengerNames" type="s2:StringArray" />
    <wsdl:part name="insured" type="s:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_BookingHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_CancelHttpPostIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="bookLogAID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_CancelHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_ConfirmHttpPostIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="bookLogAID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_NoBill_ConfirmHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirmHttpPostIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="bookLogID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirmHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetBookTicketStateByBookTicketAIDHttpPostIn">
    <wsdl:part name="bookTicketAID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetBookTicketStateByBookTicketAIDHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetBounceTicketChargeByBookLogAIDHttpPostIn">
    <wsdl:part name="bookTicketAID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetBounceTicketChargeByBookLogAIDHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="ExecuteBounceTicketByBookLogAIDHttpPostIn">
    <wsdl:part name="bookTicketAID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="ExecuteBounceTicketByBookLogAIDHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="ResignScheduleHttpPostIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="ticketID" type="s:string" />
    <wsdl:part name="executeScheduleID" type="s:string" />
    <wsdl:part name="startSiteID" type="s:string" />
    <wsdl:part name="endSiteID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="ResignScheduleHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="BlankoutTicketHttpPostIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="ticketID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="BlankoutTicketHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTicketsHttpPostIn">
    <wsdl:part name="startDate" type="s:string" />
    <wsdl:part name="endDate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTicketsHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTickets_AccountCheckingHttpPostIn">
    <wsdl:part name="startDate" type="s:string" />
    <wsdl:part name="endDate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTickets_AccountCheckingHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetBookLogBy_DateSellerCompanyCodeHttpPostIn">
    <wsdl:part name="startDate" type="s:string" />
    <wsdl:part name="endDate" type="s:string" />
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetBookLogBy_DateSellerCompanyCodeHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetBookLogBy_DateSellerCompanyCode_ConfirmedOnlyHttpPostIn">
    <wsdl:part name="startDate" type="s:string" />
    <wsdl:part name="endDate" type="s:string" />
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetBookLogBy_DateSellerCompanyCode_ConfirmedOnlyHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetTakeTicketLogByCodeHttpPostIn">
    <wsdl:part name="getTicketCode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetTakeTicketLogByCodeHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetMyDepositsHttpPostIn" />
  <wsdl:message name="GetMyDepositsHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTickets_NonConfirmedHttpPostIn">
    <wsdl:part name="startDate" type="s:string" />
    <wsdl:part name="endDate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetMySelledTickets_NonConfirmedHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetCompanyEndSiteByZoneHttpPostIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="zoneID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetCompanyEndSiteByZoneHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetExecuteScheduleInfoForSellByIDHttpPostIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="executeScheduleID" type="s:string" />
    <wsdl:part name="startSiteID" type="s:string" />
    <wsdl:part name="endSiteID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetExecuteScheduleInfoForSellByIDHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetAllScheduleHttpPostIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="executeDate" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetAllScheduleHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="QuerySellTicketResultHttpPostIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="executeScheduleID" type="s:string" />
    <wsdl:part name="startSiteID" type="s:string" />
    <wsdl:part name="endSiteID" type="s:string" />
    <wsdl:part name="fullTickets" type="s:string" />
    <wsdl:part name="carryChild" type="s:string" />
    <wsdl:part name="phoneNumber" type="s:string" />
  </wsdl:message>
  <wsdl:message name="QuerySellTicketResultHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetTicketByBillNumberHttpPostIn">
    <wsdl:part name="startNumber" type="s:string" />
    <wsdl:part name="endNumber" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetTicketByBillNumberHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetAuthorL1CompanysHttpPostIn" />
  <wsdl:message name="GetAuthorL1CompanysHttpPostOut">
    <wsdl:part name="Body" element="tns:ArrayOfL1Company" />
  </wsdl:message>
  <wsdl:message name="GetAvailableZonesHttpPostIn" />
  <wsdl:message name="GetAvailableZonesHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetCompanySubZoneHttpPostIn">
    <wsdl:part name="companyCode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetCompanySubZoneHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="QueryTicketHttpPostIn">
    <wsdl:part name="getTicketCodeOrAID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="QueryTicketHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="QueryBookLogHttpPostIn">
    <wsdl:part name="getTicketCodeOrAID" type="s:string" />
  </wsdl:message>
  <wsdl:message name="QueryBookLogHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetZonesTreeHttpPostIn" />
  <wsdl:message name="GetZonesTreeHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetZonesHttpPostIn" />
  <wsdl:message name="GetZonesHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetStationSiteIDHttpPostIn">
    <wsdl:part name="companyCode" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetStationSiteIDHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetSitesHttpPostIn" />
  <wsdl:message name="GetSitesHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetSellableSchedule_1410HttpPostIn">
    <wsdl:part name="scheduleCompanyCode" type="s:string" />
    <wsdl:part name="executeDate" type="s:string" />
    <wsdl:part name="startSiteNamePart" type="s:string" />
    <wsdl:part name="endSiteNamePart" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetSellableSchedule_1410HttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="ConfirmTicketHttpPostIn">
    <wsdl:part name="ticketIDs" type="s2:StringArray" />
  </wsdl:message>
  <wsdl:message name="ConfirmTicketHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="ClearDataPersistenceHttpPostIn">
    <wsdl:part name="adminPassword" type="s:string" />
  </wsdl:message>
  <wsdl:message name="ClearDataPersistenceHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="CheckCompanyIdentityHttpPostIn">
    <wsdl:part name="companyCode" type="s:string" />
    <wsdl:part name="password" type="s:string" />
  </wsdl:message>
  <wsdl:message name="CheckCompanyIdentityHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:portType name="JDTTicketSoap">
    <wsdl:operation name="GetL1Companys">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">授权可以销售车票的公司列表</wsdl:documentation>
      <wsdl:input message="tns:GetL1CompanysSoapIn" />
      <wsdl:output message="tns:GetL1CompanysSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCompanyStationsByZone">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询公司下属地区的乘车站</wsdl:documentation>
      <wsdl:input message="tns:GetCompanyStationsByZoneSoapIn" />
      <wsdl:output message="tns:GetCompanyStationsByZoneSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBookTicketState">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询订单和对应车票的状态返回值是状态的描述，用来给操作或客服人员识别。</wsdl:documentation>
      <wsdl:input message="tns:GetBookTicketStateSoapIn" />
      <wsdl:output message="tns:GetBookTicketStateSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetExecuteScheduleSeats">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查看选定班次的票位情况</wsdl:documentation>
      <wsdl:input message="tns:GetExecuteScheduleSeatsSoapIn" />
      <wsdl:output message="tns:GetExecuteScheduleSeatsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCompanyAllStations">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询公司所有的乘车站</wsdl:documentation>
      <wsdl:input message="tns:GetCompanyAllStationsSoapIn" />
      <wsdl:output message="tns:GetCompanyAllStationsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetSellableScheduleByStartCityName">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">按出发城市和目的地查询班次，如果同一个目的地有多个运输公司合并结果一起查询返回</wsdl:documentation>
      <wsdl:input message="tns:GetSellableScheduleByStartCityNameSoapIn" />
      <wsdl:output message="tns:GetSellableScheduleByStartCityNameSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">无票证售票，使用订票方式。这个函数一步完成下订单和确认订单的过程，没有中间等待</wsdl:documentation>
      <wsdl:input message="tns:SellTicket_NoBillSoapIn" />
      <wsdl:output message="tns:SellTicket_NoBillSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Booking">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">无票证售票，使用订票方式，下订单，订单需在指定时间内（默认20分钟）确认否则将被取消</wsdl:documentation>
      <wsdl:input message="tns:SellTicket_NoBill_BookingSoapIn" />
      <wsdl:output message="tns:SellTicket_NoBill_BookingSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Cancel">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">无票证售票，使用订票，支付失败后撤销订单</wsdl:documentation>
      <wsdl:input message="tns:SellTicket_NoBill_CancelSoapIn" />
      <wsdl:output message="tns:SellTicket_NoBill_CancelSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Confirm">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">无票证售票，使用订票，支付成功后确认订单</wsdl:documentation>
      <wsdl:input message="tns:SellTicket_NoBill_ConfirmSoapIn" />
      <wsdl:output message="tns:SellTicket_NoBill_ConfirmSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirm">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询订单的状态，并确定订单还有多少时间(分钟)可以进行支付确认，返回-100表示状态已经不是可以进行支付确认的状态 返回结果说明：1未确认(带确认剩余时间),2已确认,3已撤销,4已取票。返回结果有固定格式，用来给代理系统程序识别</wsdl:documentation>
      <wsdl:input message="tns:SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirmSoapIn" />
      <wsdl:output message="tns:SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirmSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBookTicketStateByBookTicketAID">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询订单和对应车票的状态, 返回值是状态的描述，用来给操作或客服人员识别。bookTicketAID订单数据的主键</wsdl:documentation>
      <wsdl:input message="tns:GetBookTicketStateByBookTicketAIDSoapIn" />
      <wsdl:output message="tns:GetBookTicketStateByBookTicketAIDSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBounceTicketChargeByBookLogAID">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询退票手续费,按单张车票</wsdl:documentation>
      <wsdl:input message="tns:GetBounceTicketChargeByBookLogAIDSoapIn" />
      <wsdl:output message="tns:GetBounceTicketChargeByBookLogAIDSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ExecuteBounceTicketByBookLogAID">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">退票手续费,按单张车票</wsdl:documentation>
      <wsdl:input message="tns:ExecuteBounceTicketByBookLogAIDSoapIn" />
      <wsdl:output message="tns:ExecuteBounceTicketByBookLogAIDSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ResignSchedule">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">改签</wsdl:documentation>
      <wsdl:input message="tns:ResignScheduleSoapIn" />
      <wsdl:output message="tns:ResignScheduleSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="BlankoutTicket">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">作废票</wsdl:documentation>
      <wsdl:input message="tns:BlankoutTicketSoapIn" />
      <wsdl:output message="tns:BlankoutTicketSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询售出票记录</wsdl:documentation>
      <wsdl:input message="tns:GetMySelledTicketsSoapIn" />
      <wsdl:output message="tns:GetMySelledTicketsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets_AccountChecking">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询本公司售出的车票,用于结算核对，结果中都是需要结算的车票，不需要结算的数据已经过滤</wsdl:documentation>
      <wsdl:input message="tns:GetMySelledTickets_AccountCheckingSoapIn" />
      <wsdl:output message="tns:GetMySelledTickets_AccountCheckingSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBookLogBy_DateSellerCompanyCode">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">根据售票公司和售票时间查询，包括所有状态  </wsdl:documentation>
      <wsdl:input message="tns:GetBookLogBy_DateSellerCompanyCodeSoapIn" />
      <wsdl:output message="tns:GetBookLogBy_DateSellerCompanyCodeSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBookLogBy_DateSellerCompanyCode_ConfirmedOnly">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">根据售票公司和售票时间查询订单，只包括确认过的，状态为 未取票和已取票的startDate开始日期endDate结束日期scheduleCompanyCode票源公司。null为查询全部票源公司</wsdl:documentation>
      <wsdl:input message="tns:GetBookLogBy_DateSellerCompanyCode_ConfirmedOnlySoapIn" />
      <wsdl:output message="tns:GetBookLogBy_DateSellerCompanyCode_ConfirmedOnlySoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetTakeTicketLogByCode">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查订单的取票操作过程,getTicketCode取票号</wsdl:documentation>
      <wsdl:input message="tns:GetTakeTicketLogByCodeSoapIn" />
      <wsdl:output message="tns:GetTakeTicketLogByCodeSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMyDeposits">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询保证金情况</wsdl:documentation>
      <wsdl:input message="tns:GetMyDepositsSoapIn" />
      <wsdl:output message="tns:GetMyDepositsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets_NonConfirmed">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询本公司售出的车票中未做二次确认的数据</wsdl:documentation>
      <wsdl:input message="tns:GetMySelledTickets_NonConfirmedSoapIn" />
      <wsdl:output message="tns:GetMySelledTickets_NonConfirmedSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCompanyEndSiteByZone">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">获取运输公司终点站设置下，特定地区范围内的终点站</wsdl:documentation>
      <wsdl:input message="tns:GetCompanyEndSiteByZoneSoapIn" />
      <wsdl:output message="tns:GetCompanyEndSiteByZoneSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetExecuteScheduleInfoForSellByID">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">根据班次主键和起点、站点ID查询班次scheduleCompanyCode班次公司代码executeScheduleID班次IDstartSiteID起点IDendSiteID终点ID</wsdl:documentation>
      <wsdl:input message="tns:GetExecuteScheduleInfoForSellByIDSoapIn" />
      <wsdl:output message="tns:GetExecuteScheduleInfoForSellByIDSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAllSchedule">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">导出所有班次.导出过程中，班次总票位不显示，班次剩余票数大于10张时显示10，小于等于10张时全部显示为5;;scheduleCompanyCode班次公司代码days日期，以和今天差值startSiteName起点名称</wsdl:documentation>
      <wsdl:input message="tns:GetAllScheduleSoapIn" />
      <wsdl:output message="tns:GetAllScheduleSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="QuerySellTicketResult">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">根据第三方代理售票的参数查询订单</wsdl:documentation>
      <wsdl:input message="tns:QuerySellTicketResultSoapIn" />
      <wsdl:output message="tns:QuerySellTicketResultSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetTicketByBillNumber">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">NONE</wsdl:documentation>
      <wsdl:input message="tns:GetTicketByBillNumberSoapIn" />
      <wsdl:output message="tns:GetTicketByBillNumberSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAuthorL1Companys">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">授权可以销售车票的公司列表</wsdl:documentation>
      <wsdl:input message="tns:GetAuthorL1CompanysSoapIn" />
      <wsdl:output message="tns:GetAuthorL1CompanysSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAvailableZones">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询可用的出发城市</wsdl:documentation>
      <wsdl:input message="tns:GetAvailableZonesSoapIn" />
      <wsdl:output message="tns:GetAvailableZonesSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCompanySubZone">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询公司所在地区的下级地区</wsdl:documentation>
      <wsdl:input message="tns:GetCompanySubZoneSoapIn" />
      <wsdl:output message="tns:GetCompanySubZoneSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="QueryTicket">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询某个票号或订单号的所有车票</wsdl:documentation>
      <wsdl:input message="tns:QueryTicketSoapIn" />
      <wsdl:output message="tns:QueryTicketSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="QueryBookLog">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询订单</wsdl:documentation>
      <wsdl:input message="tns:QueryBookLogSoapIn" />
      <wsdl:output message="tns:QueryBookLogSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetZonesTree">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询地区树</wsdl:documentation>
      <wsdl:input message="tns:GetZonesTreeSoapIn" />
      <wsdl:output message="tns:GetZonesTreeSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetZones">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">取得所有地区</wsdl:documentation>
      <wsdl:input message="tns:GetZonesSoapIn" />
      <wsdl:output message="tns:GetZonesSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetStationSiteID">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">取得站点ID</wsdl:documentation>
      <wsdl:input message="tns:GetStationSiteIDSoapIn" />
      <wsdl:output message="tns:GetStationSiteIDSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetSites">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">取得站点</wsdl:documentation>
      <wsdl:input message="tns:GetSitesSoapIn" />
      <wsdl:output message="tns:GetSitesSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetSellableSchedule_1410">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">得到可销售班次</wsdl:documentation>
      <wsdl:input message="tns:GetSellableSchedule_1410SoapIn" />
      <wsdl:output message="tns:GetSellableSchedule_1410SoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ConfirmTicket">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">确认订单</wsdl:documentation>
      <wsdl:input message="tns:ConfirmTicketSoapIn" />
      <wsdl:output message="tns:ConfirmTicketSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="ClearDataPersistence">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">清除数据对象</wsdl:documentation>
      <wsdl:input message="tns:ClearDataPersistenceSoapIn" />
      <wsdl:output message="tns:ClearDataPersistenceSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="CheckCompanyIdentity">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">检查公司数据</wsdl:documentation>
      <wsdl:input message="tns:CheckCompanyIdentitySoapIn" />
      <wsdl:output message="tns:CheckCompanyIdentitySoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="JDTTicketHttpGet">
    <wsdl:operation name="GetL1Companys">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">授权可以销售车票的公司列表</wsdl:documentation>
      <wsdl:input message="tns:GetL1CompanysHttpGetIn" />
      <wsdl:output message="tns:GetL1CompanysHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCompanyStationsByZone">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询公司下属地区的乘车站</wsdl:documentation>
      <wsdl:input message="tns:GetCompanyStationsByZoneHttpGetIn" />
      <wsdl:output message="tns:GetCompanyStationsByZoneHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBookTicketState">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询订单和对应车票的状态返回值是状态的描述，用来给操作或客服人员识别。</wsdl:documentation>
      <wsdl:input message="tns:GetBookTicketStateHttpGetIn" />
      <wsdl:output message="tns:GetBookTicketStateHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetExecuteScheduleSeats">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查看选定班次的票位情况</wsdl:documentation>
      <wsdl:input message="tns:GetExecuteScheduleSeatsHttpGetIn" />
      <wsdl:output message="tns:GetExecuteScheduleSeatsHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCompanyAllStations">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询公司所有的乘车站</wsdl:documentation>
      <wsdl:input message="tns:GetCompanyAllStationsHttpGetIn" />
      <wsdl:output message="tns:GetCompanyAllStationsHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetSellableScheduleByStartCityName">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">按出发城市和目的地查询班次，如果同一个目的地有多个运输公司合并结果一起查询返回</wsdl:documentation>
      <wsdl:input message="tns:GetSellableScheduleByStartCityNameHttpGetIn" />
      <wsdl:output message="tns:GetSellableScheduleByStartCityNameHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">无票证售票，使用订票方式。这个函数一步完成下订单和确认订单的过程，没有中间等待</wsdl:documentation>
      <wsdl:input message="tns:SellTicket_NoBillHttpGetIn" />
      <wsdl:output message="tns:SellTicket_NoBillHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Booking">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">无票证售票，使用订票方式，下订单，订单需在指定时间内（默认20分钟）确认否则将被取消</wsdl:documentation>
      <wsdl:input message="tns:SellTicket_NoBill_BookingHttpGetIn" />
      <wsdl:output message="tns:SellTicket_NoBill_BookingHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Cancel">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">无票证售票，使用订票，支付失败后撤销订单</wsdl:documentation>
      <wsdl:input message="tns:SellTicket_NoBill_CancelHttpGetIn" />
      <wsdl:output message="tns:SellTicket_NoBill_CancelHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Confirm">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">无票证售票，使用订票，支付成功后确认订单</wsdl:documentation>
      <wsdl:input message="tns:SellTicket_NoBill_ConfirmHttpGetIn" />
      <wsdl:output message="tns:SellTicket_NoBill_ConfirmHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirm">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询订单的状态，并确定订单还有多少时间(分钟)可以进行支付确认，返回-100表示状态已经不是可以进行支付确认的状态 返回结果说明：1未确认(带确认剩余时间),2已确认,3已撤销,4已取票。返回结果有固定格式，用来给代理系统程序识别</wsdl:documentation>
      <wsdl:input message="tns:SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirmHttpGetIn" />
      <wsdl:output message="tns:SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirmHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBookTicketStateByBookTicketAID">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询订单和对应车票的状态, 返回值是状态的描述，用来给操作或客服人员识别。bookTicketAID订单数据的主键</wsdl:documentation>
      <wsdl:input message="tns:GetBookTicketStateByBookTicketAIDHttpGetIn" />
      <wsdl:output message="tns:GetBookTicketStateByBookTicketAIDHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBounceTicketChargeByBookLogAID">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询退票手续费,按单张车票</wsdl:documentation>
      <wsdl:input message="tns:GetBounceTicketChargeByBookLogAIDHttpGetIn" />
      <wsdl:output message="tns:GetBounceTicketChargeByBookLogAIDHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="ExecuteBounceTicketByBookLogAID">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">退票手续费,按单张车票</wsdl:documentation>
      <wsdl:input message="tns:ExecuteBounceTicketByBookLogAIDHttpGetIn" />
      <wsdl:output message="tns:ExecuteBounceTicketByBookLogAIDHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="ResignSchedule">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">改签</wsdl:documentation>
      <wsdl:input message="tns:ResignScheduleHttpGetIn" />
      <wsdl:output message="tns:ResignScheduleHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="BlankoutTicket">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">作废票</wsdl:documentation>
      <wsdl:input message="tns:BlankoutTicketHttpGetIn" />
      <wsdl:output message="tns:BlankoutTicketHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询售出票记录</wsdl:documentation>
      <wsdl:input message="tns:GetMySelledTicketsHttpGetIn" />
      <wsdl:output message="tns:GetMySelledTicketsHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets_AccountChecking">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询本公司售出的车票,用于结算核对，结果中都是需要结算的车票，不需要结算的数据已经过滤</wsdl:documentation>
      <wsdl:input message="tns:GetMySelledTickets_AccountCheckingHttpGetIn" />
      <wsdl:output message="tns:GetMySelledTickets_AccountCheckingHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBookLogBy_DateSellerCompanyCode">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">根据售票公司和售票时间查询，包括所有状态  </wsdl:documentation>
      <wsdl:input message="tns:GetBookLogBy_DateSellerCompanyCodeHttpGetIn" />
      <wsdl:output message="tns:GetBookLogBy_DateSellerCompanyCodeHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBookLogBy_DateSellerCompanyCode_ConfirmedOnly">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">根据售票公司和售票时间查询订单，只包括确认过的，状态为 未取票和已取票的startDate开始日期endDate结束日期scheduleCompanyCode票源公司。null为查询全部票源公司</wsdl:documentation>
      <wsdl:input message="tns:GetBookLogBy_DateSellerCompanyCode_ConfirmedOnlyHttpGetIn" />
      <wsdl:output message="tns:GetBookLogBy_DateSellerCompanyCode_ConfirmedOnlyHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetTakeTicketLogByCode">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查订单的取票操作过程,getTicketCode取票号</wsdl:documentation>
      <wsdl:input message="tns:GetTakeTicketLogByCodeHttpGetIn" />
      <wsdl:output message="tns:GetTakeTicketLogByCodeHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMyDeposits">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询保证金情况</wsdl:documentation>
      <wsdl:input message="tns:GetMyDepositsHttpGetIn" />
      <wsdl:output message="tns:GetMyDepositsHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets_NonConfirmed">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询本公司售出的车票中未做二次确认的数据</wsdl:documentation>
      <wsdl:input message="tns:GetMySelledTickets_NonConfirmedHttpGetIn" />
      <wsdl:output message="tns:GetMySelledTickets_NonConfirmedHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCompanyEndSiteByZone">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">获取运输公司终点站设置下，特定地区范围内的终点站</wsdl:documentation>
      <wsdl:input message="tns:GetCompanyEndSiteByZoneHttpGetIn" />
      <wsdl:output message="tns:GetCompanyEndSiteByZoneHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetExecuteScheduleInfoForSellByID">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">根据班次主键和起点、站点ID查询班次scheduleCompanyCode班次公司代码executeScheduleID班次IDstartSiteID起点IDendSiteID终点ID</wsdl:documentation>
      <wsdl:input message="tns:GetExecuteScheduleInfoForSellByIDHttpGetIn" />
      <wsdl:output message="tns:GetExecuteScheduleInfoForSellByIDHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAllSchedule">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">导出所有班次.导出过程中，班次总票位不显示，班次剩余票数大于10张时显示10，小于等于10张时全部显示为5;;scheduleCompanyCode班次公司代码days日期，以和今天差值startSiteName起点名称</wsdl:documentation>
      <wsdl:input message="tns:GetAllScheduleHttpGetIn" />
      <wsdl:output message="tns:GetAllScheduleHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="QuerySellTicketResult">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">根据第三方代理售票的参数查询订单</wsdl:documentation>
      <wsdl:input message="tns:QuerySellTicketResultHttpGetIn" />
      <wsdl:output message="tns:QuerySellTicketResultHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetTicketByBillNumber">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">NONE</wsdl:documentation>
      <wsdl:input message="tns:GetTicketByBillNumberHttpGetIn" />
      <wsdl:output message="tns:GetTicketByBillNumberHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAuthorL1Companys">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">授权可以销售车票的公司列表</wsdl:documentation>
      <wsdl:input message="tns:GetAuthorL1CompanysHttpGetIn" />
      <wsdl:output message="tns:GetAuthorL1CompanysHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAvailableZones">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询可用的出发城市</wsdl:documentation>
      <wsdl:input message="tns:GetAvailableZonesHttpGetIn" />
      <wsdl:output message="tns:GetAvailableZonesHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCompanySubZone">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询公司所在地区的下级地区</wsdl:documentation>
      <wsdl:input message="tns:GetCompanySubZoneHttpGetIn" />
      <wsdl:output message="tns:GetCompanySubZoneHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="QueryTicket">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询某个票号或订单号的所有车票</wsdl:documentation>
      <wsdl:input message="tns:QueryTicketHttpGetIn" />
      <wsdl:output message="tns:QueryTicketHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="QueryBookLog">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询订单</wsdl:documentation>
      <wsdl:input message="tns:QueryBookLogHttpGetIn" />
      <wsdl:output message="tns:QueryBookLogHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetZonesTree">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询地区树</wsdl:documentation>
      <wsdl:input message="tns:GetZonesTreeHttpGetIn" />
      <wsdl:output message="tns:GetZonesTreeHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetZones">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">取得所有地区</wsdl:documentation>
      <wsdl:input message="tns:GetZonesHttpGetIn" />
      <wsdl:output message="tns:GetZonesHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetStationSiteID">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">取得站点ID</wsdl:documentation>
      <wsdl:input message="tns:GetStationSiteIDHttpGetIn" />
      <wsdl:output message="tns:GetStationSiteIDHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetSites">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">取得站点</wsdl:documentation>
      <wsdl:input message="tns:GetSitesHttpGetIn" />
      <wsdl:output message="tns:GetSitesHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetSellableSchedule_1410">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">得到可销售班次</wsdl:documentation>
      <wsdl:input message="tns:GetSellableSchedule_1410HttpGetIn" />
      <wsdl:output message="tns:GetSellableSchedule_1410HttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="ConfirmTicket">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">确认订单</wsdl:documentation>
      <wsdl:input message="tns:ConfirmTicketHttpGetIn" />
      <wsdl:output message="tns:ConfirmTicketHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="ClearDataPersistence">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">清除数据对象</wsdl:documentation>
      <wsdl:input message="tns:ClearDataPersistenceHttpGetIn" />
      <wsdl:output message="tns:ClearDataPersistenceHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="CheckCompanyIdentity">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">检查公司数据</wsdl:documentation>
      <wsdl:input message="tns:CheckCompanyIdentityHttpGetIn" />
      <wsdl:output message="tns:CheckCompanyIdentityHttpGetOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="JDTTicketHttpPost">
    <wsdl:operation name="GetL1Companys">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">授权可以销售车票的公司列表</wsdl:documentation>
      <wsdl:input message="tns:GetL1CompanysHttpPostIn" />
      <wsdl:output message="tns:GetL1CompanysHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCompanyStationsByZone">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询公司下属地区的乘车站</wsdl:documentation>
      <wsdl:input message="tns:GetCompanyStationsByZoneHttpPostIn" />
      <wsdl:output message="tns:GetCompanyStationsByZoneHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBookTicketState">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询订单和对应车票的状态返回值是状态的描述，用来给操作或客服人员识别。</wsdl:documentation>
      <wsdl:input message="tns:GetBookTicketStateHttpPostIn" />
      <wsdl:output message="tns:GetBookTicketStateHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetExecuteScheduleSeats">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查看选定班次的票位情况</wsdl:documentation>
      <wsdl:input message="tns:GetExecuteScheduleSeatsHttpPostIn" />
      <wsdl:output message="tns:GetExecuteScheduleSeatsHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCompanyAllStations">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询公司所有的乘车站</wsdl:documentation>
      <wsdl:input message="tns:GetCompanyAllStationsHttpPostIn" />
      <wsdl:output message="tns:GetCompanyAllStationsHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetSellableScheduleByStartCityName">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">按出发城市和目的地查询班次，如果同一个目的地有多个运输公司合并结果一起查询返回</wsdl:documentation>
      <wsdl:input message="tns:GetSellableScheduleByStartCityNameHttpPostIn" />
      <wsdl:output message="tns:GetSellableScheduleByStartCityNameHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">无票证售票，使用订票方式。这个函数一步完成下订单和确认订单的过程，没有中间等待</wsdl:documentation>
      <wsdl:input message="tns:SellTicket_NoBillHttpPostIn" />
      <wsdl:output message="tns:SellTicket_NoBillHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Booking">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">无票证售票，使用订票方式，下订单，订单需在指定时间内（默认20分钟）确认否则将被取消</wsdl:documentation>
      <wsdl:input message="tns:SellTicket_NoBill_BookingHttpPostIn" />
      <wsdl:output message="tns:SellTicket_NoBill_BookingHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Cancel">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">无票证售票，使用订票，支付失败后撤销订单</wsdl:documentation>
      <wsdl:input message="tns:SellTicket_NoBill_CancelHttpPostIn" />
      <wsdl:output message="tns:SellTicket_NoBill_CancelHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Confirm">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">无票证售票，使用订票，支付成功后确认订单</wsdl:documentation>
      <wsdl:input message="tns:SellTicket_NoBill_ConfirmHttpPostIn" />
      <wsdl:output message="tns:SellTicket_NoBill_ConfirmHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirm">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询订单的状态，并确定订单还有多少时间(分钟)可以进行支付确认，返回-100表示状态已经不是可以进行支付确认的状态 返回结果说明：1未确认(带确认剩余时间),2已确认,3已撤销,4已取票。返回结果有固定格式，用来给代理系统程序识别</wsdl:documentation>
      <wsdl:input message="tns:SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirmHttpPostIn" />
      <wsdl:output message="tns:SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirmHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBookTicketStateByBookTicketAID">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询订单和对应车票的状态, 返回值是状态的描述，用来给操作或客服人员识别。bookTicketAID订单数据的主键</wsdl:documentation>
      <wsdl:input message="tns:GetBookTicketStateByBookTicketAIDHttpPostIn" />
      <wsdl:output message="tns:GetBookTicketStateByBookTicketAIDHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBounceTicketChargeByBookLogAID">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询退票手续费,按单张车票</wsdl:documentation>
      <wsdl:input message="tns:GetBounceTicketChargeByBookLogAIDHttpPostIn" />
      <wsdl:output message="tns:GetBounceTicketChargeByBookLogAIDHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="ExecuteBounceTicketByBookLogAID">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">退票手续费,按单张车票</wsdl:documentation>
      <wsdl:input message="tns:ExecuteBounceTicketByBookLogAIDHttpPostIn" />
      <wsdl:output message="tns:ExecuteBounceTicketByBookLogAIDHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="ResignSchedule">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">改签</wsdl:documentation>
      <wsdl:input message="tns:ResignScheduleHttpPostIn" />
      <wsdl:output message="tns:ResignScheduleHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="BlankoutTicket">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">作废票</wsdl:documentation>
      <wsdl:input message="tns:BlankoutTicketHttpPostIn" />
      <wsdl:output message="tns:BlankoutTicketHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询售出票记录</wsdl:documentation>
      <wsdl:input message="tns:GetMySelledTicketsHttpPostIn" />
      <wsdl:output message="tns:GetMySelledTicketsHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets_AccountChecking">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询本公司售出的车票,用于结算核对，结果中都是需要结算的车票，不需要结算的数据已经过滤</wsdl:documentation>
      <wsdl:input message="tns:GetMySelledTickets_AccountCheckingHttpPostIn" />
      <wsdl:output message="tns:GetMySelledTickets_AccountCheckingHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBookLogBy_DateSellerCompanyCode">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">根据售票公司和售票时间查询，包括所有状态  </wsdl:documentation>
      <wsdl:input message="tns:GetBookLogBy_DateSellerCompanyCodeHttpPostIn" />
      <wsdl:output message="tns:GetBookLogBy_DateSellerCompanyCodeHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetBookLogBy_DateSellerCompanyCode_ConfirmedOnly">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">根据售票公司和售票时间查询订单，只包括确认过的，状态为 未取票和已取票的startDate开始日期endDate结束日期scheduleCompanyCode票源公司。null为查询全部票源公司</wsdl:documentation>
      <wsdl:input message="tns:GetBookLogBy_DateSellerCompanyCode_ConfirmedOnlyHttpPostIn" />
      <wsdl:output message="tns:GetBookLogBy_DateSellerCompanyCode_ConfirmedOnlyHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetTakeTicketLogByCode">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查订单的取票操作过程,getTicketCode取票号</wsdl:documentation>
      <wsdl:input message="tns:GetTakeTicketLogByCodeHttpPostIn" />
      <wsdl:output message="tns:GetTakeTicketLogByCodeHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMyDeposits">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询保证金情况</wsdl:documentation>
      <wsdl:input message="tns:GetMyDepositsHttpPostIn" />
      <wsdl:output message="tns:GetMyDepositsHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets_NonConfirmed">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询本公司售出的车票中未做二次确认的数据</wsdl:documentation>
      <wsdl:input message="tns:GetMySelledTickets_NonConfirmedHttpPostIn" />
      <wsdl:output message="tns:GetMySelledTickets_NonConfirmedHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCompanyEndSiteByZone">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">获取运输公司终点站设置下，特定地区范围内的终点站</wsdl:documentation>
      <wsdl:input message="tns:GetCompanyEndSiteByZoneHttpPostIn" />
      <wsdl:output message="tns:GetCompanyEndSiteByZoneHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetExecuteScheduleInfoForSellByID">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">根据班次主键和起点、站点ID查询班次scheduleCompanyCode班次公司代码executeScheduleID班次IDstartSiteID起点IDendSiteID终点ID</wsdl:documentation>
      <wsdl:input message="tns:GetExecuteScheduleInfoForSellByIDHttpPostIn" />
      <wsdl:output message="tns:GetExecuteScheduleInfoForSellByIDHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAllSchedule">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">导出所有班次.导出过程中，班次总票位不显示，班次剩余票数大于10张时显示10，小于等于10张时全部显示为5;;scheduleCompanyCode班次公司代码days日期，以和今天差值startSiteName起点名称</wsdl:documentation>
      <wsdl:input message="tns:GetAllScheduleHttpPostIn" />
      <wsdl:output message="tns:GetAllScheduleHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="QuerySellTicketResult">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">根据第三方代理售票的参数查询订单</wsdl:documentation>
      <wsdl:input message="tns:QuerySellTicketResultHttpPostIn" />
      <wsdl:output message="tns:QuerySellTicketResultHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetTicketByBillNumber">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">NONE</wsdl:documentation>
      <wsdl:input message="tns:GetTicketByBillNumberHttpPostIn" />
      <wsdl:output message="tns:GetTicketByBillNumberHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAuthorL1Companys">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">授权可以销售车票的公司列表</wsdl:documentation>
      <wsdl:input message="tns:GetAuthorL1CompanysHttpPostIn" />
      <wsdl:output message="tns:GetAuthorL1CompanysHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetAvailableZones">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询可用的出发城市</wsdl:documentation>
      <wsdl:input message="tns:GetAvailableZonesHttpPostIn" />
      <wsdl:output message="tns:GetAvailableZonesHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetCompanySubZone">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询公司所在地区的下级地区</wsdl:documentation>
      <wsdl:input message="tns:GetCompanySubZoneHttpPostIn" />
      <wsdl:output message="tns:GetCompanySubZoneHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="QueryTicket">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询某个票号或订单号的所有车票</wsdl:documentation>
      <wsdl:input message="tns:QueryTicketHttpPostIn" />
      <wsdl:output message="tns:QueryTicketHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="QueryBookLog">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询订单</wsdl:documentation>
      <wsdl:input message="tns:QueryBookLogHttpPostIn" />
      <wsdl:output message="tns:QueryBookLogHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetZonesTree">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">查询地区树</wsdl:documentation>
      <wsdl:input message="tns:GetZonesTreeHttpPostIn" />
      <wsdl:output message="tns:GetZonesTreeHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetZones">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">取得所有地区</wsdl:documentation>
      <wsdl:input message="tns:GetZonesHttpPostIn" />
      <wsdl:output message="tns:GetZonesHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetStationSiteID">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">取得站点ID</wsdl:documentation>
      <wsdl:input message="tns:GetStationSiteIDHttpPostIn" />
      <wsdl:output message="tns:GetStationSiteIDHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetSites">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">取得站点</wsdl:documentation>
      <wsdl:input message="tns:GetSitesHttpPostIn" />
      <wsdl:output message="tns:GetSitesHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetSellableSchedule_1410">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">得到可销售班次</wsdl:documentation>
      <wsdl:input message="tns:GetSellableSchedule_1410HttpPostIn" />
      <wsdl:output message="tns:GetSellableSchedule_1410HttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="ConfirmTicket">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">确认订单</wsdl:documentation>
      <wsdl:input message="tns:ConfirmTicketHttpPostIn" />
      <wsdl:output message="tns:ConfirmTicketHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="ClearDataPersistence">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">清除数据对象</wsdl:documentation>
      <wsdl:input message="tns:ClearDataPersistenceHttpPostIn" />
      <wsdl:output message="tns:ClearDataPersistenceHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="CheckCompanyIdentity">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">检查公司数据</wsdl:documentation>
      <wsdl:input message="tns:CheckCompanyIdentityHttpPostIn" />
      <wsdl:output message="tns:CheckCompanyIdentityHttpPostOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="JDTTicketSoap" type="tns:JDTTicketSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="GetL1Companys">
      <soap:operation soapAction="http://tempuri.org/GetL1Companys" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCompanyStationsByZone">
      <soap:operation soapAction="http://tempuri.org/GetCompanyStationsByZone" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBookTicketState">
      <soap:operation soapAction="http://tempuri.org/GetBookTicketState" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetExecuteScheduleSeats">
      <soap:operation soapAction="http://tempuri.org/GetExecuteScheduleSeats" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCompanyAllStations">
      <soap:operation soapAction="http://tempuri.org/GetCompanyAllStations" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSellableScheduleByStartCityName">
      <soap:operation soapAction="http://tempuri.org/GetSellableScheduleByStartCityName" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill">
      <soap:operation soapAction="http://tempuri.org/SellTicket_NoBill" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Booking">
      <soap:operation soapAction="http://tempuri.org/SellTicket_NoBill_Booking" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Cancel">
      <soap:operation soapAction="http://tempuri.org/SellTicket_NoBill_Cancel" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Confirm">
      <soap:operation soapAction="http://tempuri.org/SellTicket_NoBill_Confirm" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirm">
      <soap:operation soapAction="http://tempuri.org/SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirm" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBookTicketStateByBookTicketAID">
      <soap:operation soapAction="http://tempuri.org/GetBookTicketStateByBookTicketAID" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBounceTicketChargeByBookLogAID">
      <soap:operation soapAction="http://tempuri.org/GetBounceTicketChargeByBookLogAID" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExecuteBounceTicketByBookLogAID">
      <soap:operation soapAction="http://tempuri.org/ExecuteBounceTicketByBookLogAID" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ResignSchedule">
      <soap:operation soapAction="http://tempuri.org/ResignSchedule" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="BlankoutTicket">
      <soap:operation soapAction="http://tempuri.org/BlankoutTicket" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets">
      <soap:operation soapAction="http://tempuri.org/GetMySelledTickets" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets_AccountChecking">
      <soap:operation soapAction="http://tempuri.org/GetMySelledTickets_AccountChecking" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBookLogBy_DateSellerCompanyCode">
      <soap:operation soapAction="http://tempuri.org/GetBookLogBy_DateSellerCompanyCode" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBookLogBy_DateSellerCompanyCode_ConfirmedOnly">
      <soap:operation soapAction="http://tempuri.org/GetBookLogBy_DateSellerCompanyCode_ConfirmedOnly" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTakeTicketLogByCode">
      <soap:operation soapAction="http://tempuri.org/GetTakeTicketLogByCode" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMyDeposits">
      <soap:operation soapAction="http://tempuri.org/GetMyDeposits" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets_NonConfirmed">
      <soap:operation soapAction="http://tempuri.org/GetMySelledTickets_NonConfirmed" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCompanyEndSiteByZone">
      <soap:operation soapAction="http://tempuri.org/GetCompanyEndSiteByZone" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetExecuteScheduleInfoForSellByID">
      <soap:operation soapAction="http://tempuri.org/GetExecuteScheduleInfoForSellByID" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAllSchedule">
      <soap:operation soapAction="http://tempuri.org/GetAllSchedule" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="QuerySellTicketResult">
      <soap:operation soapAction="http://tempuri.org/QuerySellTicketResult" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTicketByBillNumber">
      <soap:operation soapAction="http://tempuri.org/GetTicketByBillNumber" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAuthorL1Companys">
      <soap:operation soapAction="http://tempuri.org/GetAuthorL1Companys" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAvailableZones">
      <soap:operation soapAction="http://tempuri.org/GetAvailableZones" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCompanySubZone">
      <soap:operation soapAction="http://tempuri.org/GetCompanySubZone" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="QueryTicket">
      <soap:operation soapAction="http://tempuri.org/QueryTicket" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="QueryBookLog">
      <soap:operation soapAction="http://tempuri.org/QueryBookLog" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetZonesTree">
      <soap:operation soapAction="http://tempuri.org/GetZonesTree" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetZones">
      <soap:operation soapAction="http://tempuri.org/GetZones" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetStationSiteID">
      <soap:operation soapAction="http://tempuri.org/GetStationSiteID" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSites">
      <soap:operation soapAction="http://tempuri.org/GetSites" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSellableSchedule_1410">
      <soap:operation soapAction="http://tempuri.org/GetSellableSchedule_1410" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ConfirmTicket">
      <soap:operation soapAction="http://tempuri.org/ConfirmTicket" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ClearDataPersistence">
      <soap:operation soapAction="http://tempuri.org/ClearDataPersistence" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CheckCompanyIdentity">
      <soap:operation soapAction="http://tempuri.org/CheckCompanyIdentity" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="JDTTicketSoap12" type="tns:JDTTicketSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="GetL1Companys">
      <soap12:operation soapAction="http://tempuri.org/GetL1Companys" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCompanyStationsByZone">
      <soap12:operation soapAction="http://tempuri.org/GetCompanyStationsByZone" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBookTicketState">
      <soap12:operation soapAction="http://tempuri.org/GetBookTicketState" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetExecuteScheduleSeats">
      <soap12:operation soapAction="http://tempuri.org/GetExecuteScheduleSeats" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCompanyAllStations">
      <soap12:operation soapAction="http://tempuri.org/GetCompanyAllStations" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSellableScheduleByStartCityName">
      <soap12:operation soapAction="http://tempuri.org/GetSellableScheduleByStartCityName" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill">
      <soap12:operation soapAction="http://tempuri.org/SellTicket_NoBill" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Booking">
      <soap12:operation soapAction="http://tempuri.org/SellTicket_NoBill_Booking" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Cancel">
      <soap12:operation soapAction="http://tempuri.org/SellTicket_NoBill_Cancel" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Confirm">
      <soap12:operation soapAction="http://tempuri.org/SellTicket_NoBill_Confirm" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirm">
      <soap12:operation soapAction="http://tempuri.org/SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirm" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBookTicketStateByBookTicketAID">
      <soap12:operation soapAction="http://tempuri.org/GetBookTicketStateByBookTicketAID" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBounceTicketChargeByBookLogAID">
      <soap12:operation soapAction="http://tempuri.org/GetBounceTicketChargeByBookLogAID" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExecuteBounceTicketByBookLogAID">
      <soap12:operation soapAction="http://tempuri.org/ExecuteBounceTicketByBookLogAID" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ResignSchedule">
      <soap12:operation soapAction="http://tempuri.org/ResignSchedule" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="BlankoutTicket">
      <soap12:operation soapAction="http://tempuri.org/BlankoutTicket" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets">
      <soap12:operation soapAction="http://tempuri.org/GetMySelledTickets" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets_AccountChecking">
      <soap12:operation soapAction="http://tempuri.org/GetMySelledTickets_AccountChecking" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBookLogBy_DateSellerCompanyCode">
      <soap12:operation soapAction="http://tempuri.org/GetBookLogBy_DateSellerCompanyCode" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBookLogBy_DateSellerCompanyCode_ConfirmedOnly">
      <soap12:operation soapAction="http://tempuri.org/GetBookLogBy_DateSellerCompanyCode_ConfirmedOnly" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTakeTicketLogByCode">
      <soap12:operation soapAction="http://tempuri.org/GetTakeTicketLogByCode" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMyDeposits">
      <soap12:operation soapAction="http://tempuri.org/GetMyDeposits" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets_NonConfirmed">
      <soap12:operation soapAction="http://tempuri.org/GetMySelledTickets_NonConfirmed" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCompanyEndSiteByZone">
      <soap12:operation soapAction="http://tempuri.org/GetCompanyEndSiteByZone" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetExecuteScheduleInfoForSellByID">
      <soap12:operation soapAction="http://tempuri.org/GetExecuteScheduleInfoForSellByID" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAllSchedule">
      <soap12:operation soapAction="http://tempuri.org/GetAllSchedule" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="QuerySellTicketResult">
      <soap12:operation soapAction="http://tempuri.org/QuerySellTicketResult" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTicketByBillNumber">
      <soap12:operation soapAction="http://tempuri.org/GetTicketByBillNumber" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAuthorL1Companys">
      <soap12:operation soapAction="http://tempuri.org/GetAuthorL1Companys" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAvailableZones">
      <soap12:operation soapAction="http://tempuri.org/GetAvailableZones" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCompanySubZone">
      <soap12:operation soapAction="http://tempuri.org/GetCompanySubZone" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="QueryTicket">
      <soap12:operation soapAction="http://tempuri.org/QueryTicket" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="QueryBookLog">
      <soap12:operation soapAction="http://tempuri.org/QueryBookLog" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetZonesTree">
      <soap12:operation soapAction="http://tempuri.org/GetZonesTree" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetZones">
      <soap12:operation soapAction="http://tempuri.org/GetZones" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetStationSiteID">
      <soap12:operation soapAction="http://tempuri.org/GetStationSiteID" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSites">
      <soap12:operation soapAction="http://tempuri.org/GetSites" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSellableSchedule_1410">
      <soap12:operation soapAction="http://tempuri.org/GetSellableSchedule_1410" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ConfirmTicket">
      <soap12:operation soapAction="http://tempuri.org/ConfirmTicket" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ClearDataPersistence">
      <soap12:operation soapAction="http://tempuri.org/ClearDataPersistence" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CheckCompanyIdentity">
      <soap12:operation soapAction="http://tempuri.org/CheckCompanyIdentity" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="JDTTicketHttpGet" type="tns:JDTTicketHttpGet">
    <http:binding verb="GET" />
    <wsdl:operation name="GetL1Companys">
      <http:operation location="/GetL1Companys" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCompanyStationsByZone">
      <http:operation location="/GetCompanyStationsByZone" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBookTicketState">
      <http:operation location="/GetBookTicketState" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetExecuteScheduleSeats">
      <http:operation location="/GetExecuteScheduleSeats" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCompanyAllStations">
      <http:operation location="/GetCompanyAllStations" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSellableScheduleByStartCityName">
      <http:operation location="/GetSellableScheduleByStartCityName" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill">
      <http:operation location="/SellTicket_NoBill" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Booking">
      <http:operation location="/SellTicket_NoBill_Booking" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Cancel">
      <http:operation location="/SellTicket_NoBill_Cancel" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Confirm">
      <http:operation location="/SellTicket_NoBill_Confirm" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirm">
      <http:operation location="/SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirm" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBookTicketStateByBookTicketAID">
      <http:operation location="/GetBookTicketStateByBookTicketAID" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBounceTicketChargeByBookLogAID">
      <http:operation location="/GetBounceTicketChargeByBookLogAID" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExecuteBounceTicketByBookLogAID">
      <http:operation location="/ExecuteBounceTicketByBookLogAID" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ResignSchedule">
      <http:operation location="/ResignSchedule" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="BlankoutTicket">
      <http:operation location="/BlankoutTicket" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets">
      <http:operation location="/GetMySelledTickets" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets_AccountChecking">
      <http:operation location="/GetMySelledTickets_AccountChecking" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBookLogBy_DateSellerCompanyCode">
      <http:operation location="/GetBookLogBy_DateSellerCompanyCode" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBookLogBy_DateSellerCompanyCode_ConfirmedOnly">
      <http:operation location="/GetBookLogBy_DateSellerCompanyCode_ConfirmedOnly" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTakeTicketLogByCode">
      <http:operation location="/GetTakeTicketLogByCode" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMyDeposits">
      <http:operation location="/GetMyDeposits" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets_NonConfirmed">
      <http:operation location="/GetMySelledTickets_NonConfirmed" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCompanyEndSiteByZone">
      <http:operation location="/GetCompanyEndSiteByZone" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetExecuteScheduleInfoForSellByID">
      <http:operation location="/GetExecuteScheduleInfoForSellByID" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAllSchedule">
      <http:operation location="/GetAllSchedule" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="QuerySellTicketResult">
      <http:operation location="/QuerySellTicketResult" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTicketByBillNumber">
      <http:operation location="/GetTicketByBillNumber" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAuthorL1Companys">
      <http:operation location="/GetAuthorL1Companys" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAvailableZones">
      <http:operation location="/GetAvailableZones" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCompanySubZone">
      <http:operation location="/GetCompanySubZone" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="QueryTicket">
      <http:operation location="/QueryTicket" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="QueryBookLog">
      <http:operation location="/QueryBookLog" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetZonesTree">
      <http:operation location="/GetZonesTree" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetZones">
      <http:operation location="/GetZones" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetStationSiteID">
      <http:operation location="/GetStationSiteID" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSites">
      <http:operation location="/GetSites" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSellableSchedule_1410">
      <http:operation location="/GetSellableSchedule_1410" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ConfirmTicket">
      <http:operation location="/ConfirmTicket" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ClearDataPersistence">
      <http:operation location="/ClearDataPersistence" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CheckCompanyIdentity">
      <http:operation location="/CheckCompanyIdentity" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="JDTTicketHttpPost" type="tns:JDTTicketHttpPost">
    <http:binding verb="POST" />
    <wsdl:operation name="GetL1Companys">
      <http:operation location="/GetL1Companys" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCompanyStationsByZone">
      <http:operation location="/GetCompanyStationsByZone" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBookTicketState">
      <http:operation location="/GetBookTicketState" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetExecuteScheduleSeats">
      <http:operation location="/GetExecuteScheduleSeats" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCompanyAllStations">
      <http:operation location="/GetCompanyAllStations" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSellableScheduleByStartCityName">
      <http:operation location="/GetSellableScheduleByStartCityName" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill">
      <http:operation location="/SellTicket_NoBill" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Booking">
      <http:operation location="/SellTicket_NoBill_Booking" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Cancel">
      <http:operation location="/SellTicket_NoBill_Cancel" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_NoBill_Confirm">
      <http:operation location="/SellTicket_NoBill_Confirm" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirm">
      <http:operation location="/SellTicket_Other_NoBill_GetBookStateAndMinuteToConfirm" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBookTicketStateByBookTicketAID">
      <http:operation location="/GetBookTicketStateByBookTicketAID" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBounceTicketChargeByBookLogAID">
      <http:operation location="/GetBounceTicketChargeByBookLogAID" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ExecuteBounceTicketByBookLogAID">
      <http:operation location="/ExecuteBounceTicketByBookLogAID" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ResignSchedule">
      <http:operation location="/ResignSchedule" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="BlankoutTicket">
      <http:operation location="/BlankoutTicket" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets">
      <http:operation location="/GetMySelledTickets" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets_AccountChecking">
      <http:operation location="/GetMySelledTickets_AccountChecking" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBookLogBy_DateSellerCompanyCode">
      <http:operation location="/GetBookLogBy_DateSellerCompanyCode" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetBookLogBy_DateSellerCompanyCode_ConfirmedOnly">
      <http:operation location="/GetBookLogBy_DateSellerCompanyCode_ConfirmedOnly" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTakeTicketLogByCode">
      <http:operation location="/GetTakeTicketLogByCode" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMyDeposits">
      <http:operation location="/GetMyDeposits" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetMySelledTickets_NonConfirmed">
      <http:operation location="/GetMySelledTickets_NonConfirmed" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCompanyEndSiteByZone">
      <http:operation location="/GetCompanyEndSiteByZone" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetExecuteScheduleInfoForSellByID">
      <http:operation location="/GetExecuteScheduleInfoForSellByID" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAllSchedule">
      <http:operation location="/GetAllSchedule" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="QuerySellTicketResult">
      <http:operation location="/QuerySellTicketResult" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTicketByBillNumber">
      <http:operation location="/GetTicketByBillNumber" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAuthorL1Companys">
      <http:operation location="/GetAuthorL1Companys" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetAvailableZones">
      <http:operation location="/GetAvailableZones" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetCompanySubZone">
      <http:operation location="/GetCompanySubZone" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="QueryTicket">
      <http:operation location="/QueryTicket" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="QueryBookLog">
      <http:operation location="/QueryBookLog" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetZonesTree">
      <http:operation location="/GetZonesTree" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetZones">
      <http:operation location="/GetZones" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetStationSiteID">
      <http:operation location="/GetStationSiteID" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSites">
      <http:operation location="/GetSites" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetSellableSchedule_1410">
      <http:operation location="/GetSellableSchedule_1410" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ConfirmTicket">
      <http:operation location="/ConfirmTicket" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="ClearDataPersistence">
      <http:operation location="/ClearDataPersistence" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="CheckCompanyIdentity">
      <http:operation location="/CheckCompanyIdentity" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="JDTTicket">
    <wsdl:port name="JDTTicketSoap" binding="tns:JDTTicketSoap">
      <soap:address location="http://www.aiton.com.cn:808/JDTTicket.asmx" />
    </wsdl:port>
    <wsdl:port name="JDTTicketSoap12" binding="tns:JDTTicketSoap12">
      <soap12:address location="http://www.aiton.com.cn:808/JDTTicket.asmx" />
    </wsdl:port>
    <wsdl:port name="JDTTicketHttpGet" binding="tns:JDTTicketHttpGet">
      <http:address location="http://www.aiton.com.cn:808/JDTTicket.asmx" />
    </wsdl:port>
    <wsdl:port name="JDTTicketHttpPost" binding="tns:JDTTicketHttpPost">
      <http:address location="http://www.aiton.com.cn:808/JDTTicket.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>