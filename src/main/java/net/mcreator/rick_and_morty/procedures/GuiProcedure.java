package net.mcreator.rick_and_morty.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.rick_and_morty.init.RickAndMortyModItems;

public class GuiProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == RickAndMortyModItems.PORTALGUN.get()) {
			return true;
		}
		return false;
	}
}
