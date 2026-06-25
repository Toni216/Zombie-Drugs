package com.cipollomods.zombiedrugs.item;

import com.cipollomods.zombiedrugs.init.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SyringeItem extends Item {
    public SyringeItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player,
                                                  net.minecraft.world.entity.LivingEntity target,
                                                  InteractionHand hand) {
        // la jeringuilla tiene que hacer daño al zombie y no liarla en el inventario
        if (target instanceof Zombie && !player.level().isClientSide()) {

            target.hurt(player.level().damageSources().playerAttack(player), 1.0F);
            stack.shrink(1);
            ItemStack bloodStack = new ItemStack(ModItems.BLOOD_SYRINGE.get());

            if (!player.getInventory().add(bloodStack)) {
                player.drop(bloodStack, false);
            } return InteractionResult.SUCCESS;
        } return InteractionResult.PASS;
    }
}
