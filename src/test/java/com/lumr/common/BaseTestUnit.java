package com.lumr.common;

import com.lumr.sbeam.Application;
import com.lumr.sbeam.config.RootConfig;
import com.lumr.sbeam.config.ShiroConfigure;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lumr
 * @since 2019/9/22 下午8:32
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {Application.class, RootConfig.class, ShiroConfigure.class})
@TestPropertySource({"/application.yml", "/application-dev.yml"})
@ActiveProfiles("dev")
public abstract class BaseTestUnit {

}
