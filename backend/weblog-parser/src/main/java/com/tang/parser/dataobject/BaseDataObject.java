package com.tang.parser.dataobject;

import com.tang.iplocation.IpLocation;
import eu.bitwalker.useragentutils.UserAgent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 公共字段
 *
 * @author tang
 */
public class BaseDataObject {
    /**
     * 网站的唯一标识
     */
    private int profileId;
    /**
     * 收集页面数据的javascript程序的版本
     */
    private String trackerVersion;
    /**
     * 收集页面数据的类型命令(目前支持pv,hb,ev,mc四种类型的数据)
     */
    private String command;
    /**
     * 访客唯一标识(userId),是我们生成的cookie
     */
    private String userId;
    /**
     * 访客每次访问一个页面的时候产生的唯一的标识
     */
    private String pvId;
    /**
     * 服务器时间
     */
    private String serverTimeString;
    /**
     * 服务器时间
     */
    private Date serverTime;
    private Calendar calendar;
    private String userAgent;
    private String clientIp;
    private IpLocation ipLocation;
    private UserAgent userAgentInfo;

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getTrackerVersion() {
        return trackerVersion;
    }

    public void setTrackerVersion(String trackerVersion) {
        this.trackerVersion = trackerVersion;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPvId() {
        return pvId;
    }

    public void setPvId(String pvId) {
        this.pvId = pvId;
    }

    public String getServerTimeString() {
        return serverTimeString;
    }

    public void setServerTimeString(String serverTimeString) {
        this.serverTimeString = serverTimeString;
    }

    public Date getServerTime() {
        return serverTime;
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public UserAgent getUserAgentInfo() {
        return userAgentInfo;
    }

    public void setUserAgentInfo(UserAgent userAgentInfo) {
        this.userAgentInfo = userAgentInfo;
    }

    public IpLocation getIpLocation() {
        return ipLocation;
    }

    public void setIpLocation(IpLocation ipLocation) {
        this.ipLocation = ipLocation;
    }
}
