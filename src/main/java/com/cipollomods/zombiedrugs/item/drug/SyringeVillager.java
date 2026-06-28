package com.cipollomods.zombiedrugs.item.drug;

import com.cipollomods.zombiedrugs.item.DrugSyringe;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;

public class SyringeVillager extends DrugSyringe {
    public SyringeVillager(Properties properties) {
        super(properties);
    }

    @Override
    protected void applyEffect(Zombie zombie) {
        if (zombie.level() instanceof ServerLevel serverLevel) {
            zombie.convertTo(
                    EntityType.VILLAGER, true
            );
        }
    }
}
