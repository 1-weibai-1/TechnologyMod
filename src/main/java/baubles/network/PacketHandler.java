package baubles.network;


import baubles.network.msg.OpenTechnologysInvPacket;
import baubles.network.msg.OpenNormalInvPacket;
import baubles.network.msg.SyncPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

import static baubles.api.TechnologyAPI.MOD_ID;

public class PacketHandler {

    public static SimpleChannel INSTANCE;
    private static int ID = 0;

    public static int nextID() {
        return ID++;
    }

    public static void registerMessages() {
        INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation(MOD_ID, "net_channel"), () -> "1.0", s -> true, s -> true);

        INSTANCE.registerMessage(nextID(), OpenTechnologysInvPacket.class, OpenTechnologysInvPacket::toBytes, OpenTechnologysInvPacket::new, OpenTechnologysInvPacket::handle);
        INSTANCE.registerMessage(nextID(), OpenNormalInvPacket.class, OpenNormalInvPacket::toBytes, OpenNormalInvPacket::new, OpenNormalInvPacket::handle);
        INSTANCE.registerMessage(nextID(), SyncPacket.class, SyncPacket::toBytes, SyncPacket::new, SyncPacket::handle);
    }
}
