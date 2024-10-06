package com.redstoneguy10ls.tfcorigins.common.conditions.entity;

import io.github.edwinmindcraft.apoli.api.configuration.FloatComparisonConfiguration;
import io.github.edwinmindcraft.apoli.api.power.factory.EntityCondition;
import net.dries007.tfc.util.climate.Climate;
import net.minecraft.world.entity.Entity;

public class CurrentTempCondition extends EntityCondition<FloatComparisonConfiguration> {


    public CurrentTempCondition() {
        super(FloatComparisonConfiguration.CODEC);
    }

    @Override
    public boolean check(FloatComparisonConfiguration configuration, Entity entity) {
        return configuration.check(Climate.getTemperature(entity.level(),entity.getOnPos()));
    }


}
