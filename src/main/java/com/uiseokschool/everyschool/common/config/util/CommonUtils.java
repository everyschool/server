package com.uiseokschool.everyschool.common.config.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonUtils {

    public static String getServerIp() {
        String serverIp = null;
        try {
            serverIp = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException ignore) {
            log.warn("CommonUtils.getServerIp() ");
        }
        return serverIp;
    }

}
