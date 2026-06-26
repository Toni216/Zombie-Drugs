package com.cipollomods.zombiedrugs;

import com.cipollomods.zombiedrugs.init.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/***
 * Registro de las recetas de drogas
 * Son en el soporte para pociones
 */
public class DrugsRecipes {

    public static void register(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BrewingRecipeRegistry.addRecipe(new IBrewingRecipe() {
                @Override
                public boolean isInput(ItemStack stack) {
                    return stack.is(ModItems.BLOOD_SYRINGE.get());
                }

                @Override
                public boolean isIngredient(ItemStack stack) {
                    return stack.is(ModItems.ZOMBIE_BRAIN.get())
                            || stack.is(ModItems.ZOMBIE_EYE.get())
                            || stack.is(ModItems.ZOMBIE_HEART.get())
                            || stack.is(ModItems.ZOMBIE_TOOTH.get())
                            || stack.is(Items.GOLDEN_CARROT)
                            || stack.is(Items.GUNPOWDER)
                            || stack.is(Items.RABBIT_FOOT)
                            || stack.is(Items.SLIME_BALL);
                }

                @Override
                public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
                    if (!input.is(ModItems.BLOOD_SYRINGE.get()))
                        return ItemStack.EMPTY;
                    if (ingredient.is(ModItems.ZOMBIE_BRAIN.get()))
                        return new ItemStack(ModItems.SYRINGE_CLONE.get());
                    if (ingredient.is(ModItems.ZOMBIE_EYE.get()))
                        return new ItemStack(ModItems.SYRINGE_SPIN.get());
                    if (ingredient.is(ModItems.ZOMBIE_HEART.get()))
                        return new ItemStack(ModItems.SYRINGE_BOOST.get());
                    if (ingredient.is(ModItems.ZOMBIE_TOOTH.get()))
                        return new ItemStack(ModItems.SYRINGE_RAGE.get());
                    if (ingredient.is(Items.GOLDEN_CARROT))
                        return new ItemStack(ModItems.SYRINGE_VILLAGER.get());
                    if (ingredient.is(Items.GUNPOWDER))
                        return new ItemStack(ModItems.SYRINGE_CREEPERZ.get());
                    if (ingredient.is(Items.RABBIT_FOOT))
                        return new ItemStack(ModItems.SYRINGE_JUMP.get());
                    if (ingredient.is(Items.SLIME_BALL))
                        return new ItemStack(ModItems.SYRINGE_FLIP.get());

                    return ItemStack.EMPTY;
                }
            });
        });
    }
}