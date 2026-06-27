package com.cipollomods.zombiedrugs.item.drug;

import com.cipollomods.zombiedrugs.item.DrugSyringe;
import net.minecraft.world.entity.monster.Zombie;

public class SyringeJump extends DrugSyringe {
    public SyringeJump(Properties properties) {
        super(properties);
    }

    @Override
    protected void applyEffect(Zombie zombie) {
        zombie.setDeltaMovement(zombie.getDeltaMovement().x, 2.5, zombie.getDeltaMovement().z);
    }
}
