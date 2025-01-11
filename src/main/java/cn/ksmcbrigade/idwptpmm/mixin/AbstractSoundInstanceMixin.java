package cn.ksmcbrigade.idwptpmm.mixin;

import cn.ksmcbrigade.idwptpmm.utils.SoundUtils;
import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractSoundInstance.class)
public class AbstractSoundInstanceMixin {
    @Mutable
    @Shadow @Final protected ResourceLocation location;

    @Inject(method = "<init>(Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/sounds/SoundSource;Lnet/minecraft/util/RandomSource;)V",at = @At("TAIL"))
    public void location(ResourceLocation p_235068_, SoundSource p_235069_, RandomSource p_235070_, CallbackInfo ci){
        this.location = SoundUtils.get(p_235068_);
    }
}
