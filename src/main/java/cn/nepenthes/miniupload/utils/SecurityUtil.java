package cn.nepenthes.miniupload.utils;

public class SecurityUtil {

    public static boolean isCommonStr(String str) {
        String regex = "^[a-z0-9A-Z_]+$";
        return str.matches(regex);
    }

}
