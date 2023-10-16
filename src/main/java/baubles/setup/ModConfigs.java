package baubles.setup;

import baubles.api.TechnologyAPI;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import net.wei_bai.TecUtil.mixin.AttributeRegistryHelper;
import net.wei_bai.TecUtil.mixin.config.AttributeConfig;
import net.wei_bai.TecUtil.mixin.temp.RegistryHelper;

public class ModConfigs {

    private static final ForgeConfigSpec CLIENT;

    public static final ForgeConfigSpec.BooleanValue RENDER_TECHNOLOGY;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder.push(TechnologyAPI.MOD_ID);
        RENDER_TECHNOLOGY = builder.comment("When enabled baubles can render on player.").define("render_technologys", true);
        builder.pop();

        CLIENT = builder.build();
    }

    public static void registerAndLoadConfig() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT);
        CommentedFileConfig config = CommentedFileConfig
                .builder(FMLPaths.CONFIGDIR.get().resolve(
                        TechnologyAPI.MOD_ID.concat("-client.toml")
                )).sync().writingMode(WritingMode.REPLACE).build();

        RegistryHelper<Attribute> registry = new AttributeRegistryHelper();
        AttributeConfig.load(FMLPaths.CONFIGDIR.get().resolve(TechnologyAPI.MOD_ID.concat("-attribute.json")).toFile(),
                registry).applyChanges(registry);

        config.load();
        CLIENT.setConfig(config);
    }
}
