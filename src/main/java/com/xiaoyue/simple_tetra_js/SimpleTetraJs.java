package com.xiaoyue.simple_tetra_js;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(SimpleTetraJs.MODID)
public class SimpleTetraJs
{
    public static final String MODID = "simple_tetra_js";
    public static final Logger LOGGER = LogUtils.getLogger();

    public SimpleTetraJs() {
    }

    public static ResourceLocation loc(String s) {
        return new ResourceLocation(MODID, s);
    }
}
