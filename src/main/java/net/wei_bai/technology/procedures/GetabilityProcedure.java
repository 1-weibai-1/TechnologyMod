package net.wei_bai.technology.procedures;

import net.wei_bai.technology.network.TechnologyModVariables;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class GetabilityProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "player")) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(new TextComponent(("\u00A7e\u5F53\u524D\u201C" + entityiterator.getDisplayName().getString() + "\u201D\u4FEE\u4E3A\uFF1A"
							+ new java.text.DecimalFormat("##").format((entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).ability_6 * 100000000 * 100000000 * 100000000
									* 100000000 * 100000000 * 100000000)
							+ new java.text.DecimalFormat("##")
									.format((entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).ability_5 * 100000000 * 100000000 * 100000000 * 100000000 * 100000000)
							+ new java.text.DecimalFormat("##")
									.format((entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).ability_4 * 100000000 * 100000000 * 100000000 * 100000000)
							+ new java.text.DecimalFormat("##")
									.format((entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).ability_3 * 100000000 * 100000000 * 100000000)
							+ new java.text.DecimalFormat("##").format((entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).ability_2 * 100000000 * 100000000)
							+ new java.text.DecimalFormat("##").format((entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).ability_1 * 100000000)
							+ new java.text.DecimalFormat("##").format((entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).ability_0) + "vae")), (true));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
