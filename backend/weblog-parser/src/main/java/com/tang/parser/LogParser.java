package com.tang.parser;

import com.tang.parser.dataobject.InvalidLogObject;
import com.tang.parser.dataobject.ParsedDataObject;
import com.tang.parser.objectbuilder.AbstractDataObjectBuilder;
import com.tang.preparser.PreParserLog;

import java.util.Arrays;
import java.util.List;

public class LogParser {
    //LogParser需要的设置对象
    private LogParserSetting logParserSetting;
    //LogParser中所有的日志builders
    private List<AbstractDataObjectBuilder> builders;

    public LogParser(LogParserSetting logParserSetting, List<AbstractDataObjectBuilder> builders) {
        this.logParserSetting = logParserSetting;
        this.builders = builders;
    }

    /**
     * 日志解析的接口
     *  返回的对象中，含有正常的DataObject，也可能含有无效的DataObject，所以我们返回标识接口ParsedDataObject
     *  不管是正常的DataObject还是无效的DataObject都会实现这个标识接口ParsedDataObject
     * @param preParsedLog
     * @return 返回已经解析好的DataObject
     */
    public List<? extends ParsedDataObject> parse(PreParserLog preParsedLog) {
        String cmd = preParsedLog.getCommand().toString();
        //看看是否是支持的日志类型
        if (!logParserSetting.getCmds().contains(cmd)) {
            return Arrays.asList(new InvalidLogObject("not support command"));
        }
        for (AbstractDataObjectBuilder builder : builders) {
            if (builder.getCommand().equals(cmd)) {
                return builder.doBuildDataObjects(preParsedLog);
            }
        }
        //确定没有找到对应的builder
        return Arrays.asList(new InvalidLogObject("not found builder"));
    }
}
