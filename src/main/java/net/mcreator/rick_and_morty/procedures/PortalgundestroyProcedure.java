package net.mcreator.rick_and_morty.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.rick_and_morty.network.RickAndMortyModVariables;
import net.mcreator.rick_and_morty.init.RickAndMortyModItems;
import net.mcreator.rick_and_morty.RickAndMortyMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PortalgundestroyProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(RickAndMortyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RickAndMortyModVariables.PlayerVariables())).quantity == 0) {
			{
				double _setval = (entity.getCapability(RickAndMortyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RickAndMortyModVariables.PlayerVariables())).quantity - 1;
				entity.getCapability(RickAndMortyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.quantity = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(RickAndMortyModItems.PORTALGUN.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			RickAndMortyMod.queueServerWork(20, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(RickAndMortyModItems.DISCHARGEDPORTALGUN.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
		}
	}
}
