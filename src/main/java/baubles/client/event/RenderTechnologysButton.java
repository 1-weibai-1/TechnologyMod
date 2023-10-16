package baubles.client.event;


import baubles.client.gui.widget.TechnologyButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class RenderTechnologysButton {

    @SuppressWarnings("rawtypes")
    @SubscribeEvent
    public static void onGuiPostInit(ScreenEvent.InitScreenEvent.Post event) {
        Screen screen = event.getScreen();
        if (screen instanceof EffectRenderingInventoryScreen effectRenderingInventoryScreen) {
            event.addListener(new TechnologyButton(effectRenderingInventoryScreen, 64, 9, 10, 10));
        }
    }
}