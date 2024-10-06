package com.redstoneguy10ls.tfcorigins.common.action.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.edwinmindcraft.apoli.api.IDynamicFeatureConfiguration;
import io.github.edwinmindcraft.calio.api.network.CalioCodecHelper;

public record TFCNutrientConfiguration(float grain, float fruit, float vegetable, float protien, float dairy) implements IDynamicFeatureConfiguration {

    public static Codec<TFCNutrientConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            CalioCodecHelper.FLOAT.optionalFieldOf("grain",0.0f).forGetter(TFCNutrientConfiguration::grain),
            CalioCodecHelper.FLOAT.optionalFieldOf("fruit",0.0f).forGetter(TFCNutrientConfiguration::fruit),
            CalioCodecHelper.FLOAT.optionalFieldOf("vegetable",0.0f).forGetter(TFCNutrientConfiguration::vegetable),
            CalioCodecHelper.FLOAT.optionalFieldOf("protien",0.0f).forGetter(TFCNutrientConfiguration::protien),
            CalioCodecHelper.FLOAT.optionalFieldOf("dairy",0.0f).forGetter(TFCNutrientConfiguration::dairy)
    ).apply(instance, TFCNutrientConfiguration::new));
}



