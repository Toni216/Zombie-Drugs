package com.cipollomods.zombiedrugs;

import com.cipollomods.zombiedrugs.init.ModItems;
import com.cipollomods.zombiedrugs.item.organ.Organ;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = ZombieDrugs.MOD_ID)
public class ZombieDrop {

    @SubscribeEvent
    public static void onZombieDeath(LivingDropsEvent event) {
        if (!(event.getEntity() instanceof Zombie)) return;

        List.of(
                ModItems.ZOMBIE_EYE.get(),
                ModItems.ZOMBIE_BRAIN.get(),
                ModItems.ZOMBIE_HEART.get(),
                ModItems.ZOMBIE_TOOTH.get()
        ).forEach(item -> {
            if (item instanceof Organ organ) {
                if (event.getEntity().level().random.nextFloat() < organ.getDropChance()) {
                    if (event.getDrops().add(new net.minecraft.world.entity.item.ItemEntity(
                            event.getEntity().level(),
                            event.getEntity().getX(),
                            event.getEntity().getY(),
                            event.getEntity().getZ(),
                            new ItemStack(organ)
                    )));
                }
            }
        });
    }

}
