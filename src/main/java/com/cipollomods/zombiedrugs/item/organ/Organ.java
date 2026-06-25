package com.cipollomods.zombiedrugs.item.organ;

import net.minecraft.world.item.Item;

public class Organ extends Item {
    private final float dropChance;

    public Organ(float dropChance, Properties properties) {
        super(properties);
        this.dropChance = dropChance;
    }

    public float getDropChance() {
        return dropChance;
    }
}
