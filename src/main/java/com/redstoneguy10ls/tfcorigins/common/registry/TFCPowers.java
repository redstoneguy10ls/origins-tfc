package com.redstoneguy10ls.tfcorigins.common.registry;



import com.redstoneguy10ls.tfcorigins.common.powers.DehydrateOverTime;
import com.redstoneguy10ls.tfcorigins.common.powers.ModifyTFCFoodPower;
import io.github.edwinmindcraft.apoli.api.registry.ApoliRegistries;
import net.minecraftforge.registries.DeferredRegister;
import io.github.edwinmindcraft.apoli.api.power.factory.PowerFactory;
import net.minecraftforge.registries.RegistryObject;

import static com.redstoneguy10ls.tfcorigins.TFCOrigins.MOD_ID;

public class TFCPowers {

    public static final RegistryObject<DehydrateOverTime> DEHYDRATE = TFCORegister.POWER_FACTORIES.register("dehydrate", DehydrateOverTime::new);
    public static final RegistryObject<ModifyTFCFoodPower> MODIFY_TFC_FOOD = TFCORegister.POWER_FACTORIES.register("modify_tfc_food", ModifyTFCFoodPower::new);

    public static void register() {}
}
