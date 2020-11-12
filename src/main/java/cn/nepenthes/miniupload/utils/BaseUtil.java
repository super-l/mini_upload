package cn.nepenthes.miniupload.utils;

import java.util.UUID;

public class BaseUtil {

    public static String getUUID32(){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }

}
