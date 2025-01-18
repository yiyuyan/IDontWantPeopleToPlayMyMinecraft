package cn.ksmcbrigade.idwptpmm.mixin;

import cn.ksmcbrigade.idwptpmm.utils.TextUtils;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.LiteralContents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.ArrayList;

@Mixin(value = GuiGraphics.class)
public class DrawContextMixin {
    @ModifyVariable(remap = false,method = "drawString(Lnet/minecraft/client/gui/Font;Ljava/lang/String;FFIZ)I", at = @At("HEAD"), ordinal = 0, index = 2, argsOnly = true)
    public String text(String value){
        return TextUtils.get(value);
    }

    @ModifyVariable(method = "drawString(Lnet/minecraft/client/gui/Font;Lnet/minecraft/network/chat/Component;III)I", at = @At("HEAD"), ordinal = 0, index = 2, argsOnly = true)
    public Component text2(Component value){
        return new MutableComponent(new LiteralContents(value.getString()),new ArrayList<>(value.getSiblings()),value.getStyle());
    }

    @ModifyVariable(method = "drawCenteredString(Lnet/minecraft/client/gui/Font;Ljava/lang/String;III)V", at = @At("HEAD"), ordinal = 0, index = 2, argsOnly = true)
    public String text3(String value){
        return TextUtils.get(value);
    }

    @ModifyVariable(method = "drawCenteredString(Lnet/minecraft/client/gui/Font;Lnet/minecraft/network/chat/Component;III)V", at = @At("HEAD"), ordinal = 0, index = 2, argsOnly = true)
    public Component text4(Component value){
        return new MutableComponent(new LiteralContents(value.getString()),new ArrayList<>(value.getSiblings()),value.getStyle());
    }
}
