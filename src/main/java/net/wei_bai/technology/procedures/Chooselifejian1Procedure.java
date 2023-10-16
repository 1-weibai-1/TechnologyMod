package net.wei_bai.technology.procedures;

import net.wei_bai.technology.network.TechnologyModVariables;

import net.minecraft.world.entity.Entity;

public class Chooselifejian1Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).choose_life_number - 1;
			entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.choose_life_number = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
