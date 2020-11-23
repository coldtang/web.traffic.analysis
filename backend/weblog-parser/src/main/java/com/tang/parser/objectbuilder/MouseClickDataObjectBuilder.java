package com.tang.parser.objectbuilder;

import com.tang.parser.dataobject.BaseDataObject;
import com.tang.parser.dataobject.McDataObject;
import com.tang.parser.utils.ColumnReader;
import com.tang.parser.utils.ParserUtils;
import com.tang.parser.utils.UrlInfo;
import com.tang.preparser.PreParserLog;
import static com.tang.parser.utils.UrlParseUtils.getInfoFromUrl;
import java.util.ArrayList;
import java.util.List;

/**
 * 鼠标点击数据解析
 * @author tang
 */
public class MouseClickDataObjectBuilder extends AbstractDataObjectBuilder {
    private static int clickXBoundary = 10000;
    private static int clickYBoundary = 100000;

    @Override
    public String getCommand() {
        return "mc";
    }

    @Override
    public List<BaseDataObject> doBuildDataObjects(PreParserLog preParsedLog) {
        List<BaseDataObject> dataObjects = new ArrayList<>();
        //解析并填充公用字段
        McDataObject mcDataObject = new McDataObject();
        ColumnReader reader = new ColumnReader(preParsedLog.getQueryString());
        fillCommonBaseDataObjectValue(mcDataObject, preParsedLog, reader);

        //解析mc并填充特有的字段
        //点击页面的信息
        UrlInfo urlInfo = getInfoFromUrl(reader.getStringValue("gsmcurl"));
        mcDataObject.setUrl(urlInfo.getFullUrl());
        mcDataObject.setOriginalUrl(reader.getStringValue("gsorurl"));
        mcDataObject.setPageTitle(reader.getStringValue("gstl"));
        mcDataObject.setPageHostName(urlInfo.getDomain());
        mcDataObject.setPageRegion(getIntValue("re", reader));
        mcDataObject.setPageVersion(reader.getStringValue("pageVersion"));
        mcDataObject.setSnapshotId(Integer.parseInt(reader.getStringValue("gssn")));
        //点击的x和y值
        int accurateClickX = Integer.parseInt(reader.getStringValue("gsmcoffsetx"));
        int accurateClickY = Integer.parseInt(reader.getStringValue("gsmcoffsety"));
        mcDataObject.setClickX(accurateClickX);
        mcDataObject.setClickY(accurateClickY);
        //点击的链接信息
        mcDataObject.setLinkX(getValidClickXYPoint(getIntValue("lx", reader), clickXBoundary, -1 * clickXBoundary));
        mcDataObject.setLinkY(getValidClickXYPoint(getIntValue("ly", reader), clickYBoundary, 0));
        mcDataObject.setLinkHeight(getIntValue("lh", reader));
        mcDataObject.setLinkWidth(getIntValue("lw", reader));
        mcDataObject.setLinkText(reader.getStringValue("lt"));
        mcDataObject.setLinkUrl(reader.getStringValue("lk"));
        mcDataObject.setLinkHostName(getInfoFromUrl(mcDataObject.getLinkUrl()).getDomain());
        if (!ParserUtils.isNullOrEmptyOrDash(mcDataObject.getLinkUrl()) ||
                !ParserUtils.isNullOrEmptyOrDash(mcDataObject.getLinkText())) {
            mcDataObject.setLinkClicked(true);
        }
        //分辨率
        mcDataObject.setClickScreenResolution(reader.getStringValue("gsscr"));

        dataObjects.add(mcDataObject);
        return dataObjects;
    }

    /**
     * 转换类型
     * @param key
     * @param columnReader
     * @return
     */
    private Integer getIntValue(String key, ColumnReader columnReader) {
        String value = columnReader.getStringValue(key);
        if (!ParserUtils.isNullOrEmptyOrDash(value)) {
            return Integer.parseInt(value);
        } else {
            return 0;
        }
    }

    /**
     * 获取有效的高度宽度
     * @param point
     * @param maxBoundaryValue
     * @param minBoundaryValue
     * @return
     */
    private int getValidClickXYPoint(int point, int maxBoundaryValue,
                                     int minBoundaryValue) {
        if (point < minBoundaryValue) {
            return minBoundaryValue;
        } else if (point > maxBoundaryValue) {
            return maxBoundaryValue;
        } else {
            return point;
        }
    }
}
