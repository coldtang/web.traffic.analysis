package com.tang.parser.objectbuilder;

import com.tang.parser.dataobject.BaseDataObject;
import com.tang.parser.dataobject.HeartbeatDataObject;
import com.tang.parser.utils.ColumnReader;
import com.tang.parser.utils.ParserUtils;
import com.tang.preparser.PreParserLog;

import java.util.ArrayList;
import java.util.List;

public class HeartbeatDataObjectBuilder extends AbstractDataObjectBuilder {
    @Override
    public String getCommand() {
        return "hb";
    }

    @Override
    public List<BaseDataObject> doBuildDataObjects(PreParserLog preParsedLog) {
        List<BaseDataObject> dataObjects = new ArrayList<>();
        HeartbeatDataObject dataObject = new HeartbeatDataObject();
        ColumnReader columnReader = new ColumnReader(preParsedLog.getQueryString());
        fillCommonBaseDataObjectValue(dataObject, preParsedLog, columnReader);

        int loadingDuration = 0;
        String plt = columnReader.getStringValue("plt");
        if (!ParserUtils.isNullOrEmptyOrDash(plt)) {
            loadingDuration = Math.round(Float.parseFloat(plt));
        }
        dataObject.setLoadingDuration(loadingDuration);

        int clientPageDuration = 0;
        String psd = columnReader.getStringValue("psd");
        if (!ParserUtils.isNullOrEmptyOrDash(psd)) {
            clientPageDuration = Math.round(Float.parseFloat(psd));
        }
        dataObject.setClientPageDuration(clientPageDuration);

        dataObjects.add(dataObject);
        return dataObjects;
    }
}
