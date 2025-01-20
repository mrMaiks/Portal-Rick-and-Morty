
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rick_and_morty.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.rick_and_morty.block.GreencrystalBlock;
import net.mcreator.rick_and_morty.RickAndMortyMod;

public class RickAndMortyModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, RickAndMortyMod.MODID);
	public static final RegistryObject<Block> GREENCRYSTAL = REGISTRY.register("greencrystal", () -> new GreencrystalBlock());
}
