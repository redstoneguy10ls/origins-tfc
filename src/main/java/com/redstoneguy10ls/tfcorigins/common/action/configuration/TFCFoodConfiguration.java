package com.redstoneguy10ls.tfcorigins.common.action.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.edwinmindcraft.apoli.api.IDynamicFeatureConfiguration;
import io.github.edwinmindcraft.calio.api.network.CalioCodecHelper;

public record TFCFoodConfiguration(int food, float saturation, float water) implements IDynamicFeatureConfiguration {

    public static Codec<TFCFoodConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            CalioCodecHelper.INT.fieldOf("food").forGetter(TFCFoodConfiguration::food),
            CalioCodecHelper.FLOAT.fieldOf("saturation").forGetter(TFCFoodConfiguration::saturation),
            CalioCodecHelper.FLOAT.fieldOf("water").forGetter(TFCFoodConfiguration::water)
    ).apply(instance, TFCFoodConfiguration::new));
}




