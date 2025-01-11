package cn.ksmcbrigade.idwptpmm.mixin;

import cn.ksmcbrigade.idwptpmm.IDontWantPeopleToPlayMyMinecraft;
import cn.ksmcbrigade.idwptpmm.utils.TexUtils;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import static com.mojang.blaze3d.systems.RenderSystem.*;

@Mixin(value = RenderSystem.class,remap = false)
public class RenderSystemMixin {
    @Inject(method = "setShaderTexture(ILnet/minecraft/resources/ResourceLocation;)V",at= @At("HEAD"),cancellable = true,remap = false)
    private static void init(int p_157457_, ResourceLocation p_157458_, CallbackInfo ci){
        if(!IDontWantPeopleToPlayMyMinecraft.resources.isEmpty()){
            ResourceLocation newRes = TexUtils.get(p_157458_);
            if (!isOnRenderThread()) {
                recordRenderCall(() -> _setShaderTexture(p_157457_, newRes));
            } else {
                _setShaderTexture(p_157457_, newRes);
            }
            ci.cancel();
        }
    }

}
