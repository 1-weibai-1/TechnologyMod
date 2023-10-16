
package net.wei_bai.technology.network;

import net.wei_bai.technology.world.inventory.ChooseLifeMenu;
import net.wei_bai.technology.procedures.ChooselifetrueProcedure;
import net.wei_bai.technology.procedures.Chooselifejian1Procedure;
import net.wei_bai.technology.procedures.Chooselifejia1Procedure;
import net.wei_bai.technology.TechnologyMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChooseLifeButtonMessage {
	private final int buttonID, x, y, z;

	public ChooseLifeButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public ChooseLifeButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(ChooseLifeButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(ChooseLifeButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = ChooseLifeMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Chooselifejian1Procedure.execute(entity);
		}
		if (buttonID == 1) {

			Chooselifejia1Procedure.execute(entity);
		}
		if (buttonID == 2) {

			ChooselifetrueProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TechnologyMod.addNetworkMessage(ChooseLifeButtonMessage.class, ChooseLifeButtonMessage::buffer, ChooseLifeButtonMessage::new, ChooseLifeButtonMessage::handler);
	}
}
