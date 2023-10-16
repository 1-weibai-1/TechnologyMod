package net.wei_bai.technology.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class GetSwimspeedProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "player")) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent((entityiterator.getDisplayName().getString() + "" + "\u7684\u6E38\u6CF3\u901F\u5EA6\u4E3A:\""
							+ new java.text.DecimalFormat("##.##").format(((LivingEntity) entityiterator).getAttribute(ForgeMod.SWIM_SPEED.get()).getBaseValue()) + "\"")), (false));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
