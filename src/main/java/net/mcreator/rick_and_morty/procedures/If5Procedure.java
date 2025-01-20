package net.mcreator.rick_and_morty.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.rick_and_morty.network.RickAndMortyModVariables;
import net.mcreator.rick_and_morty.init.RickAndMortyModItems;

public class If5Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RickAndMortyModItems.PORTALGUN.get()
				&& (entity.getCapability(RickAndMortyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RickAndMortyModVariables.PlayerVariables())).quantity == 5) {
			return true;
		}
		return false;
	}
}
