package net.mcreator.rick_and_morty.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.rick_and_morty.network.RickAndMortyModVariables;
import net.mcreator.rick_and_morty.RickAndMortyMod;

public class TeleportplayerwithportalProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 1, 1, 1), e -> true).isEmpty()) {
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
									_ent.level.getServer(), _ent),
							("execute in " + (sourceentity.getCapability(RickAndMortyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RickAndMortyModVariables.PlayerVariables())).portal_name + " run teleport @p "
									+ (sourceentity.getCapability(RickAndMortyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new RickAndMortyModVariables.PlayerVariables())).coordinate));
				}
			}
			RickAndMortyMod.queueServerWork(25, () -> {
				{
					Entity _ent = sourceentity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "setblock ~ ~-1 ~ minecraft:stone");
					}
				}
			});
		}
	}
}
