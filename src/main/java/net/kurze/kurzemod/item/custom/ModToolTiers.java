package net.kurze.kurzemod.item.custom;

import net.kurze.kurzemod.KurzeMod;
import net.kurze.kurzemod.item.ModItems;
import net.kurze.kurzemod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier SCULK = TierSortingRegistry.registerTier(
            new ForgeTier(5, 2500, 12f, 5f, 25,
                    ModTags.Blocks.NEEDS_SCULK_TOOL, ()-> Ingredient.of(ModItems.SCULK_INGOT.get())),
            new ResourceLocation(KurzeMod.MOD_ID, "sculk"), List.of(Tiers.NETHERITE), List.of());
}
