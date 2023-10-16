package baubles.client.event;

import baubles.network.PacketHandler;
import baubles.network.msg.OpenTechnologysInvPacket;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.wei_bai.technology.TechnologyMod.KEY_TECHNOLOGY;
import static net.wei_bai.technology.TechnologyMod.MODID;

@Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
public class ClientPlayerTick {

    @SubscribeEvent
    public static void playerTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            if (KEY_TECHNOLOGY.consumeClick() && Minecraft.getInstance().isWindowActive()) {
                PacketHandler.INSTANCE.sendToServer(new OpenTechnologysInvPacket());
            }
        }
    }
}