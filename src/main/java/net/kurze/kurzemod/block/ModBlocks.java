package net.kurze.kurzemod.block;

import net.kurze.kurzemod.KurzeMod;
import net.kurze.kurzemod.block.custom.SoundBlock;
import net.kurze.kurzemod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    //-----------------------------REGISTRO----------------
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, KurzeMod.MOD_ID);

    //-----------------------------BLOQUES CUSTOM----------------
    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            ()-> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    //-----------------------------BLOQUES----------------
    public static final RegistryObject<Block> SCULK_BLOCK = registerBlock("sculk_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.BONE_BLOCK)));

    public static final RegistryObject<Block> SCULK_BRICKS = registerBlock("sculk_bricks",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS).sound(SoundType.NETHER_BRICKS)));
    //-----------------------------ORES----------------
    public static final RegistryObject<Block> SCULK_DEEPSLATE_ORE = registerBlock("sculk_deepslate_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.ANCIENT_DEBRIS).sound(SoundType.AMETHYST_CLUSTER)
                    .requiresCorrectToolForDrops(), UniformInt.of(5, 20)));

    public static final RegistryObject<Block> SCULK_ORE = registerBlock("sculk_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).sound(SoundType.AMETHYST_CLUSTER)
                    .requiresCorrectToolForDrops(), UniformInt.of(5, 10)));

    public static final RegistryObject<Block> MONSOON_ORE = registerBlock("monsoon_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).sound(SoundType.AMETHYST_CLUSTER)
                    .requiresCorrectToolForDrops(), UniformInt.of(5, 10)));
    

    //-----------------------------REGISTRO DE BLOQUES Y ITEMS----------------
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    //-----------------------------EventBus----------------
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

}
