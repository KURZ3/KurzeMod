package net.kurze.kurzemod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    //Comidas Custom (1 muslo son 2 de nutrition)
    public static final FoodProperties SUSHI = new FoodProperties.Builder().nutrition(4).saturationMod( 6)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 100), 1.0f)
            .fast().build();

    //Final
}
