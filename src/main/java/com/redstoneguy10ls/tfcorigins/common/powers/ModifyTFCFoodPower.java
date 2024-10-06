package com.redstoneguy10ls.tfcorigins.common.powers;


import com.redstoneguy10ls.tfcorigins.common.powers.configuration.ModifyTFCFoodConfiguration;
import com.redstoneguy10ls.tfcorigins.common.registry.TFCPowers;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.util.AttributeUtil;
import io.github.apace100.apoli.util.modifier.ModifierUtil;
import io.github.edwinmindcraft.apoli.api.component.IPowerContainer;
import io.github.edwinmindcraft.apoli.api.configuration.ListConfiguration;
import io.github.edwinmindcraft.apoli.api.power.configuration.*;
import io.github.edwinmindcraft.apoli.api.power.factory.PowerFactory;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import net.minecraft.world.level.Level;
import org.apache.commons.lang3.mutable.Mutable;

import javax.annotation.Nullable;
/*
public class ModifyTFCFoodPower extends Power {

    private ListConfiguration<ConfiguredModifier<?>> foodModifiers;
    private ListConfiguration<ConfiguredModifier<?>> saturationModifiers;
    private Holder<ConfiguredItemCondition<?, ?>> itemCondition;
    private Holder<ConfiguredEntityAction<?, ?>> entityAction;
    private @Nullable ItemStack replaceStack;
    private Holder<ConfiguredItemAction<?, ?>> itemAction;
    private boolean alwaysEdible;
    private boolean preventEffects;

    public ModifyTFCFoodPower(PowerType<?> type, LivingEntity entity,ListConfiguration<ConfiguredModifier<?>> food,
                              ListConfiguration<ConfiguredModifier<?>> saturation,Holder<ConfiguredItemCondition<?, ?>> item,
                              Holder<ConfiguredEntityAction<?, ?>> entityA,@Nullable ItemStack replace,Holder<ConfiguredItemAction<?, ?>> itemA,
                              boolean alwaysEdible,boolean preventEffects) {
        super(type, entity);
        this.foodModifiers = food;
        this.saturationModifiers = saturation;
        this.itemCondition = item;
        this.entityAction = entityA;
        this.replaceStack = replace;
        this.itemAction=itemA;
        this.alwaysEdible=alwaysEdible;
        this.preventEffects=preventEffects;

    }
    public void modifyStack(Mutable<ItemStack> input)
    {
        if(this.replaceStack != null)
        {
            input.setValue(replaceStack.copy());
        }
    }

}
*/


public class ModifyTFCFoodPower extends PowerFactory<ModifyTFCFoodConfiguration> {

    public static List<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> getValidPowers(Entity source, ItemStack stack)
    {
        return getValidPowers(source, source.level(), stack);
    }
    public static List<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> getValidPowers(Entity source, Level level, ItemStack stack)
    {
        return IPowerContainer.getPowers(source, TFCPowers.MODIFY_TFC_FOOD.get()).stream().map(Holder::value)
                .filter(x -> x.getFactory().check(x, level, stack)).collect(Collectors.toList());
    }
    public static boolean isAlwaysEdible(Entity entity, Level level, ItemStack stack) {
        return getValidPowers(entity, level, stack).stream().anyMatch(x -> x.getConfiguration().alwaysEdible());
    }
    public static boolean ignore_rotten(List<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> source)
    {
        for(ConfiguredPower<ModifyTFCFoodConfiguration,ModifyTFCFoodPower> power : source)
        {
            return power.getConfiguration().ignoreRotten();
        }
        return false;
    }

    public static double apply(List<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> source, Level level, ItemStack stack,
                               double baseValue, Function<ModifyTFCFoodConfiguration, ListConfiguration<AttributeModifier>> access) {
        List<AttributeModifier> modifiers = source.stream()
                .filter(x -> x.getFactory().check(x, level, stack))
                .flatMap(x -> access.apply(x.getConfiguration()).getContent().stream()).collect(Collectors.toList());
        return AttributeUtil.applyModifiers(modifiers, baseValue);
    }

    public static int foodMod(List<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> source,LivingEntity living,double original)
    {
        List<ConfiguredModifier<?>> food = new LinkedList<>();

        for(ConfiguredPower<ModifyTFCFoodConfiguration,ModifyTFCFoodPower> power : source)
        {
            //if(power.getFactory().check(power,living.level(),))
            food.addAll(power.getConfiguration().foodModifiers().getContent());
        }
        int foods = (int) ModifierUtil.applyModifiers(living, food, original);

        return foods;



        //List<AttributeModifier> mod = source.stream().flatMap(x->access.apply(x.getConfiguration()).getContent().stream()).collect(Collectors.toList());
        /*
        for(ConfiguredPower<ModifyTFCFoodConfiguration, ?> power : source)
        {
            List<AttributeModifier> hhh = power
            //Collection hhh = power.getConfiguration().foodModifiers().getContent().stream().collect(Collectors.toList());
            System.out.println(hhh);

        }

         */
        }

    public static float mods(List<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> source,LivingEntity living,double original, int type)
    {
        List<ConfiguredModifier<?>> mod = new LinkedList<>();

        for(ConfiguredPower<ModifyTFCFoodConfiguration,ModifyTFCFoodPower> power : source)
        {
            switch (type){
                case 1:
                    mod.addAll(power.getConfiguration().saturationModifiers().getContent());
                    break;
                case 2:
                    mod.addAll(power.getConfiguration().waterModifiers().getContent());
                    break;
                case 3:
                    mod.addAll(power.getConfiguration().grainModifiers().getContent());
                    break;
                case 4:
                    mod.addAll(power.getConfiguration().fruitModifiers().getContent());
                    break;
                case 5:
                    mod.addAll(power.getConfiguration().vegetableModifiers().getContent());
                    break;
                case 6:
                    mod.addAll(power.getConfiguration().protienModifiers().getContent());
                    break;
                case 7:
                    mod.addAll(power.getConfiguration().dairyModifiers().getContent());
                    break;
            }



        }
        float mods = (float) ModifierUtil.applyModifiers(living, mod, original);

        return mods;
    }
    public static void modifyStack(Iterable<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> powers, Level level, Mutable<ItemStack> input)
    {

        for(ConfiguredPower<ModifyTFCFoodConfiguration, ?> power : powers)
        {

            if (power.getConfiguration().replaceStack() != null)
            {
                input.setValue(power.getConfiguration().replaceStack().copy());
            }
            ConfiguredItemAction.execute(power.getConfiguration().itemAction(), level, input);
        }
    }
    public static void execute(List<ConfiguredPower<ModifyTFCFoodConfiguration,ModifyTFCFoodPower>> source, Entity entity, Level level, ItemStack stack)
    {
        source.stream()
                .filter(x -> x.getFactory().check(x,level,stack))
                .forEach(x -> x.getFactory().execute(x,entity));
    }
    public ModifyTFCFoodPower() {
        super(ModifyTFCFoodConfiguration.CODEC);
    }

    public boolean check(ConfiguredPower<ModifyTFCFoodConfiguration, ?> config, Level level, ItemStack stack) {
        return ConfiguredItemCondition.check(config.getConfiguration().itemCondition(), level, stack);
    }
    public void execute(ConfiguredPower<ModifyTFCFoodConfiguration, ?> config, Entity player) {
        ConfiguredEntityAction.execute(config.getConfiguration().entityAction(), player);
    }
}


