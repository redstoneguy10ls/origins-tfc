package com.redstoneguy10ls.tfcorigins.common.conditions.entity;

import io.github.edwinmindcraft.apoli.api.configuration.FloatComparisonConfiguration;
import io.github.edwinmindcraft.apoli.api.power.factory.EntityCondition;
import net.dries007.tfc.util.climate.Climate;
import net.minecraft.world.entity.Entity;

import java.util.function.Function;
import java.util.function.Predicate;

public class RainfallCondition extends EntityCondition<FloatComparisonConfiguration> {

    public RainfallCondition() {
        super(FloatComparisonConfiguration.CODEC);
    }

    @Override
    public boolean check(FloatComparisonConfiguration configuration, Entity entity) {
        return configuration.check(Climate.getRainfall(entity.level(),entity.getOnPos()));
    }


}
