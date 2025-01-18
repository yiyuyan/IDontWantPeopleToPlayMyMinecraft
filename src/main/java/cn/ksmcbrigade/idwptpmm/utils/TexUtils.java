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
        if(or.getPath().contains("block")){
            List<ResourceLocation> resourceLocations = IDontWantPeopleToPlayMyMinecraft.resources.stream().filter(location -> location.getPath().startsWith("textures/block")).toList();;
            ResourceLocation r = resourceLocations.get(random.nextInt(0,resourceLocations.size()-1));
            if(r.getPath().endsWith(".mcmeta")){
                r = new ResourceLocation(r.getNamespace(),r.getPath().replace(".mcmeta",""));
            }
            map.put(or,r);
            return r;
        }
        else if(or.getPath().contains("item")){
            List<ResourceLocation> resourceLocations = IDontWantPeopleToPlayMyMinecraft.resources.stream().filter(location -> location.getPath().startsWith("textures/item")).toList();;
            ResourceLocation r = resourceLocations.get(random.nextInt(0,resourceLocations.size()-1));
            if(r.getPath().endsWith(".mcmeta")){
                r = new ResourceLocation(r.getNamespace(),r.getPath().replace(".mcmeta",""));
            }
            map.put(or,r);
            return r;
        }
        else if(or.getPath().contains("entity")){
            List<ResourceLocation> resourceLocations = IDontWantPeopleToPlayMyMinecraft.resources.stream().filter(location -> location.getPath().startsWith("textures/entity")).toList();;
            ResourceLocation r = resourceLocations.get(random.nextInt(0,resourceLocations.size()-1));
            if(r.getPath().endsWith(".mcmeta")){
                r = new ResourceLocation(r.getNamespace(),r.getPath().replace(".mcmeta",""));
            }
            map.put(or,r);
            return r;
        }
        else if(or.getPath().contains("lang") || or.getPath().toLowerCase().contains("font") || or.getPath().toLowerCase().contains("ascii") || or.getPath().toLowerCase().contains("default") || or.getPath().toLowerCase().contains("uniform") || or.getPath().toLowerCase().contains("alt/0") || or.getPath().toLowerCase().contains("nonlatin_european") || or.getPath().toLowerCase().contains("illageralt")){
            map.put(or,or);
            return or;
        }
        ResourceLocation r = IDontWantPeopleToPlayMyMinecraft.resources.get(random.nextInt(0,IDontWantPeopleToPlayMyMinecraft.resources.size()-1));
        if(r.getPath().endsWith(".mcmeta")){
            r = new ResourceLocation(r.getNamespace(),r.getPath().replace(".mcmeta",""));
        }
        map.put(or,r);
        return r;
    }
}
