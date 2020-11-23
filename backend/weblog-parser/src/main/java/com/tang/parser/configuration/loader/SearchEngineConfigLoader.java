package com.tang.parser.configuration.loader;

import com.tang.parser.configuration.SearchEngineConfig;

import java.util.List;

/**
 *  搜索引擎配置的加载接口
 * @author tang
 */
public interface SearchEngineConfigLoader {
    /**
     * 获取所有的搜索引擎配置信息
     * @return
     */
    public List<SearchEngineConfig> getSearchEngineConfigs();
}
