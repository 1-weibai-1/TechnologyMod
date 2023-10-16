package net.wei_bai.technology.procedures;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class SetReachdistanceProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "player")) {
				((LivingEntity) entityiterator).getAttribute(ForgeMod.REACH_DISTANCE.get()).setBaseValue((DoubleArgumentType.getDouble(arguments, "order")));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
