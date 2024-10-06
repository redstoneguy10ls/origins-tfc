package com.redstoneguy10ls.tfcorigins.mixin;


import com.redstoneguy10ls.tfcorigins.access.TFCModifiableFoodEntity;
import com.redstoneguy10ls.tfcorigins.common.powers.ModifyTFCFoodPower;
import com.redstoneguy10ls.tfcorigins.common.powers.configuration.ModifyTFCFoodConfiguration;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredPower;
import net.dries007.tfc.common.capabilities.food.FoodData;
import net.dries007.tfc.common.capabilities.food.IFood;
import net.dries007.tfc.common.capabilities.food.TFCFoodData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.LinkedList;
import java.util.List;

@Mixin(TFCFoodData.class)
public abstract class TFCFoodDataMixin implements TFCModifiableFoodEntity {

    @Shadow @Final private Player sourcePlayer;

    // at = @At(value = "INVOKE", target = "Lnet.dries007.tfc.common.capabilities.food.TFCFoodData;eat(Lnet/minecraft/world/item/Item;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/LivingEntity;)V")
    @Inject(method = "eat(Lnet/minecraft/world/item/Item;Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/LivingEntity;)V",at = @At("HEAD"), remap = false)
    private void getPower(Item test,ItemStack stacks, LivingEntity en, CallbackInfo cir) {

        List<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> mfps = ModifyTFCFoodPower.getValidPowers(en, stacks);
        ((TFCModifiableFoodEntity) this).setCurrentModifyFoodPowers(mfps);
        ((TFCModifiableFoodEntity) this).setPlayer(en);
        //Function<ModifyTFCFoodConfiguration, ListConfiguration<AttributeModifier>> access = a-> ((ListConfiguration<AttributeModifier>) a);

        //System.out.println(mfps.stream().filter(x->x.getFactory().check(x,en.level(),stacks))
          //      .flatMap(x-> x.getConfiguration().foodModifiers().getContent().stream().collect(Collectors.toList())));

    }
    @Inject(method = "eat(Lnet/dries007/tfc/common/capabilities/food/IFood;)V",at = @At("HEAD"),remap = false)
    private void notRotten(IFood food, CallbackInfo ci){
        if(ModifyTFCFoodPower.ignore_rotten(tfc$currentModifyFoodPowers2))
        {
            food.setNonDecaying();
        }

    }

    //@ModifyVariable(method = "eat(Lnet/dries007/tfc/common/capabilities/food/FoodData;)V", at = @At("HEAD"),remap = false)
    @ModifyVariable(method = "eat(Lnet/dries007/tfc/common/capabilities/food/FoodData;)V", at = @At("HEAD"), remap=false)
    private net.dries007.tfc.common.capabilities.food.FoodData editFood(net.dries007.tfc.common.capabilities.food.FoodData value)
    {
        //TODO make this only run if condition is met
        int food = ModifyTFCFoodPower.foodMod(tfc$currentModifyFoodPowers2,getEnt(),value.hunger());
        float sat = ModifyTFCFoodPower.mods(tfc$currentModifyFoodPowers2,getEnt(),value.saturation(),1);
        float water = ModifyTFCFoodPower.mods(tfc$currentModifyFoodPowers2,getEnt(),value.water(),2);
        float grain = ModifyTFCFoodPower.mods(tfc$currentModifyFoodPowers2,getEnt(),value.grain(),3);
        float fruit = ModifyTFCFoodPower.mods(tfc$currentModifyFoodPowers2,getEnt(),value.fruit(),4);
        float vegetables = ModifyTFCFoodPower.mods(tfc$currentModifyFoodPowers2,getEnt(),value.vegetables(),5);
        float protein = ModifyTFCFoodPower.mods(tfc$currentModifyFoodPowers2,getEnt(),value.protein(),6);
        float dairy = ModifyTFCFoodPower.mods(tfc$currentModifyFoodPowers2,getEnt(),value.dairy(),7);
        float decay = value.decayModifier();
        FoodData bruh = new FoodData(food,sat,water,grain,fruit,vegetables,protein,dairy,decay);

        return bruh;

    }








/*
    @Inject(method = "eat", at = @At("TAIL"))
    private void removeCurrentModifyFoodPowers(Level world, ItemStack stack, CallbackInfoReturnable<ItemStack> cir) {
        this.setCurrentModifyFoodPowers(new LinkedList<>());
    }

 */

    @Unique
    private LivingEntity ent;

    @Unique
    private List<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> tfc$currentModifyFoodPowers2 = new LinkedList<>();

    @Override
    public List<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> getCurrentModifyFoodPowers() {
        return this.tfc$currentModifyFoodPowers2;
    }
    @Override
    public void setPlayer(LivingEntity ent) {
        this.ent = ent;
    }

    public LivingEntity getEnt() {
        return ent;
    }

    @Override
    public void setCurrentModifyFoodPowers(List<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> powers) {
        this.tfc$currentModifyFoodPowers2 = powers;
    }
}

