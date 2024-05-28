package org.darren.enhance;

/**
 * @author 谈冬
 * @date 2024年05月28日 14:30
 */
public class EnhancerFactory {

    private static final EnhancerFactory instance = new EnhancerFactory();


    public static EnhancerFactory getInstance() {
        return instance;
    }

    public void immediatelyEnhance() {
    }
}