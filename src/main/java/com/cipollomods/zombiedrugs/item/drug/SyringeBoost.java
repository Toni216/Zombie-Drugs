package com.cipollomods.zombiedrugs.item.drug;

import com.cipollomods.zombiedrugs.item.DrugSyringe;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.Zombie;

import java.util.Properties;

/**
 * Aplica un boost de fuerza y velocidad al zombie.
 */
public class SyringeBoost extends DrugSyringe {
    public SyringeBoost(Properties properties) {
        super(properties);
    }

    @Override
    protected void applyEffect(Zombie zombie) {
        zombie.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1));
        zombie.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 1));
    }
}
