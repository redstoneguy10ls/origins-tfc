package com.redstoneguy10ls.tfcorigins.common.powers.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.edwinmindcraft.apoli.api.IDynamicFeatureConfiguration;
import io.github.edwinmindcraft.apoli.common.power.configuration.ExhaustOverTimeConfiguration;
import io.github.edwinmindcraft.calio.api.network.CalioCodecHelper;

public record DehydrateOverTimeConfiguration(int interval, float dehydration) implements IDynamicFeatureConfiguration {

    public static final Codec<DehydrateOverTimeConfiguration> CODEC = RecordCodecBuilder.create(intance -> intance.group(
            CalioCodecHelper.optionalField(Codec.intRange(1,Integer.MAX_VALUE), "interval", 20).forGetter(DehydrateOverTimeConfiguration::interval),
                    CalioCodecHelper.FLOAT.fieldOf("dehydration").forGetter(DehydrateOverTimeConfiguration::dehydration)
    ).apply(intance, DehydrateOverTimeConfiguration::new));
}
