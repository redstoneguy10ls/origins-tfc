package com.redstoneguy10ls.tfcorigins.common.registry;

import com.redstoneguy10ls.tfcorigins.common.action.entity.TFCAddNutrients;
import com.redstoneguy10ls.tfcorigins.common.action.entity.TFCFeed;
import com.redstoneguy10ls.tfcorigins.common.powers.ModifyTFCFoodPower;
import io.github.edwinmindcraft.apoli.api.MetaFactories;
import net.minecraftforge.registries.RegistryObject;

import static io.github.edwinmindcraft.apoli.common.registry.ApoliRegisters.ENTITY_ACTIONS;

public class TFCOEntityActions {

    public static final RegistryObject<TFCFeed> TFCFEED = TFCORegister.ENTITY_ACTIONS.register("tfc_feed", TFCFeed::new);
    public static final RegistryObject<TFCAddNutrients> TFC_ADD_NUTRIENTS = TFCORegister.ENTITY_ACTIONS.register("add_nutrients", TFCAddNutrients::new);


    public static void register() {}

}
