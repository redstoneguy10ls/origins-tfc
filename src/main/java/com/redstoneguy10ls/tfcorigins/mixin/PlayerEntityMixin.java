package com.redstoneguy10ls.tfcorigins.mixin;

import com.redstoneguy10ls.tfcorigins.access.TFCModifiableFoodEntity;
import com.redstoneguy10ls.tfcorigins.common.powers.ModifyTFCFoodPower;
import com.redstoneguy10ls.tfcorigins.common.powers.configuration.ModifyTFCFoodConfiguration;
import io.github.apace100.apoli.access.ModifiableFoodEntity;
import io.github.edwinmindcraft.apoli.api.power.configuration.ConfiguredPower;
import io.github.edwinmindcraft.apoli.api.power.factory.PowerFactory;
import net.minecraft.commands.CommandSource;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.mutable.MutableObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;
/*
@Mixin(Player.class)
public abstract class PlayerEntityMixin extends LivingEntity implements Nameable, CommandSource {
    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, Level world) {
        super(entityType, world);
    }

    @ModifyVariable(method = "eat", at = @At("HEAD"), argsOnly = true)
    private ItemStack modifyEatenItemStack(ItemStack original) {
        List<ConfiguredPower<ModifyTFCFoodConfiguration, ModifyTFCFoodPower>> mfps = ModifyTFCFoodPower.getValidPowers(this, original);
        MutableObject<ItemStack> stack = new MutableObject<>(original.copy());
        ModifyTFCFoodPower.modifyStack(mfps, this.level(), stack);
        ModifyTFCFoodPower.tests(mfps,this);
        ((TFCModifiableFoodEntity) this).setCurrentModifyFoodPowers(mfps);
        ((TFCModifiableFoodEntity) this).setOriginalFoodStack(original);
        return stack.getValue();
    }

}
*/