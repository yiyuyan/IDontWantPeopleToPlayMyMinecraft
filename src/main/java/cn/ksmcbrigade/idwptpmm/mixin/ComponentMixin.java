package cn.ksmcbrigade.idwptpmm.mixin;

import cn.ksmcbrigade.idwptpmm.utils.TextUtils;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.LiteralContents;
import net.minecraft.network.chat.contents.TranslatableContents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import javax.annotation.Nullable;

@Mixin(Component.class)
public interface ComponentMixin {

    /**
     * @author KSmc_brigade
     * @reason add text utils
     */
    @Overwrite
    static Component nullToEmpty(@Nullable String p_130675_) {
        String text = TextUtils.get(p_130675_);
        return text != null ? literal(text) : CommonComponents.EMPTY;
    }

    /**
     * @author KSmc_brigade
     * @reason add text utils
     */
    @Overwrite
    static MutableComponent literal(String p_237114_) {
        return MutableComponent.create(new LiteralContents(TextUtils.get(p_237114_)));
    }

    /**
     * @author KSmc_brigade
     * @reason add text utils
     */
    @Overwrite
    static MutableComponent translatable(String p_237111_, Object... p_237112_) {
        return MutableComponent.create(new LiteralContents(TextUtils.get(MutableComponent.create(new TranslatableContents(p_237111_, null, p_237112_)).getString())));
    }
}
