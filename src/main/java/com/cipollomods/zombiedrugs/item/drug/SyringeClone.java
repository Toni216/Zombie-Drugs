package com.cipollomods.zombiedrugs.item.drug;

import com.cipollomods.zombiedrugs.item.DrugSyringe;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;

public class SyringeClone extends DrugSyringe {
    public SyringeClone(Properties properties) {
        super(properties);
    }

    @Override
    protected void applyEffect(Zombie zombie) {
        Zombie clone = new Zombie(EntityType.ZOMBIE, zombie.level());
        clone.moveTo(
                zombie.getX(),
                zombie.getY(),
                zombie.getZ(),
                zombie.getYRot(),
                zombie.getXRot()
        );
        zombie.level().addFreshEntity(clone);
    }
}
