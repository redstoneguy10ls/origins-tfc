package com.redstoneguy10ls.tfcorigins.mixin;

import com.redstoneguy10ls.tfcorigins.access.TFCModifiableFoodEntity;
import com.redstoneguy10ls.tfcorigins.common.powers.ModifyTFCFoodPower;
import com.redstoneguy10ls.tfcorigins.common.powers.configuration.ModifyTFCFoodConfiguration;
import io.github.apace100.apoli.access.ModifiableFoodEntity;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredPower;
import io.github.edwinmindcraft.apoli.common.util.LivingDamageCache;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.mutable.MutableObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.LinkedList;
import java.util.List;
/*
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements TFCModifiableFoodEntity, LivingDamageCache {
    public LivingEntityMixin(EntityType<?> type, Level world) {
        super(type, world);
    }

    @ModifyVariable(method = "eat", at = @At("HEAD"), argsOnly = true)
    private ItemStack modifyEatenItemStack(ItemStack original) {
        if ((Object) this instanceof Player) {
            return original;
        }
        List<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> mfps = ModifyTFCFoodPower.getValidPowers(this, original);
        MutableObject<ItemStack> stack = new MutableObject<>(original.copy());
        ModifyTFCFoodPower.modifyStack(mfps, this.level(), stack);
        ((TFCModifiableFoodEntity) this).setCurrentModifyFoodPowers(mfps);
        ((TFCModifiableFoodEntity) this).setOriginalFoodStack(original);
        return stack.getValue();
    }

    @ModifyVariable(method = "eat", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;addEatEffect(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/entity/LivingEntity;)V", shift = At.Shift.AFTER), argsOnly = true)
    private ItemStack unmodifyEatenItemStack(ItemStack modified) {
        TFCModifiableFoodEntity foodEntity = this;
        ItemStack original = foodEntity.getOriginalFoodStack();
        if (original != null) {
            foodEntity.setOriginalFoodStack(null);
            return original;
        }
        return modified;
    }

    @Inject(method = "eat", at = @At("TAIL"))
    private void removeCurrentModifyFoodPowers(Level world, ItemStack stack, CallbackInfoReturnable<ItemStack> cir) {
        this.setCurrentModifyFoodPowers(new LinkedList<>());
    }

    @Unique
    private List<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> tfc$currentModifyFoodPowers = new LinkedList<>();

    @Override
    public List<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> getCurrentModifyFoodPowers() {
        return this.tfc$currentModifyFoodPowers;
    }

    @Override
    public void setCurrentModifyFoodPowers(List<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> powers) {
        this.tfc$currentModifyFoodPowers = powers;
    }
}

 */
