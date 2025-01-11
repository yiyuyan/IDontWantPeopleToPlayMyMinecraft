package cn.ksmcbrigade.idwptpmm.utils;

import cn.ksmcbrigade.idwptpmm.IDontWantPeopleToPlayMyMinecraft;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ModelUtils {
    public static boolean shouldReload = true;
    private static final Map<ResourceLocation,ResourceLocation> map = new HashMap<>();

    public static ResourceLocation get(ResourceLocation or){
        Random random = new Random();
        if(shouldReload){
            map.clear();
            shouldReload = false;
        }
        if(map.containsKey(or)) return map.get(or);
        ResourceLocation str = IDontWantPeopleToPlayMyMinecraft.models.get(random.nextInt(0,IDontWantPeopleToPlayMyMinecraft.models.size()-1));
        map.put(or,str);
        return str;
    }
}
