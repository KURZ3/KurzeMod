package net.kurze.kurzemod.item;

import net.kurze.kurzemod.KurzeMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    //-----------------------------REGISTRO----------------
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, KurzeMod.MOD_ID);
    //-----------------------------ITEMS----------------
    public static final RegistryObject<Item> SCULK_INGOT = ITEMS.register("sculk_ingot",
            ()-> new Item(new Item.Properties()));
    //--
    public static final RegistryObject<Item> SCULK_UNREFINED_INGOT = ITEMS.register("sculk_unrefined_ingot",
            ()-> new Item(new Item.Properties()));
    //-----------------------------ORES----------------
    public static final RegistryObject<Item> SCULK_CLUSTER = ITEMS.register("sculk_cluster",
            ()-> new Item(new Item.Properties()));
    //-----------------------------EventBus----------------
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
