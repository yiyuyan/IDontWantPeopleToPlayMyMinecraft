package cn.ksmcbrigade.idwptpmm;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec.ConfigValue<Long> CLIENT_RANDOM_TICK = BUILDER.define("tick_random",200L);
    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
