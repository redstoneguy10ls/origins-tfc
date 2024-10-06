package com.redstoneguy10ls.tfcorigins.access;

import com.redstoneguy10ls.tfcorigins.common.powers.ModifyTFCFoodPower;
import com.redstoneguy10ls.tfcorigins.common.powers.configuration.ModifyTFCFoodConfiguration;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredPower;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public interface TFCModifiableFoodEntity {
    ItemStack getOriginalFoodStack();

    void setOriginalFoodStack(ItemStack original);

    LivingEntity getPlayer();

    void setPlayer(LivingEntity value);

    List<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> getCurrentModifyFoodPowers();

    void setCurrentModifyFoodPowers(List<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> powers);

    void enforceFoodSync();

    void resetFoodSync();

    boolean shouldSyncFood();
}
