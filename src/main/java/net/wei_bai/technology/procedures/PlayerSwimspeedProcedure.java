package net.wei_bai.technology.procedures;

import net.wei_bai.technology.network.TechnologyModVariables;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class PlayerSwimspeedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(ForgeMod.SWIM_SPEED.get()).setBaseValue(((entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).swim_speed));
	}
}
