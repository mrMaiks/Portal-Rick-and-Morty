
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.rick_and_morty.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RickAndMortyModTrades {
	@SubscribeEvent
	public static void registerWanderingTrades(WandererTradesEvent event) {
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Blocks.NETHERITE_BLOCK, 2),

				new ItemStack(RickAndMortyModItems.MATHEMATICALCALCULATIONS.get()), 10, 5, 0.05f));
	}
}
