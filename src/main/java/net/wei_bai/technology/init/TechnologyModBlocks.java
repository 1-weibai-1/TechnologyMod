
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wei_bai.technology.init;

import net.wei_bai.technology.block.StrippedprimitiveancientlogBlock;
import net.wei_bai.technology.block.StonetoolworkbenchBlock;
import net.wei_bai.technology.block.SpiritualbarrierBlock;
import net.wei_bai.technology.block.PrimitiveworksBlock;
import net.wei_bai.technology.block.Primitiveworks1Block;
import net.wei_bai.technology.block.PrimitiveancientwallBlock;
import net.wei_bai.technology.block.PrimitiveancienttrapdoorBlock;
import net.wei_bai.technology.block.PrimitiveancientstairsBlock;
import net.wei_bai.technology.block.PrimitiveancientslabBlock;
import net.wei_bai.technology.block.PrimitiveancientsaplingBlock;
import net.wei_bai.technology.block.PrimitiveancientpressureplateBlock;
import net.wei_bai.technology.block.PrimitiveancientplanksBlock;
import net.wei_bai.technology.block.PrimitiveancientlogBlock;
import net.wei_bai.technology.block.PrimitiveancientleavesBlock;
import net.wei_bai.technology.block.PrimitiveancientgrassblockBlock;
import net.wei_bai.technology.block.PrimitiveancientfencegateBlock;
import net.wei_bai.technology.block.PrimitiveancientfenceBlock;
import net.wei_bai.technology.block.PrimitiveancientdoorBlock;
import net.wei_bai.technology.block.PrimitiveancientbuttonBlock;
import net.wei_bai.technology.block.PrimitiveancientairBlock;
import net.wei_bai.technology.block.KnifestoneBlock;
import net.wei_bai.technology.block.EnclosureblockBlock;
import net.wei_bai.technology.block.DaolianggrassBlock;
import net.wei_bai.technology.block.AwakeningCrystalBlock;
import net.wei_bai.technology.TechnologyMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

public class TechnologyModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TechnologyMod.MODID);
	public static final RegistryObject<Block> PRIMITIVEANCIENTAIR = REGISTRY.register("primitiveancientair", () -> new PrimitiveancientairBlock());
	public static final RegistryObject<Block> STONETOOLWORKBENCH = REGISTRY.register("stonetoolworkbench", () -> new StonetoolworkbenchBlock());
	public static final RegistryObject<Block> PRIMITIVEANCIENTGRASSBLOCK = REGISTRY.register("primitiveancientgrassblock", () -> new PrimitiveancientgrassblockBlock());
	public static final RegistryObject<Block> PRIMITIVEANCIENTSAPLING = REGISTRY.register("primitiveancientsapling", () -> new PrimitiveancientsaplingBlock());
	public static final RegistryObject<Block> PRIMITIVEANCIENTLEAVES = REGISTRY.register("primitiveancientleaves", () -> new PrimitiveancientleavesBlock());
	public static final RegistryObject<Block> PRIMITIVEANCIENTLOG = REGISTRY.register("primitiveancientlog", () -> new PrimitiveancientlogBlock());
	public static final RegistryObject<Block> STRIPPEDPRIMITIVEANCIENTLOG = REGISTRY.register("strippedprimitiveancientlog", () -> new StrippedprimitiveancientlogBlock());
	public static final RegistryObject<Block> PRIMITIVEANCIENTPLANKS = REGISTRY.register("primitiveancientplanks", () -> new PrimitiveancientplanksBlock());
	public static final RegistryObject<Block> PRIMITIVEANCIENTSLAB = REGISTRY.register("primitiveancientslab", () -> new PrimitiveancientslabBlock());
	public static final RegistryObject<Block> PRIMITIVEANCIENTSTAIRS = REGISTRY.register("primitiveancientstairs", () -> new PrimitiveancientstairsBlock());
	public static final RegistryObject<Block> PRIMITIVEANCIENTWALL = REGISTRY.register("primitiveancientwall", () -> new PrimitiveancientwallBlock());
	public static final RegistryObject<Block> PRIMITIVEANCIENTFENCE = REGISTRY.register("primitiveancientfence", () -> new PrimitiveancientfenceBlock());
	public static final RegistryObject<Block> PRIMITIVEANCIENTFENCEGATE = REGISTRY.register("primitiveancientfencegate", () -> new PrimitiveancientfencegateBlock());
	public static final RegistryObject<Block> PRIMITIVEANCIENTTRAPDOOR = REGISTRY.register("primitiveancienttrapdoor", () -> new PrimitiveancienttrapdoorBlock());
	public static final RegistryObject<Block> PRIMITIVEANCIENTDOOR = REGISTRY.register("primitiveancientdoor", () -> new PrimitiveancientdoorBlock());
	public static final RegistryObject<Block> KNIFESTONE = REGISTRY.register("knifestone", () -> new KnifestoneBlock());
	public static final RegistryObject<Block> PRIMITIVEANCIENTPRESSUREPLATE = REGISTRY.register("primitiveancientpressureplate", () -> new PrimitiveancientpressureplateBlock());
	public static final RegistryObject<Block> PRIMITIVEANCIENTBUTTON = REGISTRY.register("primitiveancientbutton", () -> new PrimitiveancientbuttonBlock());
	public static final RegistryObject<Block> SPIRITUALBARRIER = REGISTRY.register("spiritualbarrier", () -> new SpiritualbarrierBlock());
	public static final RegistryObject<Block> ENCLOSUREBLOCK = REGISTRY.register("enclosureblock", () -> new EnclosureblockBlock());
	public static final RegistryObject<Block> PRIMITIVEWORKS = REGISTRY.register("primitiveworks", () -> new PrimitiveworksBlock());
	public static final RegistryObject<Block> PRIMITIVEWORKS_1 = REGISTRY.register("primitiveworks_1", () -> new Primitiveworks1Block());
	public static final RegistryObject<Block> AWAKENING_CRYSTAL = REGISTRY.register("awakening_crystal", () -> new AwakeningCrystalBlock());
	public static final RegistryObject<Block> DAOLIANGGRASS = REGISTRY.register("daolianggrass", () -> new DaolianggrassBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			PrimitiveancientairBlock.registerRenderLayer();
			PrimitiveancientgrassblockBlock.registerRenderLayer();
			PrimitiveancientsaplingBlock.registerRenderLayer();
			PrimitiveancientwallBlock.registerRenderLayer();
			PrimitiveancientfenceBlock.registerRenderLayer();
			PrimitiveancientfencegateBlock.registerRenderLayer();
			PrimitiveancienttrapdoorBlock.registerRenderLayer();
			PrimitiveancientdoorBlock.registerRenderLayer();
			KnifestoneBlock.registerRenderLayer();
			PrimitiveancientpressureplateBlock.registerRenderLayer();
			PrimitiveancientbuttonBlock.registerRenderLayer();
			SpiritualbarrierBlock.registerRenderLayer();
			EnclosureblockBlock.registerRenderLayer();
			PrimitiveworksBlock.registerRenderLayer();
			Primitiveworks1Block.registerRenderLayer();
			AwakeningCrystalBlock.registerRenderLayer();
			DaolianggrassBlock.registerRenderLayer();
		}

		@SubscribeEvent
		public static void blockColorLoad(ColorHandlerEvent.Block event) {
			PrimitiveancientgrassblockBlock.blockColorLoad(event);
			PrimitiveancientleavesBlock.blockColorLoad(event);
			DaolianggrassBlock.blockColorLoad(event);
		}

		@SubscribeEvent
		public static void itemColorLoad(ColorHandlerEvent.Item event) {
			PrimitiveancientgrassblockBlock.itemColorLoad(event);
			PrimitiveancientleavesBlock.itemColorLoad(event);
			DaolianggrassBlock.itemColorLoad(event);
		}
	}
}
