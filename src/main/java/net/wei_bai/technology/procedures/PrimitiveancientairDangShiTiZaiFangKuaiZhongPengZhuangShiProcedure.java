package net.wei_bai.technology.procedures;

import net.wei_bai.technology.network.TechnologyModVariables;

import net.minecraft.world.entity.Entity;

public class PrimitiveancientairDangShiTiZaiFangKuaiZhongPengZhuangShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).ability_0 + 1;
			entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ability_0 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
