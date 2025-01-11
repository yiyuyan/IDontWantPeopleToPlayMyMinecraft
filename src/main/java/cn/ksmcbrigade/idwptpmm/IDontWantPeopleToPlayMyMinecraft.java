package cn.ksmcbrigade.idwptpmm;

import cn.ksmcbrigade.idwptpmm.utils.ModelUtils;
import cn.ksmcbrigade.idwptpmm.utils.SoundUtils;
import cn.ksmcbrigade.idwptpmm.utils.TexUtils;
import cn.ksmcbrigade.idwptpmm.utils.TextUtils;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.slf4j.Logger;

import java.util.ArrayList;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(IDontWantPeopleToPlayMyMinecraft.MODID)
public class IDontWantPeopleToPlayMyMinecraft {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "idwptpmm";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static boolean reloading = false;

    public static final ArrayList<ResourceLocation> resources = new ArrayList<>();
    public static ArrayList<ResourceLocation> sounds = new ArrayList<>();
    public static ArrayList<ResourceLocation> models = new ArrayList<>();

    public static long update = 0;

    public IDontWantPeopleToPlayMyMinecraft() {
        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT,Config.SPEC);
    }

    @SubscribeEvent
    public void clientTick(TickEvent.ClientTickEvent event){
        if(!Config.SPEC.isLoaded()) return;
        if(update==0){
            TexUtils.shouldReload = true;
            TextUtils.shouldReload = true;
            SoundUtils.shouldReload = true;
            ModelUtils.shouldReload = true;
            update = Config.CLIENT_RANDOM_TICK.get();
        }
        else{
            update--;
        }
    }
}
