package net.wei_bai.technology.procedures;

import net.wei_bai.technology.network.TechnologyModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetsMaxHealthProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "player")) {
				{
					double _setval = DoubleArgumentType.getDouble(arguments, "order");
					entityiterator.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.max_health = _setval;
						capability.syncPlayerVariables(entityiterator);
					});
				}
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent(("\u4EE5\u5C06\u5B9E\u4F53" + entityiterator + "\u7684\u6700\u5927\u751F\u547D\u503C\u8BBE\u7F6E\u4E3A:\"" + DoubleArgumentType.getDouble(arguments, "order") + "\"")), (false));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
