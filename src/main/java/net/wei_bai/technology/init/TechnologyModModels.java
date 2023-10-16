
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wei_bai.technology.init;

import net.wei_bai.technology.client.model.Modeltiger;
import net.wei_bai.technology.client.model.Modelentities_jianqi_0;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TechnologyModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modeltiger.LAYER_LOCATION, Modeltiger::createBodyLayer);
		event.registerLayerDefinition(Modelentities_jianqi_0.LAYER_LOCATION, Modelentities_jianqi_0::createBodyLayer);
	}
}
