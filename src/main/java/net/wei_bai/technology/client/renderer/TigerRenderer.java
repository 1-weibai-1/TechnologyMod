
package net.wei_bai.technology.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.wei_bai.technology.client.model.Modeltiger;
import net.wei_bai.technology.entity.TigerEntity;

public class TigerRenderer extends MobRenderer<TigerEntity, Modeltiger<TigerEntity>> {
	public TigerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeltiger(context.bakeLayer(Modeltiger.LAYER_LOCATION)), 0.68f);
	}

	@Override
	public ResourceLocation getTextureLocation(TigerEntity entity) {
		return new ResourceLocation("technology:textures/entities/tiger.png");
	}
}
