package com.cipollomods.zombiedrugs.init;

import com.cipollomods.zombiedrugs.ZombieDrugs;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ZombieDrugs.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ZOMBIEDRUGS_TAB =
            TABS.register("zombiedrugs_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.zombiedrugs"))
                    .icon(() -> ModItems.EMPTY_SYRINGE.get().getDefaultInstance())
                    .displayItems((params, output) -> {
                        output.accept(ModItems.EMPTY_SYRINGE.get());
                        output.accept(ModItems.BLOOD_SYRINGE.get());
                    })
                    .build());
}
