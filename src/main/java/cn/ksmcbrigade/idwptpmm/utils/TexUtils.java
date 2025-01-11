package cn.ksmcbrigade.idwptpmm.utils;

import cn.ksmcbrigade.idwptpmm.IDontWantPeopleToPlayMyMinecraft;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TexUtils {

    public static boolean shouldReload = true;
    private static final Map<ResourceLocation,ResourceLocation> map = new HashMap<>();

    public static ResourceLocation get(ResourceLocation or){
        Random random = new Random();
        if(shouldReload){
            map.clear();
            shouldReload = false;
        }
        if(map.containsKey(or)) return map.get(or);
        //System.out.println(or.getPath());
        if(or.getPath().startsWith("textures/block")){
            List<ResourceLocation> resourceLocations = IDontWantPeopleToPlayMyMinecraft.resources.stream().filter(location -> location.getPath().startsWith("textures/block")).toList();;
            ResourceLocation r = resourceLocations.get(random.nextInt(0,resourceLocations.size()-1));
            map.put(or,r);
            return r;
        }
        else if(or.getPath().startsWith("textures/item")){
            List<ResourceLocation> resourceLocations = IDontWantPeopleToPlayMyMinecraft.resources.stream().filter(location -> location.getPath().startsWith("textures/item")).toList();;
            ResourceLocation r = resourceLocations.get(random.nextInt(0,resourceLocations.size()-1));
            map.put(or,r);
            return r;
        }
        else if(or.getPath().startsWith("textures/entity")){
            List<ResourceLocation> resourceLocations = IDontWantPeopleToPlayMyMinecraft.resources.stream().filter(location -> location.getPath().startsWith("textures/entity")).toList();;
            ResourceLocation r = resourceLocations.get(random.nextInt(0,resourceLocations.size()-1));
            map.put(or,r);
            return r;
        }
        else if(or.getPath().startsWith("lang")){
            map.put(or,or);
            return or;
        }
        ResourceLocation r = IDontWantPeopleToPlayMyMinecraft.resources.get(random.nextInt(0,IDontWantPeopleToPlayMyMinecraft.resources.size()-1));
        map.put(or,r);
        return r;
    }
}
