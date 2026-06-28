package com.cipollomods.zombiedrugs.item.drug;

import com.cipollomods.zombiedrugs.ZombieEvents;
import com.cipollomods.zombiedrugs.item.DrugSyringe;
import net.minecraft.world.entity.monster.Zombie;

/***
 * El zombie explota cuando está lo suficiente cerca
 *
 * @author Toni
 */
public class SyringeCreeperz extends DrugSyringe {
    public SyringeCreeperz(Properties properties) {
        super(properties);
    }

    @Override
    protected void applyEffect(Zombie zombie) {
        ZombieEvents.CREEPER_ZOMBIES.put(zombie, 0);
    }
}
