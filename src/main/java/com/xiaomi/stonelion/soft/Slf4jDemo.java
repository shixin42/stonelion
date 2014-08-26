package com.xiaomi.stonelion.soft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ishikin on 14-11-27.
 *
 * 在maven中依赖如下就可以：
 * <dependency>
 * <groupId>org.slf4j</groupId>
 * <artifactId>slf4j-log4j12</artifactId>
 * <version>1.7.5</version>
 * </dependency>
 */
public class Slf4jDemo {
    private static Logger logger = LoggerFactory.getLogger(Slf4jDemo.class);

    public static void main(String[] args) {
        logger.info("hello world"); // 会在控制台输出hello world
    }
}
