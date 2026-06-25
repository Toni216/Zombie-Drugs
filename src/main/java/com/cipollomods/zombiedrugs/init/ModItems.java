package com.cipollomods.zombiedrugs.init;

import com.cipollomods.zombiedrugs.ZombieDrugs;
import com.cipollomods.zombiedrugs.item.SyringeItem;
import com.cipollomods.zombiedrugs.item.organ.ZombieBrain;
import com.cipollomods.zombiedrugs.item.organ.ZombieEye;
import com.cipollomods.zombiedrugs.item.organ.ZombieHeart;
import com.cipollomods.zombiedrugs.item.organ.ZombieTooth;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 *
 * Todos los items del mod
 * DeferredRegister para registrarlos y cargarlos bien
 *
 */
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ZombieDrugs.MOD_ID);
    // jeringuillas vacías y con sangre
    public static final RegistryObject<Item> EMPTY_SYRINGE =
            ITEMS.register("empty_syringe", () -> new SyringeItem(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> BLOOD_SYRINGE =
            ITEMS.register("blood_syringe", () -> new Item(new Item.Properties().stacksTo(16)));
    // jeringuillas con efectos >:)
    public static final RegistryObject<Item> SYRINGE_CLONE =
            ITEMS.register("syringe_clone", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> SYRINGE_VILLAGER =
            ITEMS.register("syringe_villager", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> SYRINGE_CREEPERZ =
            ITEMS.register("syringe_creeperz", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> SYRINGE_JUMP =
            ITEMS.register("syringe_jump", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> SYRINGE_SPIN =
            ITEMS.register("syringe_spin", () -> new Item(new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> SYRINGE_FLIP =
            ITEMS.register("syringe_flip", () -> new Item(new Item.Properties().stacksTo(16)));
    // órganos de zombie
    public static final RegistryObject<Item> ZOMBIE_BRAIN =
            ITEMS.register("zombie_brain", () -> new ZombieBrain(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> ZOMBIE_EYE =
            ITEMS.register("zombie_eye", () -> new ZombieEye(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> ZOMBIE_HEART =
            ITEMS.register("zombie_heart", () -> new ZombieHeart(new Item.Properties().stacksTo(64)));
    public static final RegistryObject<Item> ZOMBIE_TOOTH =
            ITEMS.register("zombie_tooth", () -> new ZombieTooth(new Item.Properties().stacksTo(64)));
}
