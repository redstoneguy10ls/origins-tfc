package com.redstoneguy10ls.tfcorigins.common.registry;

import io.github.edwinmindcraft.apoli.api.power.factory.EntityAction;
import io.github.edwinmindcraft.apoli.api.power.factory.EntityCondition;
import io.github.edwinmindcraft.apoli.api.power.factory.ItemCondition;
import io.github.edwinmindcraft.apoli.api.power.factory.PowerFactory;
import io.github.edwinmindcraft.apoli.api.registry.ApoliRegistries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;

import static com.redstoneguy10ls.tfcorigins.TFCOrigins.MOD_ID;

public class TFCORegister {

    public static final DeferredRegister<PowerFactory<?>> POWER_FACTORIES = DeferredRegister.create(ApoliRegistries.POWER_FACTORY_KEY, MOD_ID);
    public static final DeferredRegister<EntityAction<?>> ENTITY_ACTIONS = DeferredRegister.create(ApoliRegistries.ENTITY_ACTION_KEY, MOD_ID);
    public static final DeferredRegister<ItemCondition<?>> ITEM_CONDITIONS = DeferredRegister.create(ApoliRegistries.ITEM_CONDITION_KEY, MOD_ID);
    public static final DeferredRegister<EntityCondition<?>> ENTITY_CONDITIONS = DeferredRegister.create(ApoliRegistries.ENTITY_CONDITION_KEY, MOD_ID);


    public static void register(){
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        POWER_FACTORIES.register(bus);
        ENTITY_ACTIONS.register(bus);
        ENTITY_CONDITIONS.register(bus);
        ITEM_CONDITIONS.register(bus);
    }
}
