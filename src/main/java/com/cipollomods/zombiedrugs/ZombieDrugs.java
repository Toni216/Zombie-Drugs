package com.cipollomods.zombiedrugs;

import com.cipollomods.zombiedrugs.init.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ZombieDrugs.MOD_ID)
public class ZombieDrugs {
    public static final String MOD_ID = "zombiedrugs";

    public ZombieDrugs() {
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}