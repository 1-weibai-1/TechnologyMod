package net.wei_bai.technology.procedures;

import net.wei_bai.technology.network.TechnologyModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ChooselifeopenProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).choose_life_number == 2) {
			{
				String _setval = "\u795E\u65CF";
				entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.choose_life = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).choose_life_number == 1) {
			{
				String _setval = "\u7075\u65CF";
				entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.choose_life = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).choose_life_number == 0) {
			{
				String _setval = "\u4EBA\u65CF";
				entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.choose_life = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).choose_life_number == -1) {
			{
				String _setval = "\u5996\u65CF";
				entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.choose_life = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).choose_life_number == -2) {
			{
				String _setval = "\u9B54\u65CF";
				entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.choose_life = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).choose_life_number > 2) {
			{
				double _setval = -2;
				entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.choose_life_number = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TechnologyModVariables.PlayerVariables())).choose_life_number < -2) {
			{
				double _setval = 2;
				entity.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.choose_life_number = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
