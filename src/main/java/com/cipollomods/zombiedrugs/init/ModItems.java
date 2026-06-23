package com.cipollomods.zombiedrugs.init;

import com.cipollomods.zombiedrugs.ZombieDrugs;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ZombieDrugs.MOD_ID);
    // jeringuillas vacías y con sangre
    public static final RegistryObject<Item> EMPTY_SYRINGE =
            ITEMS.register("empty_syringe", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLOOD_SYRINGE =
            ITEMS.register("blood_syringe", () -> new Item(new Item.Properties()));
}