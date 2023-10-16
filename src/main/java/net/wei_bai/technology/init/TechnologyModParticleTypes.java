
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wei_bai.technology.init;

import net.wei_bai.technology.TechnologyMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

public class TechnologyModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, TechnologyMod.MODID);
	public static final RegistryObject<ParticleType<?>> LLL = REGISTRY.register("lll", () -> new SimpleParticleType(false));
}
