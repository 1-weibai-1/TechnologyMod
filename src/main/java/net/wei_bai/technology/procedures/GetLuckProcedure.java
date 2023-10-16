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

public class GetLuckProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "player")) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(
							new TextComponent(
									(entityiterator.getDisplayName().getString() + "" + "\u7684\u6C14\u8FD0\u4E3A:\""
											+ new java.text.DecimalFormat("##.##")
													.format(((LivingEntity) entityiterator).getAttribute(Attributes.LUCK).getBaseValue())
											+ "\"")),
							(false));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
