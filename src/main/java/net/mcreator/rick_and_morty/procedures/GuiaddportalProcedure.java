package net.mcreator.rick_and_morty.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.rick_and_morty.network.RickAndMortyModVariables;

import java.util.HashMap;

public class GuiaddportalProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		{
			String _setval = guistate.containsKey("text:dimension") ? ((EditBox) guistate.get("text:dimension")).getValue() : "";
			entity.getCapability(RickAndMortyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.portal_name = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = guistate.containsKey("text:XYZ") ? ((EditBox) guistate.get("text:XYZ")).getValue() : "";
			entity.getCapability(RickAndMortyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.coordinate = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof Player _player)
			_player.closeContainer();
	}
}
