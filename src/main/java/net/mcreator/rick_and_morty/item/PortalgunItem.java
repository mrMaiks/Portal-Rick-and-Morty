
package net.mcreator.rick_and_morty.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.rick_and_morty.procedures.Spawn_portal_with_gunProcedure;
import net.mcreator.rick_and_morty.init.RickAndMortyModTabs;

import java.util.List;

public class PortalgunItem extends Item {
	public PortalgunItem() {
		super(new Item.Properties().tab(RickAndMortyModTabs.TAB_RICK_AND_MORTY_PORTAL).durability(10).rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("It was made by Rick Sanchez after the creation of a conventional"));
		list.add(Component.literal("portal cannon. Thanks to her"));
		list.add(Component.literal("her owner could move to other dimensions as well as in space"));
		list.add(Component.literal("for an unlimited distance. The technology is unique"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		Spawn_portal_with_gunProcedure.execute(world, x, y, z, entity);
		return ar;
	}
}
