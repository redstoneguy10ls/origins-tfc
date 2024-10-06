package com.redstoneguy10ls.tfcorigins.common.action.entity;

import com.redstoneguy10ls.tfcorigins.common.action.configuration.TFCFoodConfiguration;
import io.github.edwinmindcraft.apoli.api.power.factory.EntityAction;
import net.dries007.tfc.common.capabilities.food.FoodData;
import net.dries007.tfc.common.capabilities.food.Nutrient;
import net.dries007.tfc.common.capabilities.food.TFCFoodData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class TFCFeed extends EntityAction<TFCFoodConfiguration> {

    public TFCFeed()
    {
        super(TFCFoodConfiguration.CODEC);
    }

    @Override
    public void execute(TFCFoodConfiguration configuration, Entity entity) {
            if(entity instanceof Player player)
            {

                if(player.getFoodData() instanceof TFCFoodData data)
                {
                    data.setFoodLevel(Mth.clamp(data.getFoodLevel()+configuration.food(),0,TFCFoodData.MAX_HUNGER));
                    data.setSaturation(Mth.clamp(data.getSaturationLevel()+configuration.saturation(),0,TFCFoodData.MAX_SATURATION));
                    data.addThirst(configuration.water());

                }


            }
    }
}
