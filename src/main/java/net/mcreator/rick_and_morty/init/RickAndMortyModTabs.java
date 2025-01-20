
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.rick_and_morty.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class RickAndMortyModTabs {
	public static CreativeModeTab TAB_RICK_AND_MORTY_PORTAL;

	public static void load() {
		TAB_RICK_AND_MORTY_PORTAL = new CreativeModeTab("tabrick_and_morty_portal") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(RickAndMortyModItems.PORTALGUN.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
