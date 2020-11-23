package com.tang.parser.objectbuilder;

import com.tang.parser.dataobject.BaseDataObject;
import com.tang.parser.dataobject.EventDataObject;
import com.tang.parser.utils.ColumnReader;
import com.tang.parser.utils.ParserUtils;
import com.tang.parser.utils.UrlParseUtils;
import com.tang.preparser.PreParserLog;

import java.util.ArrayList;
import java.util.List;

public class EventDataObjectBuilder extends AbstractDataObjectBuilder {
    @Override
    public String getCommand() {
        return "ev";
    }

    @Override
    public List<BaseDataObject> doBuildDataObjects(PreParserLog log){
        List<BaseDataObject> baseDataObjects = new ArrayList<>();
        EventDataObject eventDataObject = new EventDataObject();
        ColumnReader columnReader = new ColumnReader(log.getQueryString());
        fillCommonBaseDataObjectValue(eventDataObject, log, columnReader);

        eventDataObject.setEventCategory(columnReader.getStringValue("eca"));
        eventDataObject.setEventAction(columnReader.getStringValue("eac"));
        eventDataObject.setEventLabel(columnReader.getStringValue("ela"));
        String eva = columnReader.getStringValue("eva");
        if (!ParserUtils.isNullOrEmptyOrDash(eva)) {
            eventDataObject.setEventValue(Float.parseFloat(eva));
        }
        eventDataObject.setUrl(columnReader.getStringValue("gsurl"));
        eventDataObject.setOriginalUrl(columnReader.getStringValue("gsourl"));
        eventDataObject.setTitle(columnReader.getStringValue("gstl"));
        eventDataObject.setHostDomain(UrlParseUtils.getInfoFromUrl(eventDataObject.getUrl()).getDomain());

        baseDataObjects.add(eventDataObject);
        return baseDataObjects;
    }
}
