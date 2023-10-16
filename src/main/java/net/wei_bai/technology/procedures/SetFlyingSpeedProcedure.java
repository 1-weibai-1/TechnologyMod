package net.wei_bai.technology.procedures;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

public class SetFlyingSpeedProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			_player.getAbilities().flying = (true);
			_player.onUpdateAbilities();
		}
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "player")) {
				((LivingEntity) entityiterator).getAttribute(Attributes.FLYING_SPEED)
						.setBaseValue((DoubleArgumentType.getDouble(arguments, "order")));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
