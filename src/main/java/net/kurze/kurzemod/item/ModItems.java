package net.kurze.kurzemod.item;

import net.kurze.kurzemod.KurzeMod;
import net.kurze.kurzemod.item.custom.FuelItem;
import net.kurze.kurzemod.item.custom.MetalDetectorItem;
import net.kurze.kurzemod.item.custom.ModToolTiers;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
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
    public static final RegistryObject<Item> SCULK_UNREFINED_INGOT = ITEMS.register("sculk_unrefined_ingot",
            ()-> new Item(new Item.Properties()));
    //-----------------------------CUSTOM ITEMS----------------
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));
    //-----------------------------CUSTOM FUELS----------------
    public static final RegistryObject<Item> SCULK_RESIDUE = ITEMS.register("sculk_residue",
            ()-> new FuelItem(new Item.Properties(), 2400));
    //-----------------------------CUSTOM TOOLS----------------
    public static final RegistryObject<Item> SCULKORD = ITEMS.register("sculkord",
            ()-> new SwordItem(ModToolTiers.SCULK, 24, 3, new Item.Properties()));

    public static final RegistryObject<Item> QUADSWORD = ITEMS.register("quadsword",
            ()-> new SwordItem(ModToolTiers.SCULK, 48, 3, new Item.Properties()));
    //-----------------------------COMIDAS---------------------
    public static final RegistryObject<Item> SUSHI = ITEMS.register("sushi",
            () -> new Item(new Item.Properties().food(ModFoods.SUSHI)));
    //-----------------------------ORES------------------
    public static final RegistryObject<Item> SCULK_CLUSTER = ITEMS.register("sculk_cluster",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MONSOON_SHARD = ITEMS.register("monsoon_shard",
            ()-> new Item(new Item.Properties()));
    //-----------------------------EventBus----------------
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
