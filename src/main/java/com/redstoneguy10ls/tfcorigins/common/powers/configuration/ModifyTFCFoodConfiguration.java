package com.redstoneguy10ls.tfcorigins.common.powers.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.apace100.calio.data.SerializableDataTypes;
import io.github.edwinmindcraft.apoli.api.IDynamicFeatureConfiguration;
import io.github.edwinmindcraft.apoli.api.configuration.ListConfiguration;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredEntityAction;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredItemAction;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredItemCondition;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredModifier;
import net.minecraft.core.Holder;
import io.github.edwinmindcraft.calio.api.network.CalioCodecHelper;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;
import java.util.Optional;

public record ModifyTFCFoodConfiguration(ListConfiguration<ConfiguredModifier<?>> foodModifiers,
                                         ListConfiguration<ConfiguredModifier<?>> saturationModifiers,
                                         ListConfiguration<ConfiguredModifier<?>> waterModifiers,
                                         ListConfiguration<ConfiguredModifier<?>> grainModifiers,
                                         ListConfiguration<ConfiguredModifier<?>> fruitModifiers,
                                         ListConfiguration<ConfiguredModifier<?>> vegetableModifiers,
                                         ListConfiguration<ConfiguredModifier<?>> protienModifiers,
                                         ListConfiguration<ConfiguredModifier<?>> dairyModifiers,
                                         Holder<ConfiguredItemCondition<?, ?>> itemCondition,
                                         Holder<ConfiguredEntityAction<?, ?>> entityAction,
                                         @Nullable ItemStack replaceStack,
                                         Holder<ConfiguredItemAction<?, ?>> itemAction,
                                         boolean alwaysEdible,
                                         boolean preventEffects, boolean ignoreRotten) implements IDynamicFeatureConfiguration {
    public static final Codec<ModifyTFCFoodConfiguration> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ListConfiguration.modifierCodec("food_modifier").forGetter(ModifyTFCFoodConfiguration::foodModifiers),
            ListConfiguration.modifierCodec("saturation_modifier").forGetter(ModifyTFCFoodConfiguration::saturationModifiers),
            ListConfiguration.modifierCodec("water_modifier").forGetter(ModifyTFCFoodConfiguration::waterModifiers),
            ListConfiguration.modifierCodec("grain_modifier").forGetter(ModifyTFCFoodConfiguration::grainModifiers),
            ListConfiguration.modifierCodec("fruit_modifier").forGetter(ModifyTFCFoodConfiguration::fruitModifiers),
            ListConfiguration.modifierCodec("vegetable_modifier").forGetter(ModifyTFCFoodConfiguration::vegetableModifiers),
            ListConfiguration.modifierCodec("protien_modifier").forGetter(ModifyTFCFoodConfiguration::protienModifiers),
            ListConfiguration.modifierCodec("dairy_modifier").forGetter(ModifyTFCFoodConfiguration::dairyModifiers),
            ConfiguredItemCondition.optional("item_condition").forGetter(ModifyTFCFoodConfiguration::itemCondition),
            ConfiguredEntityAction.optional("entity_action").forGetter(ModifyTFCFoodConfiguration::entityAction),
            CalioCodecHelper.optionalField(SerializableDataTypes.ITEM_STACK, "replace_stack").forGetter(x -> Optional.ofNullable(x.replaceStack())),
            ConfiguredItemAction.optional("item_action").forGetter(ModifyTFCFoodConfiguration::itemAction),
            CalioCodecHelper.optionalField(CalioCodecHelper.BOOL, "always_edible", false).forGetter(ModifyTFCFoodConfiguration::alwaysEdible),
            CalioCodecHelper.optionalField(CalioCodecHelper.BOOL, "prevent_effects", false).forGetter(ModifyTFCFoodConfiguration::preventEffects),
            CalioCodecHelper.optionalField(CalioCodecHelper.BOOL, "ignore_rotten", false).forGetter(ModifyTFCFoodConfiguration::ignoreRotten)
    ).apply(instance, (t1, t2, t3, t4, t5, t6, t7, t8,t9,t10,t11,t12,t13,t14,t15) -> new ModifyTFCFoodConfiguration(t1, t2, t3, t4, t5, t6, t7, t8,t9,t10,t11.orElse(null),t12,t13,t14,t15)));
}


