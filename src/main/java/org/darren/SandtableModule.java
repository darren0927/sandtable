package org.darren;

import ch.qos.logback.core.joran.spi.JoranException;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.darren.config.Constants;
import org.darren.config.GlobalRuleKeeper;
import org.darren.config.IConfig;
import org.darren.enhance.EnhancerFactory;

import java.util.Properties;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author darren
 */
public class SandtableModule {

    public String name() {
        return Constants.MODULE_NAME;
    }

    public String version() {
        return null;
    }

    public void onLoad() throws Throwable {
        initLoggerContext();
    }

    public void onActive() throws Throwable {
        try {
            boolean isAgentOpen = GlobalRuleKeeper.getInstance().isAgentOpen();

            if (isAgentOpen) {
                EnhancerFactory.getInstance().immediatelyEnhance();
            }

            //心跳
            heartbeat();
        } catch (Throwable t){
            throw t;
        }
    }
    public void onUnload() throws Throwable {
        //打印日志
    }

    public int order() {
        return 202;
    }

    public IConfig config() {
        /**
         * 配置变更回调，每次变更，只会收到一次回调
         */
        return new IConfig() {
            public void onConfigChanged(Properties properties) {
                try {
                    // 下发规则
                    String rules = properties.getProperty("rule");
                    // 规则处理

                    // 修改配置
                    String config = properties.getProperty("config");
                    if (config != null) {
                        // 修改配置
                    }
                } catch (Throwable e) {
                    // todo 打印日志
                }
            }
        };
    }

    /**
     * 初始化日志上下文，sandtable打印单独的日志文件
     */
    private void initLoggerContext() throws JoranException {
        // 初始化日志上下文，打印单独的日志文件
    }

    /**
     * 心跳
     */
    private void heartbeat() {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("scheduled-pool-%d").daemon(true)
                        .build());

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                // 打印心跳日志
            }
        }, 1, 10, TimeUnit.MINUTES);
    }

}
