package net.kurze.kurzemod.item;

import net.kurze.kurzemod.KurzeMod;
import net.kurze.kurzemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    //-----------------------------REGISTRO----------------
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
                DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KurzeMod.MOD_ID);
    //-----------------------------Tab----------------
    public static final RegistryObject<CreativeModeTab> KURZE_TAB = CREATIVE_MODE_TABS.register("kurze_tab",
            ()-> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.SCULK_INGOT.get()))
                    .title(Component.translatable("creativetab.kurze_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        //Aqui se añaden los items en nuestra custom tab
                        //Items
                        pOutput.accept(ModItems.SCULK_INGOT.get());
                        pOutput.accept(ModItems.SCULK_UNREFINED_INGOT.get());
                        //Custom Items
                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        //Custom Fuels
                        pOutput.accept(ModItems.SCULK_RESIDUE.get());
                        //Custom Foods
                        pOutput.accept(ModItems.SUSHI.get());
                        //Ores (item)
                        pOutput.accept(ModItems.SCULK_CLUSTER.get());
                        pOutput.accept(ModItems.MONSOON_SHARD.get());
                        //Ores (vein)
                        pOutput.accept(ModBlocks.SCULK_DEEPSLATE_ORE.get());
                        pOutput.accept(ModBlocks.SCULK_ORE.get());
                        pOutput.accept(ModBlocks.MONSOON_ORE.get());

                        //Blocks
                        pOutput.accept(ModBlocks.SCULK_BLOCK.get());
                        pOutput.accept(ModBlocks.SCULK_BRICKS.get());
                        pOutput.accept(ModBlocks.SCULK_DECO.get());

                        //Custom Blocks
                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());

                    }).build());

    //-----------------------------EventBus----------------
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
