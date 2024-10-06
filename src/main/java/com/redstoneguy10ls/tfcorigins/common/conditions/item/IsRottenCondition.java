package com.redstoneguy10ls.tfcorigins.common.conditions.item;

import io.github.edwinmindcraft.apoli.api.configuration.NoConfiguration;
import io.github.edwinmindcraft.apoli.api.power.factory.ItemCondition;
import net.dries007.tfc.common.capabilities.food.FoodCapability;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.atomic.AtomicInteger;

public class IsRottenCondition extends ItemCondition<NoConfiguration> {
    public IsRottenCondition() {
        super(NoConfiguration.CODEC);
    }

    @Override
    public boolean check(NoConfiguration configuration, @Nullable Level level, ItemStack stack)
    {
        AtomicInteger bruh = new AtomicInteger();
        stack.getCapability(FoodCapability.CAPABILITY).ifPresent(food->  {
            if(food.isRotten())
            {
                bruh.set(1);
            }
        });
        return bruh.get() == 1;

    }
}
