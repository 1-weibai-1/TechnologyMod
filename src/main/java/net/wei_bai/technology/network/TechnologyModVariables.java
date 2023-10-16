package net.wei_bai.technology.network;

import net.wei_bai.technology.TechnologyMod;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TechnologyModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		TechnologyMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		TechnologyMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.ability_0 = original.ability_0;
			clone.ability_1 = original.ability_1;
			clone.ability_2 = original.ability_2;
			clone.ability_3 = original.ability_3;
			clone.ability_4 = original.ability_4;
			clone.ability_5 = original.ability_5;
			clone.ability_6 = original.ability_6;
			clone.ability_name = original.ability_name;
			clone.ability_bar = original.ability_bar;
			clone.armor = original.armor;
			clone.armor_toughness = original.armor_toughness;
			clone.attack_damage = original.attack_damage;
			clone.attack_knockback = original.attack_knockback;
			clone.attack_speed = original.attack_speed;
			clone.knockback_resistance = original.knockback_resistance;
			clone.max_health = original.max_health;
			clone.movement_speed = original.movement_speed;
			clone.luck = original.luck;
			clone.reach_distance = original.reach_distance;
			clone.swim_speed = original.swim_speed;
			clone.entity_gravity = original.entity_gravity;
			clone.choose_life = original.choose_life;
			clone.choose_life_open = original.choose_life_open;
			clone.choose_life_number = original.choose_life_number;
			clone.player_additional_max_health = original.player_additional_max_health;
			if (!event.isWasDeath()) {
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().level.isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getPlayer().level);
				SavedData worlddata = WorldVariables.get(event.getPlayer().level);
				if (mapdata != null)
					TechnologyMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					TechnologyMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().level.isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getPlayer().level);
				if (worlddata != null)
					TechnologyMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "technology_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				TechnologyMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "technology_mapvars";
		public double player_additional_attack_damage = 0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			player_additional_attack_damage = nbt.getDouble("player_additional_attack_damage");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("player_additional_attack_damage", player_additional_attack_damage);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				TechnologyMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		public int type;
		public SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			if (this.data instanceof MapVariables _mapvars)
				_mapvars.read(buffer.readNbt());
			else if (this.data instanceof WorldVariables _worldvars)
				_worldvars.read(buffer.readNbt());
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("technology", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double ability_0 = 0;
		public double ability_1 = 0;
		public double ability_2 = 0;
		public double ability_3 = 0;
		public double ability_4 = 0;
		public double ability_5 = 0;
		public double ability_6 = 0;
		public String ability_name = "\u51E1";
		public double ability_bar = 0;
		public double armor = 0;
		public double armor_toughness = 0.0;
		public double attack_damage = 1.0;
		public double attack_knockback = 0.0;
		public double attack_speed = 4.0;
		public double knockback_resistance = 0.0;
		public double max_health = 20.0;
		public double movement_speed = 0.1;
		public double luck = 0;
		public double reach_distance = 5.0;
		public double swim_speed = 1.0;
		public double entity_gravity = 0.08;
		public String choose_life = "\u51E1\u4EBA";
		public boolean choose_life_open = false;
		public double choose_life_number = 0.0;
		public double player_additional_max_health = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				TechnologyMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("ability_0", ability_0);
			nbt.putDouble("ability_1", ability_1);
			nbt.putDouble("ability_2", ability_2);
			nbt.putDouble("ability_3", ability_3);
			nbt.putDouble("ability_4", ability_4);
			nbt.putDouble("ability_5", ability_5);
			nbt.putDouble("ability_6", ability_6);
			nbt.putString("ability_name", ability_name);
			nbt.putDouble("ability_bar", ability_bar);
			nbt.putDouble("armor", armor);
			nbt.putDouble("armor_toughness", armor_toughness);
			nbt.putDouble("attack_damage", attack_damage);
			nbt.putDouble("attack_knockback", attack_knockback);
			nbt.putDouble("attack_speed", attack_speed);
			nbt.putDouble("knockback_resistance", knockback_resistance);
			nbt.putDouble("max_health", max_health);
			nbt.putDouble("movement_speed", movement_speed);
			nbt.putDouble("luck", luck);
			nbt.putDouble("reach_distance", reach_distance);
			nbt.putDouble("swim_speed", swim_speed);
			nbt.putDouble("entity_gravity", entity_gravity);
			nbt.putString("choose_life", choose_life);
			nbt.putBoolean("choose_life_open", choose_life_open);
			nbt.putDouble("choose_life_number", choose_life_number);
			nbt.putDouble("player_additional_max_health", player_additional_max_health);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			ability_0 = nbt.getDouble("ability_0");
			ability_1 = nbt.getDouble("ability_1");
			ability_2 = nbt.getDouble("ability_2");
			ability_3 = nbt.getDouble("ability_3");
			ability_4 = nbt.getDouble("ability_4");
			ability_5 = nbt.getDouble("ability_5");
			ability_6 = nbt.getDouble("ability_6");
			ability_name = nbt.getString("ability_name");
			ability_bar = nbt.getDouble("ability_bar");
			armor = nbt.getDouble("armor");
			armor_toughness = nbt.getDouble("armor_toughness");
			attack_damage = nbt.getDouble("attack_damage");
			attack_knockback = nbt.getDouble("attack_knockback");
			attack_speed = nbt.getDouble("attack_speed");
			knockback_resistance = nbt.getDouble("knockback_resistance");
			max_health = nbt.getDouble("max_health");
			movement_speed = nbt.getDouble("movement_speed");
			luck = nbt.getDouble("luck");
			reach_distance = nbt.getDouble("reach_distance");
			swim_speed = nbt.getDouble("swim_speed");
			entity_gravity = nbt.getDouble("entity_gravity");
			choose_life = nbt.getString("choose_life");
			choose_life_open = nbt.getBoolean("choose_life_open");
			choose_life_number = nbt.getDouble("choose_life_number");
			player_additional_max_health = nbt.getDouble("player_additional_max_health");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.ability_0 = message.data.ability_0;
					variables.ability_1 = message.data.ability_1;
					variables.ability_2 = message.data.ability_2;
					variables.ability_3 = message.data.ability_3;
					variables.ability_4 = message.data.ability_4;
					variables.ability_5 = message.data.ability_5;
					variables.ability_6 = message.data.ability_6;
					variables.ability_name = message.data.ability_name;
					variables.ability_bar = message.data.ability_bar;
					variables.armor = message.data.armor;
					variables.armor_toughness = message.data.armor_toughness;
					variables.attack_damage = message.data.attack_damage;
					variables.attack_knockback = message.data.attack_knockback;
					variables.attack_speed = message.data.attack_speed;
					variables.knockback_resistance = message.data.knockback_resistance;
					variables.max_health = message.data.max_health;
					variables.movement_speed = message.data.movement_speed;
					variables.luck = message.data.luck;
					variables.reach_distance = message.data.reach_distance;
					variables.swim_speed = message.data.swim_speed;
					variables.entity_gravity = message.data.entity_gravity;
					variables.choose_life = message.data.choose_life;
					variables.choose_life_open = message.data.choose_life_open;
					variables.choose_life_number = message.data.choose_life_number;
					variables.player_additional_max_health = message.data.player_additional_max_health;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
