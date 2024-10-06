package com.redstoneguy10ls.tfcorigins;

import net.minecraft.resources.ResourceLocation;

import static com.redstoneguy10ls.tfcorigins.TFCOrigins.MOD_ID;

public class TFCOHelpers {
    public static ResourceLocation identifier(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

}
