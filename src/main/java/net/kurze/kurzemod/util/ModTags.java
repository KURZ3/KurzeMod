package net.kurze.kurzemod.util;

import net.kurze.kurzemod.KurzeMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static net.minecraft.tags.TagEntry.tag;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_VALUES = tag("metal_detector_valuables");
        public static final TagKey<Block> NEEDS_SCULK_TOOL = tag("needs_sculk_tool");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(KurzeMod.MOD_ID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(KurzeMod.MOD_ID, name));
        }
    }
}
