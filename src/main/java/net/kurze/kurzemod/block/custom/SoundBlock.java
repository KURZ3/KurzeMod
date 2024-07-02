package net.kurze.kurzemod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.BossEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class SoundBlock extends Block {
    public SoundBlock(Properties pProperties) {
        super(pProperties);
    }
    //Ceguera x 3 seg // Sonido de spawn de wither // Titulo // Mensaje de chat // spawn mob

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        pPlayer.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60, 1)); //20 ticks es 1 seg

        pLevel.playSound(pPlayer, pPos, SoundEvents.GHAST_HURT, SoundSource.HOSTILE, 15f, 1f);

        pPlayer.sendSystemMessage(Component.literal("The end is near..."));
        double BlockX = pPos.getX();
        double BlockY = pPos.getY();
        double BlockZ = pPos.getZ();

        Creeper creeper = EntityType.CREEPER.create(pLevel);
        if (creeper != null) {
            ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(Component.literal("VIDA DE DIOS"), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
            Vec3 vec3 = pPos.getCenter();
            creeper.moveTo(vec3.x(), vec3.y() + 2, vec3.z(), Mth.wrapDegrees(pLevel.random.nextFloat() * 360.0F), 0.0F);
            creeper.setHealth(200f);
            creeper.setCustomName(Component.literal("DiositoGOD"));
            bossEvent.setVisible(true);
            bossEvent.setProgress(creeper.getHealth()/ creeper.getMaxHealth());
            pLevel.addFreshEntity(creeper);
        }


        return InteractionResult.SUCCESS;
    }

    /* Añadir efectos al mob
           creeper.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 1200, 100));
            creeper.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1200, 100));
    */


 /* Testeo para daño al pararte sobre el bloque
    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        super.stepOn(pLevel, pPos, pState, pEntity);
        pEntity.hurt(pLevel.damageSources().magic(), 15);
    }*/


}

