package cn.ksmcbrigade.idwptpmm.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TextUtils {
    public static boolean shouldReload = true;
    private static final Map<String,String> map = new HashMap<>();

    public static String get(String or){
        Random random = new Random();
        if(shouldReload){
            map.clear();
            shouldReload = false;
        }
        if(map.containsKey(or)) return map.get(or);
        String str = RandomStringUtils.randomAlphanumeric(or.length());
        map.put(or,str);
        return str;
    }
}
