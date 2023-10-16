package net.wei_bai.TecUtil.mixin.config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.wei_bai.TecUtil.mixin.mixin.SetRangedAttribute;
import net.wei_bai.TecUtil.mixin.temp.RegistryHelper;
import net.wei_bai.technology.TechnologyMod;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AttributeConfig {
    @Expose
    private Map<String, Entry> attributes = new HashMap<>();

    public void applyChanges(RegistryHelper<Attribute> registry) {


        TechnologyMod.LOG.info("Applying changes for {} attributes.", attributes.size());
        for (Map.Entry<String, Entry> configEntry : attributes.entrySet()) {

            final ResourceLocation attributeId = ResourceLocation.tryParse(configEntry.getKey());

            if (attributeId != null && registry.exists(attributeId)) {

                final Attribute attribute = registry.get(attributeId);

                if (attribute instanceof RangedAttribute ranged) {

                    final double minValue = configEntry.getValue().min.value;
                    final double maxValue =  configEntry.getValue().max.value;

                    if (minValue > maxValue) {

                        TechnologyMod.LOG.error("Attribute {} was configured to have a minimum value higher than it's maximum. This is not permitted!", attributeId);
                        continue;
                    }

                    final SetRangedAttribute accessor = (SetRangedAttribute)(Object)attribute;

                    if (minValue != ranged.getMinValue()) {

                        TechnologyMod.LOG.debug("Modifying minimum value for {} from {} to {}.", attributeId, TechnologyMod.FORMAT.format(ranged.getMinValue()), TechnologyMod.FORMAT.format(minValue));
                        accessor.attributefix$setMinValue( -Double.MAX_VALUE);
                    }

                    if (maxValue != ranged.getMaxValue()) {

                        TechnologyMod.LOG.debug("Modifying maximum value for {} from {} to {}.", attributeId, TechnologyMod.FORMAT.format(ranged.getMaxValue()), TechnologyMod.FORMAT.format(maxValue));
                        accessor.attributefix$setMaxValue( Double.MAX_VALUE);
                    }
                }
            }
        }
    }

    public static AttributeConfig load(File configFile, RegistryHelper<Attribute> registry) {

        final AttributeConfig config = new AttributeConfig();

        // Load/Generate the default values.
        for (Attribute attribute : registry.getValues()) {

            if (attribute instanceof RangedAttribute ranged) {

                final ResourceLocation id = registry.getId(attribute);
                config.attributes.put(id.toString(), new Entry(id, ranged));//1.7976931348623157E308
            }
        }

        TechnologyMod.LOG.info("Loaded values for {} compatible attributes.", config.attributes.size());

        // Attempt to load existing config file
        if (configFile.exists()) {

            try (FileReader reader = new FileReader(configFile)) {

                final Map<String, Entry> configValues = TechnologyMod.GSON.fromJson(reader, AttributeConfig.class).attributes;

                for (Map.Entry<String, Entry> configEntry : configValues.entrySet()) {

                    final ResourceLocation attributeId = ResourceLocation.tryParse(configEntry.getKey());

                    if (attributeId == null) {

                        TechnologyMod.LOG.error("Attribute ID '{}' is not a valid. This entry will be ignored.", configEntry.getKey());
                    }

                    else if (!registry.exists(attributeId)) {

                        TechnologyMod.LOG.error("Attribute ID '{}' does not belong to a known attribute. This entry will be ignored.", configEntry.getKey());
                    }

                    if (configEntry.getValue().min.value > configEntry.getValue().max.value) {

                        TechnologyMod.LOG.error("Attribute ID '{}' has a max value that is less than its minimum value!", configEntry.getKey());
                    }

                    // Prevent data loss by including the user data even if it's invalid. Additional checks will be required when applying this later on.
                    config.attributes.put(configEntry.getKey(), configEntry.getValue());
                }

                TechnologyMod.LOG.info("Loaded {} values from config.", configValues.size());
            }

            catch (IOException e) {

                TechnologyMod.LOG.error("Could not read config file {}. Defaults will be used.", configFile.getAbsolutePath());
                TechnologyMod.LOG.trace("Failed to read config file.", e);
            }
        }

        else {

            TechnologyMod.LOG.info("Creating a new config file at {}.", configFile.getAbsolutePath());
            configFile.getParentFile().mkdirs();
        }

        try (FileWriter writer = new FileWriter(configFile)) {

            TechnologyMod. GSON.toJson(config, writer);
            TechnologyMod.LOG.info("Saving config file. {} entries.", config.attributes.size());
        }

        catch (IOException e) {

            TechnologyMod. LOG.error("Could not write config file '{}'!", configFile.getAbsolutePath());
            TechnologyMod. LOG.trace("Failed to read config file.", e);
        }


        return config;
    }

    public static class Entry {

        @Expose
        private boolean enabled;

        @Expose
        private DoubleValue min;

        @Expose
        private DoubleValue max;

        public Entry(ResourceLocation id, RangedAttribute attribute) {

            this.enabled = "minecraft".equals(id.getNamespace());
            this.min = new DoubleValue(attribute.getMinValue(), 0);
            this.max = new DoubleValue(attribute.getMaxValue(),  Double.MAX_VALUE);
        }

        public boolean isEnabled() {

            return this.isEnabled();
        }
    }

    public static class DoubleValue {

        @Expose
        @SerializedName("default")
        private double defaultValue;

        @Expose
        private double value;

        public DoubleValue(double defaultValue, double value) {

            this.defaultValue = defaultValue;
            this.value = value;
        }
    }
}