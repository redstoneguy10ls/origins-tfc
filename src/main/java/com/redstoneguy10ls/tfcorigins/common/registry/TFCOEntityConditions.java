package com.redstoneguy10ls.tfcorigins.common.registry;

import com.redstoneguy10ls.tfcorigins.common.action.entity.TFCAddNutrients;
import com.redstoneguy10ls.tfcorigins.common.action.entity.TFCFeed;
import com.redstoneguy10ls.tfcorigins.common.conditions.entity.AverageTempCondition;
import com.redstoneguy10ls.tfcorigins.common.conditions.entity.CurrentTempCondition;
import com.redstoneguy10ls.tfcorigins.common.conditions.entity.RainfallCondition;
import io.github.edwinmindcraft.apoli.common.condition.entity.FloatComparingEntityCondition;
import io.github.edwinmindcraft.apoli.common.condition.entity.SimpleEntityCondition;
import net.dries007.tfc.util.climate.Climate;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.registries.RegistryObject;


import java.util.function.Function;
import java.util.function.Predicate;

public class TFCOEntityConditions {

    public static final RegistryObject<RainfallCondition> RAIN = TFCORegister.ENTITY_CONDITIONS.register("rainfall_condition",RainfallCondition::new);
    public static final RegistryObject<CurrentTempCondition> TEMP = TFCORegister.ENTITY_CONDITIONS.register("current_temperature_condition",CurrentTempCondition::new);

    public static final RegistryObject<AverageTempCondition> AVE_TEMP = TFCORegister.ENTITY_CONDITIONS.register("average_temperature_condition",AverageTempCondition::new);


    public static void register() {}

}
