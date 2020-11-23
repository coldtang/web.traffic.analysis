package com.tang.parser.dataobject;

import com.tang.parser.dataobject.dim.AdInfo;
import com.tang.parser.dataobject.dim.BrowserInfo;
import com.tang.parser.dataobject.dim.ReferrerInfo;
import com.tang.parser.dataobject.dim.SiteResourceInfo;

/**
 * pageView实体
 * @author tang
 */
public class PvDataObject extends BaseDataObject {
    private SiteResourceInfo siteResourceInfo;
    private BrowserInfo browserInfo;
    private ReferrerInfo referrerInfo;
    private AdInfo adInfo;
    /**
     * 表示当前pv停留时长, 精确到秒级别
     */
    private int duration;

    public SiteResourceInfo getSiteResourceInfo() {
        return siteResourceInfo;
    }

    public void setSiteResourceInfo(SiteResourceInfo siteResourceInfo) {
        this.siteResourceInfo = siteResourceInfo;
    }

    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public void setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
    }

    public ReferrerInfo getReferrerInfo() {
        return referrerInfo;
    }

    public void setReferrerInfo(ReferrerInfo referrerInfo) {
        this.referrerInfo = referrerInfo;
    }

    public AdInfo getAdInfo() {
        return adInfo;
    }

    public void setAdInfo(AdInfo adInfo) {
        this.adInfo = adInfo;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
