
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rick_and_morty.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.rick_and_morty.item.QuantumTransportSolutionItem;
import net.mcreator.rick_and_morty.item.PortalgunItem;
import net.mcreator.rick_and_morty.item.MemorycardItem;
import net.mcreator.rick_and_morty.item.MathematicalcalculationsItem;
import net.mcreator.rick_and_morty.item.GreencrystallItem;
import net.mcreator.rick_and_morty.item.DischargedportalgunItem;
import net.mcreator.rick_and_morty.RickAndMortyMod;

public class RickAndMortyModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, RickAndMortyMod.MODID);
	public static final RegistryObject<Item> PORTALGUN = REGISTRY.register("portalgun", () -> new PortalgunItem());
	public static final RegistryObject<Item> QUANTUM_TRANSPORT_SOLUTION = REGISTRY.register("quantum_transport_solution", () -> new QuantumTransportSolutionItem());
	public static final RegistryObject<Item> GREENCRYSTALL = REGISTRY.register("greencrystall", () -> new GreencrystallItem());
	public static final RegistryObject<Item> MATHEMATICALCALCULATIONS = REGISTRY.register("mathematicalcalculations", () -> new MathematicalcalculationsItem());
	public static final RegistryObject<Item> MEMORYCARD = REGISTRY.register("memorycard", () -> new MemorycardItem());
	public static final RegistryObject<Item> GREENCRYSTAL = block(RickAndMortyModBlocks.GREENCRYSTAL, RickAndMortyModTabs.TAB_RICK_AND_MORTY_PORTAL);
	public static final RegistryObject<Item> DISCHARGEDPORTALGUN = REGISTRY.register("dischargedportalgun", () -> new DischargedportalgunItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
