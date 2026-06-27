package com.cipollomods.zombiedrugs.item;

import com.cipollomods.zombiedrugs.init.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Properties;

/***
 * Clase padre para el resto de jeringuillas
 * click derecho sobre zombie > aplica efecto y vacía la jeringuilla
 *
 * @author Toni
 */
public abstract class DrugSyringe extends Item {
    public DrugSyringe(Properties properties) {
        super(properties);
    }

    /***
     * Define el efecto que le cae al zombie
     *
     * @param zombie el zombie sobre el que se aplica el efecto
     */
    protected abstract void applyEffect(Zombie zombie);

    /***
     * Se ejecuta al hacer click derecho sobre una entidad
     * Si es un zombie, aplica el efecto y devuelve la jeringuilla vacía
     * Si no, no pasa nada saludos
     */
    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        if (target instanceof Zombie zombie && !player.level().isClientSide()) {
            applyEffect(zombie);
            stack.shrink(1);
            ItemStack emptySyringe = new ItemStack(ModItems.EMPTY_SYRINGE.get());
            if (!player.getInventory().add(emptySyringe)) {
                player.drop(emptySyringe, false);
            } return InteractionResult.SUCCESS;
        } return InteractionResult.PASS;
    }
}
