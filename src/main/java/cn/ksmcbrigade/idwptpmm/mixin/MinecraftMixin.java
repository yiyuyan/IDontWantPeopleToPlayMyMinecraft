package cn.ksmcbrigade.idwptpmm.mixin;

import cn.ksmcbrigade.idwptpmm.IDontWantPeopleToPlayMyMinecraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {

    @Inject(method = "reloadResourcePacks(Z)Ljava/util/concurrent/CompletableFuture;",at = @At("TAIL"))
    public void reload(boolean p_168020_, CallbackInfoReturnable<CompletableFuture<Void>> cir) throws NoSuchFieldException, IllegalAccessException {
        IDontWantPeopleToPlayMyMinecraft.resources.clear();
        IDontWantPeopleToPlayMyMinecraft.models.clear();
        IDontWantPeopleToPlayMyMinecraft.reloading = true;
        for (PackResources packResources : Minecraft.getInstance().getResourceManager().listPacks().toList()) {
            for (String namespace : packResources.getNamespaces(PackType.CLIENT_RESOURCES)) {
                packResources.listResources(PackType.CLIENT_RESOURCES, namespace, "textures", (resourceLocation, inputStreamIoSupplier) -> {
                    IDontWantPeopleToPlayMyMinecraft.resources.add(resourceLocation);
                });

            }

        }
        IDontWantPeopleToPlayMyMinecraft.sounds = new ArrayList<>(Minecraft.getInstance().getSoundManager().getAvailableSounds());
        EntityModelSet instance = Minecraft.getInstance().getEntityModels();
        Field field = instance.getClass().getDeclaredField("roots");
        field.setAccessible(true);
        for (ModelLayerLocation modelLayerLocation : ((Map<ModelLayerLocation, LayerDefinition>) field.get(instance)).keySet()) {
            IDontWantPeopleToPlayMyMinecraft.models.add(modelLayerLocation.getModel());
        }
        IDontWantPeopleToPlayMyMinecraft.reloading = false;
    }
}
