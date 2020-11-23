package com.tang.parser.dataobject;

/**
 * 关闭页面或者跳出页面事件实体
 * @author tang
 */
public class HeartbeatDataObject extends BaseDataObject {
    private int clientPageDuration;
    private int loadingDuration;

    public int getClientPageDuration() {
        return clientPageDuration;
    }

    public void setClientPageDuration(int clientPageDuration) {
        this.clientPageDuration = clientPageDuration;
    }

    public int getLoadingDuration() {
        return loadingDuration;
    }

    public void setLoadingDuration(int loadingDuration) {
        this.loadingDuration = loadingDuration;
    }
}
