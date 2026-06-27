package com.cipollomods.zombiedrugs.item;

import com.cipollomods.zombiedrugs.init.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 *
 * Item de jeringuilla vacía
 * Al hacer click derecho sobre un zombie, la reemplaza
 * por una de sangre e inflinge 1 de daño al zombie.
 *
 * @author Toni
 */
public class SyringeItem extends Item {
    public SyringeItem(Properties properties) {
        super(properties);
    }
    /**
     *
     * Se ejecuta al hacer click derecho sobre un una entidad
     * Si la entidad es un zombie le saca la sangre cual vampiro >:)
     *
     * @return SUCCESS si se extrajo sangre, PASS con lo contrario
     *
     */
    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player,
                                                  net.minecraft.world.entity.LivingEntity target,
                                                  InteractionHand hand) {
        // Inflinge daño al zombie
        if (target instanceof Zombie && !player.level().isClientSide()) {
            target.hurt(player.level().damageSources().playerAttack(player), 1.0F);
            // Elimina 1 jeringuilla vacía
            stack.shrink(1);
            // Devuelve la jeringuilla con sangre
            ItemStack bloodStack = new ItemStack(ModItems.BLOOD_SYRINGE.get());
            // Si el jugador tiene el inventario lleno, la jeringuilla con sangre cae al suelo
            if (!player.getInventory().add(bloodStack)) {
                player.drop(bloodStack, false);
            } return InteractionResult.SUCCESS;
        } return InteractionResult.PASS;
    }
}
