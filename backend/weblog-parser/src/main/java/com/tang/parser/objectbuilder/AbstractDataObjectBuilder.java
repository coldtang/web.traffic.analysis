package com.tang.parser.objectbuilder;

import com.tang.iplocation.IpLocationParser;
import com.tang.parser.dataobject.BaseDataObject;
import com.tang.parser.utils.ColumnReader;
import com.tang.preparser.PreParserLog;
import eu.bitwalker.useragentutils.UserAgent;

import java.util.List;

/**
 * 通用字段解析
 * @author tang
 */
public abstract class AbstractDataObjectBuilder {
    public abstract String getCommand();

    public abstract List<BaseDataObject> doBuildDataObjects(PreParserLog preParsedLog);

    public void fillCommonBaseDataObjectValue(BaseDataObject baseDataObject,
                                              PreParserLog preParsedLog, ColumnReader columnReader) {
        baseDataObject.setProfileId(preParsedLog.getProfileId());
        baseDataObject.setServerTimeString(preParsedLog.getServerTime().toString());

        baseDataObject.setUserId(columnReader.getStringValue("gsuid"));
        baseDataObject.setTrackerVersion(columnReader.getStringValue("gsver"));
        baseDataObject.setPvId(columnReader.getStringValue("pvid"));
        baseDataObject.setCommand(columnReader.getStringValue("gscmd"));

        //结合ip位置信息
        baseDataObject.setClientIp(preParsedLog.getClientIp().toString());
        baseDataObject.setIpLocation(IpLocationParser.parse(preParsedLog.getClientIp().toString()));
        //解析UserAgent信息
        baseDataObject.setUserAgent(preParsedLog.getUserAgent().toString());
        baseDataObject.setUserAgentInfo(UserAgent.parseUserAgentString(preParsedLog.getUserAgent().toString()));

    }

}
