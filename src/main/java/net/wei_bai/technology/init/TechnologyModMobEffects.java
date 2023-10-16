
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.wei_bai.technology.init;

import net.wei_bai.technology.potion.DaoliangriceeffenceMobEffect;
import net.wei_bai.technology.TechnologyMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

public class TechnologyModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TechnologyMod.MODID);
	public static final RegistryObject<MobEffect> DAOLIANGRICEEFFENCE = REGISTRY.register("daoliangriceeffence", () -> new DaoliangriceeffenceMobEffect());
}
