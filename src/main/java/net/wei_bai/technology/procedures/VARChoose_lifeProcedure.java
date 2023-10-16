package net.wei_bai.technology.procedures;

import net.wei_bai.technology.network.TechnologyModVariables;

import net.minecraft.world.entity.Entity;

public class VARChoose_lifeProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).choose_life;
	}
}
