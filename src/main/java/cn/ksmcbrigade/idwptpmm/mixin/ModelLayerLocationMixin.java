package cn.ksmcbrigade.idwptpmm.mixin;

import cn.ksmcbrigade.idwptpmm.IDontWantPeopleToPlayMyMinecraft;
import cn.ksmcbrigade.idwptpmm.utils.ModelUtils;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ModelLayerLocation.class)
public class ModelLayerLocationMixin {
    @Inject(method = "getModel",at = @At("RETURN"),cancellable = true)
    public void model(CallbackInfoReturnable<ResourceLocation> cir){
        if(IDontWantPeopleToPlayMyMinecraft.reloading) return;
        cir.setReturnValue(ModelUtils.get(cir.getReturnValue()));
    }
}
