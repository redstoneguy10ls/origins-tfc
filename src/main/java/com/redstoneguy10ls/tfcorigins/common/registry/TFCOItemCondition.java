package com.redstoneguy10ls.tfcorigins.common.registry;

import com.redstoneguy10ls.tfcorigins.common.conditions.item.IsRottenCondition;
import io.github.edwinmindcraft.apoli.common.condition.item.SimpleItemCondition;
import net.dries007.tfc.common.capabilities.food.FoodCapability;
import net.minecraftforge.registries.RegistryObject;

public class TFCOItemCondition {

    public static final RegistryObject<IsRottenCondition> IS_ROTTEN = TFCORegister.ITEM_CONDITIONS.register("is_rotten", IsRottenCondition::new);

    public static void register() {}
}
