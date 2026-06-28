package com.cipollomods.zombiedrugs;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import java.util.HashMap;
import java.util.Map;

/**
 * Gestiona los efectos continuos sobre zombies
 * Solo los que requieren comprobacion de ticks
 *
 * @author Toni
 */
@Mod.EventBusSubscriber(modid = ZombieDrugs.MOD_ID)
public class ZombieEvents {
    public static final Map<Zombie, Integer> CREEPER_ZOMBIES = new HashMap<>();

    @SubscribeEvent
    public static void onServerTick(TickEvent.ServerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        CREEPER_ZOMBIES.entrySet().removeIf(entry -> {
            Zombie zombie = entry.getKey();

            if (!zombie.isAlive()) return true;

            Player nearestPlayer = zombie.level().getNearestPlayer(
                    zombie, 3.0
            );

            if (nearestPlayer != null) {
                zombie.level().explode(
                        zombie,
                        null,
                        null,
                        zombie.getX(),
                        zombie.getY(),
                        zombie.getZ(),
                        4.0F,
                        false,
                        Level.ExplosionInteraction.BLOCK
                );
                zombie.kill();
                return true;
            } return false;
        });
    }

    public static final Map<Zombie, Integer> RAGE_ZOMBIES = new HashMap<>();

    @SubscribeEvent
    public static void onZombieAttack(LivingHurtEvent event) {
        if (!(event.getSource().getEntity() instanceof Zombie zombie)) return;
        if (!RAGE_ZOMBIES.containsKey(zombie)) return;

        event.getEntity().addEffect(new MobEffectInstance(MobEffects.POISON, Integer.MAX_VALUE, 0));
        }
}