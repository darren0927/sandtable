package org.darren.config;

/**
 * @author 谈冬
 * @date 2024年05月28日 14:43
 */
public class GlobalRuleKeeper {

    private boolean                       agentOpen                 = true;

    private static final GlobalRuleKeeper instance                  = new GlobalRuleKeeper();

    public static GlobalRuleKeeper getInstance() {
        return instance;
    }

    public boolean isAgentOpen() {
        return agentOpen;
    }

    public void setAgentOpen(boolean agentOpen) {
        this.agentOpen = agentOpen;
    }
}
