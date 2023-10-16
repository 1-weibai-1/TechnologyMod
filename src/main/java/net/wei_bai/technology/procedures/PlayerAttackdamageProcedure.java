package net.wei_bai.technology.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.wei_bai.technology.network.TechnologyModVariables;

 

public class PlayerAttackdamageProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		((LivingEntity) entity).getAttribute(Attributes.ATTACK_DAMAGE)
				.setBaseValue(((entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TechnologyModVariables.PlayerVariables())).attack_damage));
	}
}
