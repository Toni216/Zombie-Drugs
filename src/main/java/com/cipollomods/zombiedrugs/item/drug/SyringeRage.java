package com.cipollomods.zombiedrugs.item.drug;

import com.cipollomods.zombiedrugs.ZombieEvents;
import com.cipollomods.zombiedrugs.item.DrugSyringe;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.Zombie;

/**
 * El zombie ataca más rapido y aplica veneno
 *
 * @author Toni
 */
public class SyringeRage extends DrugSyringe {
    public SyringeRage(Properties properties) {
        super(properties);
    }

    @Override
    protected void applyEffect(Zombie zombie) {
        zombie.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 2));
        zombie.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 2));
        ZombieEvents.RAGE_ZOMBIES.put(zombie, 200);
    }

}
