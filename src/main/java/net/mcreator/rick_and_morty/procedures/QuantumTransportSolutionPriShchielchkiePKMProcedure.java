package net.mcreator.rick_and_morty.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;

import net.mcreator.rick_and_morty.network.RickAndMortyModVariables;
import net.mcreator.rick_and_morty.init.RickAndMortyModItems;
import net.mcreator.rick_and_morty.RickAndMortyMod;

public class QuantumTransportSolutionPriShchielchkiePKMProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == RickAndMortyModItems.DISCHARGEDPORTALGUN.get()) {
			{
				double _setval = (entity.getCapability(RickAndMortyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RickAndMortyModVariables.PlayerVariables())).quantity + 11;
				entity.getCapability(RickAndMortyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.quantity = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = new ItemStack(RickAndMortyModItems.QUANTUM_TRANSPORT_SOLUTION.get());
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			RickAndMortyMod.queueServerWork(20, () -> {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(RickAndMortyModItems.DISCHARGEDPORTALGUN.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(RickAndMortyModItems.PORTALGUN.get());
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			});
		}
	}
}
