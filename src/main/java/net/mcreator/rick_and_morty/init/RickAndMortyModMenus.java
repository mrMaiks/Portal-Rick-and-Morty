
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rick_and_morty.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.rick_and_morty.world.inventory.PortalguiMenu;
import net.mcreator.rick_and_morty.RickAndMortyMod;

public class RickAndMortyModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, RickAndMortyMod.MODID);
	public static final RegistryObject<MenuType<PortalguiMenu>> PORTALGUI = REGISTRY.register("portalgui", () -> IForgeMenuType.create(PortalguiMenu::new));
}
