package com.tang.preparser;

/**
 * 原始表数据
 * @author tang
 */
public class PreParserLog {
    /**
     * 日志产生的服务器时间
     */
    private String serverTime;
    /**
     * 访客的ip
     */
    private String serverIp;
    /**
     * 访问方法
     */
    private String method;
    /**
     * 访问uri
     */
    private String uriStem;
    /**
     * 访问参数
     */
    private String queryString;
    /**
     * 服务端监听端口
     */
    private int serverPort;
    /**
     * 访客的ip
     */
    private String clientIp;
    /**
     * userAgent
     */
    private String userAgent;
    /**
     * 网站唯一标识
     */
    private int profileId;
    /**
     * 访客行为类型
     */
    private String command;
    /**
     * 用于我们的hive表的分区
     */
    private int year;
    private int month;
    private int day;

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUriStem() {
        return uriStem;
    }

    public void setUriStem(String uriStem) {
        this.uriStem = uriStem;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
