package com.tang.preparser;

/**
 * 获取原始数据信息
 * @author tang
 */
public class WebLogPreParser {
    public static PreParserLog parser(String line) {
        if (line.startsWith("#")) {
            return null;
        }else {
            PreParserLog preParserLog=new PreParserLog();
            String[] temps = line.split(" ");
            preParserLog.setServerTime(temps[0] + " " + temps[1]);
            preParserLog.setServerIp(temps[2]);
            preParserLog.setMethod(temps[3]);
            preParserLog.setUriStem(temps[4]);
            String queryString = temps[5];
            preParserLog.setQueryString(queryString);
            String[] queryStrTemps = queryString.split("&");
            String command = queryStrTemps[1].split("=")[1];
            preParserLog.setCommand(command);
            String profileIdStr = queryStrTemps[2].split("=")[1];
            preParserLog.setProfileId(getProfileId(profileIdStr));
            preParserLog.setServerPort(Integer.parseInt(temps[6]));
            preParserLog.setClientIp(temps[8]);
            preParserLog.setUserAgent(temps[9].replace("+", " "));
            String tempTime = preParserLog.getServerTime().replace("-", "");
            preParserLog.setDay(Integer.parseInt(tempTime.substring(0, 8)));
            preParserLog.setMonth(Integer.parseInt(tempTime.substring(0, 6)));
            preParserLog.setYear(Integer.parseInt(tempTime.substring(0, 4)));
            return  preParserLog;
        }
    }

    /**
     * 获取网站唯一标识
     * @param profileIdStr
     * @return 网站唯一标识
     */
    private static int getProfileId(String profileIdStr) {
        return Integer.valueOf(profileIdStr.substring(profileIdStr.indexOf("-") + 1));
    }
}
