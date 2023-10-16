package baubles.client.event;

import baubles.api.TechnologyAPI;
import baubles.client.renderer.TechnologyRenderLayer;
import com.google.common.base.Preconditions;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;



@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = TechnologyAPI.MOD_ID, value = Dist.CLIENT)
public class ModelAddLayerEvent {

    @SubscribeEvent
    public static void onAddLayer(EntityRenderersEvent.AddLayers event) {
        var defaultModel = (PlayerRenderer) event.getSkin("default");
        var slimModel = (PlayerRenderer) event.getSkin("slim");
        Preconditions.checkNotNull(defaultModel);
        Preconditions.checkNotNull(slimModel);
        defaultModel.addLayer(new TechnologyRenderLayer<>(defaultModel));
        slimModel.addLayer(new TechnologyRenderLayer<>(slimModel));
    }
}
