package cn.ksmcbrigade.idwptpmm.mixin;

import cn.ksmcbrigade.idwptpmm.utils.TextUtils;
import net.minecraft.client.gui.Font;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.LiteralContents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.ArrayList;

@Mixin(Font.class)
public class FontMixin {
    @ModifyVariable(method = "renderText(Ljava/lang/String;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/client/gui/Font$DisplayMode;II)F", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    public String text(String value){
        return TextUtils.get(value);
    }

    @ModifyVariable(method = "drawInternal(Ljava/lang/String;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/client/gui/Font$DisplayMode;IIZ)I", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    public String text2(String value){
        return TextUtils.get(value);
    }

    @ModifyVariable(method = "drawInBatch(Lnet/minecraft/network/chat/Component;FFIZLorg/joml/Matrix4f;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/client/gui/Font$DisplayMode;II)I", at = @At("HEAD"), ordinal = 0, argsOnly = true)
    public Component text3(Component value){
        return new MutableComponent(new LiteralContents(value.getString()),new ArrayList<>(value.getSiblings()),value.getStyle());
    }
}
