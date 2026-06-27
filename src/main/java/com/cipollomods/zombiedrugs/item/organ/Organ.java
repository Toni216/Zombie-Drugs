package com.cipollomods.zombiedrugs.item.organ;

import net.minecraft.world.item.Item;

/**
 *
 * Clase base para todos los órganos del zombie
 * Cada subclase define su propio porcentaje de drop
 *
 * @author Toni
 */
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
