package net.mcreator.rick_and_morty.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.rick_and_morty.network.RickAndMortyModVariables;
import net.mcreator.rick_and_morty.RickAndMortyMod;

public class Spawn_portal_with_gunProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(RickAndMortyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RickAndMortyModVariables.PlayerVariables())).quantity > 0) {
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "summon rick_and_morty:portalsrick ^ ^ ^3");
				}
			}
			{
				double _setval = (entity.getCapability(RickAndMortyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RickAndMortyModVariables.PlayerVariables())).quantity - 1;
				entity.getCapability(RickAndMortyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.quantity = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			RickAndMortyMod.queueServerWork(1500, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"kill @e[type=rick_and_morty:portalsrick]");
			});
		}
	}
}
