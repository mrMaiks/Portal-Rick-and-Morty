
package net.mcreator.rick_and_morty.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import net.mcreator.rick_and_morty.init.RickAndMortyModTabs;

import java.util.List;

public class MathematicalcalculationsItem extends Item {
	public MathematicalcalculationsItem() {
		super(new Item.Properties().tab(RickAndMortyModTabs.TAB_RICK_AND_MORTY_PORTAL).stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Ordinary chalk and mathematics! (The main thing is not to make a mistake)"));
	}
}
