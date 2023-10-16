
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wei_bai.technology.init;

import net.wei_bai.technology.block.entity.StonetoolworkbenchBlockEntity;
import net.wei_bai.technology.block.entity.PrimitiveworksBlockEntity;
import net.wei_bai.technology.block.entity.Primitiveworks1BlockEntity;
import net.wei_bai.technology.block.entity.KnifestoneBlockEntity;
import net.wei_bai.technology.block.entity.AwakeningCrystalBlockEntity;
import net.wei_bai.technology.TechnologyMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class TechnologyModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, TechnologyMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> STONETOOLWORKBENCH = register("stonetoolworkbench", TechnologyModBlocks.STONETOOLWORKBENCH, StonetoolworkbenchBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> KNIFESTONE = register("knifestone", TechnologyModBlocks.KNIFESTONE, KnifestoneBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PRIMITIVEWORKS = register("primitiveworks", TechnologyModBlocks.PRIMITIVEWORKS, PrimitiveworksBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PRIMITIVEWORKS_1 = register("primitiveworks_1", TechnologyModBlocks.PRIMITIVEWORKS_1, Primitiveworks1BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> AWAKENING_CRYSTAL = register("awakening_crystal", TechnologyModBlocks.AWAKENING_CRYSTAL, AwakeningCrystalBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
