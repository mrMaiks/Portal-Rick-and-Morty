
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

import net.mcreator.rick_and_morty.procedures.QuantumTransportSolutionPriShchielchkiePKMProcedure;
import net.mcreator.rick_and_morty.init.RickAndMortyModTabs;

import java.util.List;

public class QuantumTransportSolutionItem extends Item {
	public QuantumTransportSolutionItem() {
		super(new Item.Properties().tab(RickAndMortyModTabs.TAB_RICK_AND_MORTY_PORTAL).stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("A mixture of green crystals"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		QuantumTransportSolutionPriShchielchkiePKMProcedure.execute(world, entity);
		return ar;
	}
}
