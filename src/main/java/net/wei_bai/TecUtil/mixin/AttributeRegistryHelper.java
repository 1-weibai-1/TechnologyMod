package net.wei_bai.TecUtil.mixin;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.registries.ForgeRegistries;
import net.wei_bai.TecUtil.mixin.temp.RegistryHelper;

import java.util.Collection;

public class AttributeRegistryHelper implements RegistryHelper<Attribute> {

    @Override
    public Attribute get(ResourceLocation id) {

        return ForgeRegistries.ATTRIBUTES.getValue(id);
    }

    @Override
    public ResourceLocation getId(Attribute value) {

        return value.getRegistryName();
    }

    @Override
    public boolean isRegistered(Attribute value) {

        return ForgeRegistries.ATTRIBUTES.containsValue(value);
    }

    @Override
    public boolean exists(ResourceLocation id) {

        return ForgeRegistries.ATTRIBUTES.containsKey(id);
    }

    @Override
    public Collection<Attribute> getValues() {

        return ForgeRegistries.ATTRIBUTES.getValues();
    }
}