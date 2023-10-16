package net.wei_bai.technology.procedures;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

public class GetMovementSpeedProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "player")) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(
							new TextComponent((entityiterator.getDisplayName().getString() + "" + "\u7684\u79FB\u52A8\u901F\u5EA6\u4E3A:\""
									+ new java.text.DecimalFormat("##.##")
											.format(((LivingEntity) entityiterator).getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue())
									+ "\"")),
							(false));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
