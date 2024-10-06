package com.redstoneguy10ls.tfcorigins.common.powers;

import com.mojang.serialization.Codec;
import com.redstoneguy10ls.tfcorigins.common.powers.configuration.DehydrateOverTimeConfiguration;
import io.github.edwinmindcraft.apoli.api.power.factory.PowerFactory;
import net.dries007.tfc.common.capabilities.food.TFCFoodData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;


public class DehydrateOverTime extends PowerFactory<DehydrateOverTimeConfiguration> {

    public DehydrateOverTime() {
        super(DehydrateOverTimeConfiguration.CODEC);
        this.ticking();
    }

    @Override
    protected void tick(DehydrateOverTimeConfiguration configuration, Entity player)
    {
        if(player instanceof Player p)
        {
            if(p.getFoodData() instanceof TFCFoodData data)
            {
                data.addThirst(-1*configuration.dehydration());
            }
        }
    }

    @Override
    protected int tickInterval(DehydrateOverTimeConfiguration configuration, Entity entity) {
        return configuration.interval();
    }
}
