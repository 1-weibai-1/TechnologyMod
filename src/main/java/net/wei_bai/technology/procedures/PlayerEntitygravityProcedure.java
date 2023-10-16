package net.wei_bai.technology.procedures;

import net.wei_bai.technology.network.TechnologyModVariables;

import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class PlayerEntitygravityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(ForgeMod.ENTITY_GRAVITY.get()).setBaseValue(((entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).entity_gravity));
	}
}
