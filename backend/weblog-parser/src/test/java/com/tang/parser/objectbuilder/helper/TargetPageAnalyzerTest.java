package com.tang.parser.objectbuilder.helper;

import com.tang.metadata.api.ProfileConfigManager;
import com.tang.metadata.api.impl.MongoProfileConfigManager;
import com.tang.parser.configuration.TargetConfigMatcher;
import com.tang.parser.configuration.loader.ProfileConfigLoader;
import com.tang.parser.configuration.loader.impl.DefaultProfileConfigLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TargetPageAnalyzerTest {

    private TargetPageAnalyzer targetPageAnalyzer;

    @Before
    public void setUp() throws Exception {
        ProfileConfigManager profileConfigManager = new MongoProfileConfigManager();
        ProfileConfigLoader profileConfigLoader = new DefaultProfileConfigLoader(profileConfigManager);
        targetPageAnalyzer = new TargetPageAnalyzer(profileConfigLoader);
    }

    @Test
    public void getTargetHits() {
        List<TargetConfigMatcher> targetConfigMatchers =
                targetPageAnalyzer.getTargetHits(702, "https://www.underarmour.cn/shopping/checkoutLogin");
        Assert.assertEquals(1, targetConfigMatchers.size());
        TargetConfigMatcher matcher = targetConfigMatchers.get(0);
        Assert.assertEquals("57f8df278a4bf51e2d834be9", matcher.getKey());
        Assert.assertEquals("test target", matcher.getTargetName());
        Assert.assertEquals(true, matcher.isActive());
    }
}