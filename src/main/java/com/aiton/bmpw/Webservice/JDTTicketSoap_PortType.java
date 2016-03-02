/**
 * JDTTicketSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.aiton.bmpw.Webservice;

public interface JDTTicketSoap_PortType extends java.rmi.Remote {

    /**
     * 授权可以销售车票的公司列表
     */
    public com.aiton.bmpw.Webservice.L1Company[] getL1Companys() throws java.rmi.RemoteException;

    /**
     * 查询公司下属地区的乘车站
     */
    public java.lang.String getCompanyStationsByZone(java.lang.String companyCode, java.lang.String zoneCode) throws java.rmi.RemoteException;

    /**
     * 查询订单和对应车票的状态返回值是状态的描述，用来给操作或客服人员识别。
     */
    public java.lang.String getBookTicketState(java.lang.String getTicketCode) throws java.rmi.RemoteException;

    /**
     * 查看选定班次的票位情况
     */
    public java.lang.String getExecuteScheduleSeats(java.lang.String scheduleCompanyCode, java.lang.String executeScheduleID) throws java.rmi.RemoteException;

    /**
     * 查询公司所有的乘车站
     */
    public java.lang.String getCompanyAllStations(java.lang.String companyCode) throws java.rmi.RemoteException;

    /**
     * 按出发城市和目的地查询班次，如果同一个目的地有多个运输公司合并结果一起查询返回
     */
    public java.lang.String getSellableScheduleByStartCityName(java.util.Calendar executeDate, java.lang.String startCityName, java.lang.String endSiteNamePart) throws java.rmi.RemoteException;

    /**
     * 无票证售票，使用订票方式。这个函数一步完成下订单和确认订单的过程，没有中间等待
     */
    public java.lang.String sellTicket_NoBill(java.lang.String scheduleCompanyCode, java.lang.String executeScheduleID, java.lang.String startSiteID, java.lang.String endSiteID, int fullTickets, int halfTicket, int carryChild, java.lang.String phoneNumber, java.lang.String[] passengerIdentitys, java.lang.String[] passengerNames, boolean insured) throws java.rmi.RemoteException;

    /**
     * 无票证售票，使用订票方式，下订单，订单需在指定时间内（默认20分钟）确认否则将被取消
     */
    public java.lang.String sellTicket_NoBill_Booking(java.lang.String scheduleCompanyCode, java.lang.String executeScheduleID, java.lang.String startSiteID, java.lang.String endSiteID, int fullTickets, int halfTicket, int carryChild, java.lang.String phoneNumber, java.lang.String[] passengerIdentitys, java.lang.String[] passengerNames, boolean insured) throws java.rmi.RemoteException;

    /**
     * 无票证售票，使用订票，支付失败后撤销订单
     */
    public java.lang.String sellTicket_NoBill_Cancel(java.lang.String scheduleCompanyCode, java.lang.String bookLogAID) throws java.rmi.RemoteException;

    /**
     * 无票证售票，使用订票，支付成功后确认订单
     */
    public java.lang.String sellTicket_NoBill_Confirm(java.lang.String scheduleCompanyCode, java.lang.String bookLogAID) throws java.rmi.RemoteException;

    /**
     * 查询订单的状态，并确定订单还有多少时间(分钟)可以进行支付确认，返回-100表示状态已经不是可以进行支付确认的状态 返回结果说明：1未确认(带确认剩余时间),2已确认,3已撤销,4已取票。返回结果有固定格式，用来给代理系统程序识别
     */
    public java.lang.String sellTicket_Other_NoBill_GetBookStateAndMinuteToConfirm(java.lang.String scheduleCompanyCode, java.lang.String bookLogID) throws java.rmi.RemoteException;

    /**
     * 查询订单和对应车票的状态, 返回值是状态的描述，用来给操作或客服人员识别。bookTicketAID订单数据的主键
     */
    public java.lang.String getBookTicketStateByBookTicketAID(java.lang.String bookTicketAID) throws java.rmi.RemoteException;

    /**
     * 查询退票手续费,按单张车票
     */
    public java.lang.String getBounceTicketChargeByBookLogAID(java.lang.String bookTicketAID) throws java.rmi.RemoteException;

    /**
     * 退票手续费,按单张车票
     */
    public java.lang.String executeBounceTicketByBookLogAID(java.lang.String bookTicketAID) throws java.rmi.RemoteException;

    /**
     * 改签
     */
    public java.lang.String resignSchedule(java.lang.String scheduleCompanyCode, java.lang.String ticketID, java.lang.String executeScheduleID, java.lang.String startSiteID, java.lang.String endSiteID) throws java.rmi.RemoteException;

    /**
     * 作废票
     */
    public java.lang.String blankoutTicket(java.lang.String scheduleCompanyCode, java.lang.String ticketID) throws java.rmi.RemoteException;

    /**
     * 查询售出票记录
     */
    public java.lang.String getMySelledTickets(java.util.Calendar startDate, java.util.Calendar endDate) throws java.rmi.RemoteException;

    /**
     * 查询本公司售出的车票,用于结算核对，结果中都是需要结算的车票，不需要结算的数据已经过滤
     */
    public java.lang.String getMySelledTickets_AccountChecking(java.util.Calendar startDate, java.util.Calendar endDate) throws java.rmi.RemoteException;

    /**
     * 根据售票公司和售票时间查询，包括所有状态
     */
    public java.lang.String getBookLogBy_DateSellerCompanyCode(java.util.Calendar startDate, java.util.Calendar endDate, java.lang.String scheduleCompanyCode) throws java.rmi.RemoteException;

    /**
     * 根据售票公司和售票时间查询订单，只包括确认过的，状态为 未取票和已取票的startDate开始日期endDate结束日期scheduleCompanyCode票源公司。null为查询全部票源公司
     */
    public java.lang.String getBookLogBy_DateSellerCompanyCode_ConfirmedOnly(java.util.Calendar startDate, java.util.Calendar endDate, java.lang.String scheduleCompanyCode) throws java.rmi.RemoteException;

    /**
     * 查订单的取票操作过程,getTicketCode取票号
     */
    public java.lang.String getTakeTicketLogByCode(java.lang.String getTicketCode) throws java.rmi.RemoteException;

    /**
     * 查询保证金情况
     */
    public java.lang.String getMyDeposits() throws java.rmi.RemoteException;

    /**
     * 查询本公司售出的车票中未做二次确认的数据
     */
    public java.lang.String getMySelledTickets_NonConfirmed(java.util.Calendar startDate, java.util.Calendar endDate) throws java.rmi.RemoteException;

    /**
     * 获取运输公司终点站设置下，特定地区范围内的终点站
     */
    public java.lang.String getCompanyEndSiteByZone(java.lang.String scheduleCompanyCode, int zoneID) throws java.rmi.RemoteException;

    /**
     * 根据班次主键和起点、站点ID查询班次scheduleCompanyCode班次公司代码executeScheduleID班次IDstartSiteID起点IDendSiteID终点ID
     */
    public java.lang.String getExecuteScheduleInfoForSellByID(java.lang.String scheduleCompanyCode, java.lang.String executeScheduleID, java.lang.String startSiteID, java.lang.String endSiteID) throws java.rmi.RemoteException;

    /**
     * 导出所有班次.导出过程中，班次总票位不显示，班次剩余票数大于10张时显示10，小于等于10张时全部显示为5;;scheduleCompanyCode班次公司代码days日期，以和今天差值startSiteName起点名称
     */
    public java.lang.String getAllSchedule(java.lang.String scheduleCompanyCode, java.util.Calendar executeDate) throws java.rmi.RemoteException;

    /**
     * 根据第三方代理售票的参数查询订单
     */
    public java.lang.String querySellTicketResult(java.lang.String scheduleCompanyCode, java.lang.String executeScheduleID, java.lang.String startSiteID, java.lang.String endSiteID, int fullTickets, int carryChild, java.lang.String phoneNumber) throws java.rmi.RemoteException;

    /**
     * NONE
     */
    public java.lang.String getTicketByBillNumber(long startNumber, long endNumber) throws java.rmi.RemoteException;

    /**
     * 授权可以销售车票的公司列表
     */
    public com.aiton.bmpw.Webservice.L1Company[] getAuthorL1Companys() throws java.rmi.RemoteException;

    /**
     * 查询可用的出发城市
     */
    public java.lang.String getAvailableZones() throws java.rmi.RemoteException;

    /**
     * 查询公司所在地区的下级地区
     */
    public java.lang.String getCompanySubZone(java.lang.String companyCode) throws java.rmi.RemoteException;

    /**
     * 查询某个票号或订单号的所有车票
     */
    public java.lang.String queryTicket(java.lang.String getTicketCodeOrAID) throws java.rmi.RemoteException;

    /**
     * 查询订单
     */
    public java.lang.String queryBookLog(java.lang.String getTicketCodeOrAID) throws java.rmi.RemoteException;

    /**
     * 查询地区树
     */
    public java.lang.String getZonesTree() throws java.rmi.RemoteException;

    /**
     * 取得所有地区
     */
    public java.lang.String getZones() throws java.rmi.RemoteException;

    /**
     * 取得站点ID
     */
    public java.lang.String getStationSiteID(java.lang.String companyCode) throws java.rmi.RemoteException;

    /**
     * 取得站点
     */
    public java.lang.String getSites() throws java.rmi.RemoteException;

    /**
     * 得到可销售班次
     */
    public java.lang.String getSellableSchedule_1410(java.lang.String scheduleCompanyCode, java.util.Calendar executeDate, java.lang.String startSiteNamePart, java.lang.String endSiteNamePart) throws java.rmi.RemoteException;

    /**
     * 确认订单
     */
    public java.lang.String confirmTicket(java.lang.String[] ticketIDs) throws java.rmi.RemoteException;

    /**
     * 清除数据对象
     */
    public java.lang.String clearDataPersistence(java.lang.String adminPassword) throws java.rmi.RemoteException;

    /**
     * 检查公司数据
     */
    public java.lang.String checkCompanyIdentity(java.lang.String companyCode, java.lang.String password) throws java.rmi.RemoteException;
}
