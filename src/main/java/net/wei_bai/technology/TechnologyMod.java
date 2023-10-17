package net.wei_bai.technology;


import baubles.client.gui.PlayerExpandedScreen;
import baubles.network.PacketHandler;
import baubles.setup.ModConfigs;
import baubles.setup.ModItems;
import baubles.setup.ModMenus;
import com.google.gson.*;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.wei_bai.tecutil.util.TechnologyModRecipes;
import net.wei_bai.technology.init.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Mod("technology")
public class TechnologyMod {
	public static final Logger LOGGER = LogManager.getLogger(TechnologyMod.class);
	public static final Logger LOG = LOGGER;
	public static final String MODID = "technology";
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;
	public static final Gson GSON = new GsonBuilder().
			excludeFieldsWithoutExposeAnnotation().
			setPrettyPrinting().
			registerTypeAdapter(Double.class,
					new DoubleJsonSerializer()).create();
	public static final DecimalFormat FORMAT = new DecimalFormat("#.##");
	public static KeyMapping KEY_TECHNOLOGY = null;



	public TechnologyMod() {
		TechnologyModTabs.load();
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		TechnologyModBlocks.REGISTRY.register(bus);
		TechnologyModItems.REGISTRY.register(bus);
		TechnologyModEntities.REGISTRY.register(bus);
		TechnologyModBlockEntities.REGISTRY.register(bus);
		TechnologyModFeatures.REGISTRY.register(bus);
		TechnologyModParticleTypes.REGISTRY.register(bus);

		TechnologyModMobEffects.REGISTRY.register(bus);

		TechnologyModBiomes.REGISTRY.register(bus);

		final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		eventBus.addListener(this::setup);

		// 注册客户端设置
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		// 注册我们感兴趣的服务器和其他游戏活动
		MinecraftForge.EVENT_BUS.register(this);

		ModConfigs.registerAndLoadConfig();
		ModItems.init();
		ModMenus.init();

		TechnologyModRecipes.RECIPE.register(bus);
	}

	private static final class DoubleJsonSerializer implements JsonSerializer<Double> {

		@Override
		public JsonElement serialize(final Double src, final Type typeOfSrc, final JsonSerializationContext context) {
			BigDecimal value = BigDecimal.valueOf(src);
			try {
				value = new BigDecimal(value.toBigIntegerExact());
			}
			catch (ArithmeticException e) {
				// NO-OP
			}
			return new JsonPrimitive(value);
		}
	}

	private void clientSetup(final FMLClientSetupEvent event) {
		// register health bar overlay
		Overlays.registerOverlays();
		MenuScreens.register(ModMenus.PLAYER_TECHNOLOGY.get(), PlayerExpandedScreen::new);

		KEY_TECHNOLOGY =new KeyMapping("keybind.baublesinventory",GLFW.GLFW_KEY_I, "key.categories.inventory");
		ClientRegistry.registerKeyBinding(KEY_TECHNOLOGY);

	}

	private void setup(FMLCommonSetupEvent evt) {
		Modlpull.addCustomItemProperties();

		PacketHandler.registerMessages();

	}

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder,
			BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}


}
