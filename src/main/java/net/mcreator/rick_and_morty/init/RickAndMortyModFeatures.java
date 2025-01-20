
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rick_and_morty.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.rick_and_morty.world.features.ores.GreencrystalFeature;
import net.mcreator.rick_and_morty.RickAndMortyMod;

@Mod.EventBusSubscriber
public class RickAndMortyModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, RickAndMortyMod.MODID);
	public static final RegistryObject<Feature<?>> GREENCRYSTAL = REGISTRY.register("greencrystal", GreencrystalFeature::feature);
}
