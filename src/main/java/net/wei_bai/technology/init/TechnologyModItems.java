
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wei_bai.technology.init;

import net.wei_bai.technology.item.WoodstickItem;
import net.wei_bai.technology.item.ToughstonelineItem;
import net.wei_bai.technology.item.TechnologyitemItem;
import net.wei_bai.technology.item.TechnologybookItem;
import net.wei_bai.technology.item.StonetoolsyntheticclothItem;
import net.wei_bai.technology.item.StoneslagItem;
import net.wei_bai.technology.item.StonepowderItem;
import net.wei_bai.technology.item.StoneknifepartsItem;
import net.wei_bai.technology.item.StoneknifeItem;
import net.wei_bai.technology.item.SimpleweavingmachineItem;
import net.wei_bai.technology.item.SimplelighterItem;
import net.wei_bai.technology.item.SharprockfragmentsItem;
import net.wei_bai.technology.item.RoughlongbowhandleItem;
import net.wei_bai.technology.item.RoughlongbowItem;
import net.wei_bai.technology.item.RockfragmentsItem;
import net.wei_bai.technology.item.PlantfibreItem;
import net.wei_bai.technology.item.IntotheworldItem;
import net.wei_bai.technology.item.HangerItem;
import net.wei_bai.technology.item.HandheldgrindingstoneItem;
import net.wei_bai.technology.item.GravelpickheadItem;
import net.wei_bai.technology.item.GravelpickItem;
import net.wei_bai.technology.item.GravelaxeItem;
import net.wei_bai.technology.item.Granitecrushedstone_kuijia_armorArmorItem;
import net.wei_bai.technology.item.GranitecrushedstoneItem;
import net.wei_bai.technology.item.GoodKarmaBottleItem;
import net.wei_bai.technology.item.FibrethreadItem;
import net.wei_bai.technology.item.FiberragItem;
import net.wei_bai.technology.item.FiberdirtyclothItem;
import net.wei_bai.technology.item.FiberclothItem;
import net.wei_bai.technology.item.FiberblockclothItem;
import net.wei_bai.technology.item.DaoliangriceItem;
import net.wei_bai.technology.item.DaolianggrassItemsItem;
import net.wei_bai.technology.item.CrushedstoneknifeItem;
import net.wei_bai.technology.item.CrushedstoneItem;
import net.wei_bai.technology.item.CreativeevolutionjadebutterflyItem;
import net.wei_bai.technology.item.CoalminefragmentsItem;
import net.wei_bai.technology.item.ChuangzaoItem;
import net.wei_bai.technology.item.BoundarybreakerItem;
import net.wei_bai.technology.item.ApinchofslagItem;
import net.wei_bai.technology.item.AmositefragmentsItem;
import net.wei_bai.technology.TechnologyMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

public class TechnologyModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TechnologyMod.MODID);
	public static final RegistryObject<Item> TECHNOLOGYBOOK = REGISTRY.register("technologybook", () -> new TechnologybookItem());
	public static final RegistryObject<Item> PRIMITIVEANCIENTAIR = block(TechnologyModBlocks.PRIMITIVEANCIENTAIR, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> ROUGHLONGBOW = REGISTRY.register("roughlongbow", () -> new RoughlongbowItem());
	public static final RegistryObject<Item> ROUGHLONGBOWHANDLE = REGISTRY.register("roughlongbowhandle", () -> new RoughlongbowhandleItem());
	public static final RegistryObject<Item> PLANTFIBRE = REGISTRY.register("plantfibre", () -> new PlantfibreItem());
	public static final RegistryObject<Item> FIBRETHREAD = REGISTRY.register("fibrethread", () -> new FibrethreadItem());
	public static final RegistryObject<Item> CRUSHEDSTONE = REGISTRY.register("crushedstone", () -> new CrushedstoneItem());
	public static final RegistryObject<Item> GRANITECRUSHEDSTONE = REGISTRY.register("granitecrushedstone", () -> new GranitecrushedstoneItem());
	public static final RegistryObject<Item> SIMPLEWEAVINGMACHINE = REGISTRY.register("simpleweavingmachine", () -> new SimpleweavingmachineItem());
	public static final RegistryObject<Item> FIBERRAG = REGISTRY.register("fiberrag", () -> new FiberragItem());
	public static final RegistryObject<Item> FIBERDIRTYCLOTH = REGISTRY.register("fiberdirtycloth", () -> new FiberdirtyclothItem());
	public static final RegistryObject<Item> FIBERBLOCKCLOTH = REGISTRY.register("fiberblockcloth", () -> new FiberblockclothItem());
	public static final RegistryObject<Item> FIBERCLOTH = REGISTRY.register("fibercloth", () -> new FiberclothItem());
	public static final RegistryObject<Item> STONETOOLSYNTHETICCLOTH = REGISTRY.register("stonetoolsyntheticcloth", () -> new StonetoolsyntheticclothItem());
	public static final RegistryObject<Item> STONETOOLWORKBENCH = block(TechnologyModBlocks.STONETOOLWORKBENCH, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> PRIMITIVEANCIENTGRASSBLOCK = block(TechnologyModBlocks.PRIMITIVEANCIENTGRASSBLOCK, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> PRIMITIVEANCIENTSAPLING = block(TechnologyModBlocks.PRIMITIVEANCIENTSAPLING, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> PRIMITIVEANCIENTLEAVES = block(TechnologyModBlocks.PRIMITIVEANCIENTLEAVES, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> PRIMITIVEANCIENTLOG = block(TechnologyModBlocks.PRIMITIVEANCIENTLOG, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> STRIPPEDPRIMITIVEANCIENTLOG = block(TechnologyModBlocks.STRIPPEDPRIMITIVEANCIENTLOG, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> PRIMITIVEANCIENTPLANKS = block(TechnologyModBlocks.PRIMITIVEANCIENTPLANKS, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> PRIMITIVEANCIENTSLAB = block(TechnologyModBlocks.PRIMITIVEANCIENTSLAB, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> PRIMITIVEANCIENTSTAIRS = block(TechnologyModBlocks.PRIMITIVEANCIENTSTAIRS, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> PRIMITIVEANCIENTWALL = block(TechnologyModBlocks.PRIMITIVEANCIENTWALL, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> PRIMITIVEANCIENTFENCE = block(TechnologyModBlocks.PRIMITIVEANCIENTFENCE, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> PRIMITIVEANCIENTFENCEGATE = block(TechnologyModBlocks.PRIMITIVEANCIENTFENCEGATE, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> PRIMITIVEANCIENTTRAPDOOR = block(TechnologyModBlocks.PRIMITIVEANCIENTTRAPDOOR, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> PRIMITIVEANCIENTDOOR = doubleBlock(TechnologyModBlocks.PRIMITIVEANCIENTDOOR, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> HANGER = REGISTRY.register("hanger", () -> new HangerItem());
	public static final RegistryObject<Item> WOODSTICK = REGISTRY.register("woodstick", () -> new WoodstickItem());
	public static final RegistryObject<Item> GRAVELAXE = REGISTRY.register("gravelaxe", () -> new GravelaxeItem());
	public static final RegistryObject<Item> GRAVELPICK = REGISTRY.register("gravelpick", () -> new GravelpickItem());
	public static final RegistryObject<Item> CRUSHEDSTONEKNIFE = REGISTRY.register("crushedstoneknife", () -> new CrushedstoneknifeItem());
	public static final RegistryObject<Item> GRAVELPICKHEAD = REGISTRY.register("gravelpickhead", () -> new GravelpickheadItem());
	public static final RegistryObject<Item> STONEKNIFEPARTS = REGISTRY.register("stoneknifeparts", () -> new StoneknifepartsItem());
	public static final RegistryObject<Item> STONEKNIFE = REGISTRY.register("stoneknife", () -> new StoneknifeItem());
	public static final RegistryObject<Item> STONEPOWDER = REGISTRY.register("stonepowder", () -> new StonepowderItem());
	public static final RegistryObject<Item> STONESLAG = REGISTRY.register("stoneslag", () -> new StoneslagItem());
	public static final RegistryObject<Item> APINCHOFSLAG = REGISTRY.register("apinchofslag", () -> new ApinchofslagItem());
	public static final RegistryObject<Item> AMOSITEFRAGMENTS = REGISTRY.register("amositefragments", () -> new AmositefragmentsItem());
	public static final RegistryObject<Item> COALMINEFRAGMENTS = REGISTRY.register("coalminefragments", () -> new CoalminefragmentsItem());
	public static final RegistryObject<Item> ROCKFRAGMENTS = REGISTRY.register("rockfragments", () -> new RockfragmentsItem());
	public static final RegistryObject<Item> SHARPROCKFRAGMENTS = REGISTRY.register("sharprockfragments", () -> new SharprockfragmentsItem());
	public static final RegistryObject<Item> SIMPLELIGHTER = REGISTRY.register("simplelighter", () -> new SimplelighterItem());
	public static final RegistryObject<Item> TOUGHSTONELINE = REGISTRY.register("toughstoneline", () -> new ToughstonelineItem());
	public static final RegistryObject<Item> KNIFESTONE = block(TechnologyModBlocks.KNIFESTONE, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> PRIMITIVEANCIENTPRESSUREPLATE = block(TechnologyModBlocks.PRIMITIVEANCIENTPRESSUREPLATE, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> PRIMITIVEANCIENTBUTTON = block(TechnologyModBlocks.PRIMITIVEANCIENTBUTTON, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> SPIRITUALBARRIER = block(TechnologyModBlocks.SPIRITUALBARRIER, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> ENCLOSUREBLOCK = block(TechnologyModBlocks.ENCLOSUREBLOCK, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> CHUANGZAO = REGISTRY.register("chuangzao", () -> new ChuangzaoItem());
	public static final RegistryObject<Item> BOUNDARYBREAKER = REGISTRY.register("boundarybreaker", () -> new BoundarybreakerItem());
	public static final RegistryObject<Item> PRIMITIVEWORKS = block(TechnologyModBlocks.PRIMITIVEWORKS, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> PRIMITIVEWORKS_1 = block(TechnologyModBlocks.PRIMITIVEWORKS_1, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> AWAKENING_CRYSTAL = block(TechnologyModBlocks.AWAKENING_CRYSTAL, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> DAOLIANGGRASS = doubleBlock(TechnologyModBlocks.DAOLIANGGRASS, TechnologyModTabs.TAB_TECHNOLOGYTAB);
	public static final RegistryObject<Item> DAOLIANGGRASS_ITEMS = REGISTRY.register("daolianggrass_items", () -> new DaolianggrassItemsItem());
	public static final RegistryObject<Item> DAOLIANGRICE = REGISTRY.register("daoliangrice", () -> new DaoliangriceItem());
	public static final RegistryObject<Item> GOOD_KARMA_BOTTLE = REGISTRY.register("good_karma_bottle", () -> new GoodKarmaBottleItem());//功德瓶
	public static final RegistryObject<Item> TIGER_SPAWN_EGG = REGISTRY.register("tiger_spawn_egg", () -> new ForgeSpawnEggItem(TechnologyModEntities.TIGER, -26368, -13312, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
	public static final RegistryObject<Item> TECHNOLOGYITEM = REGISTRY.register("technologyitem", () -> new TechnologyitemItem());
	public static final RegistryObject<Item> CREATIVEEVOLUTIONJADEBUTTERFLY = REGISTRY.register("creativeevolutionjadebutterfly", () -> new CreativeevolutionjadebutterflyItem());
	public static final RegistryObject<Item> INTOTHEWORLD = REGISTRY.register("intotheworld", () -> new IntotheworldItem());
	public static final RegistryObject<Item> HANDHELDGRINDINGSTONE = REGISTRY.register("handheldgrindingstone", () -> new HandheldgrindingstoneItem());
	public static final RegistryObject<Item> GRANITECRUSHEDSTONE_KUIJIA_ARMOR_ARMOR_HELMET = REGISTRY.register("granitecrushedstone_kuijia_armor_armor_helmet", () -> new Granitecrushedstone_kuijia_armorArmorItem.Helmet());
	public static final RegistryObject<Item> GRANITECRUSHEDSTONE_KUIJIA_ARMOR_ARMOR_CHESTPLATE = REGISTRY.register("granitecrushedstone_kuijia_armor_armor_chestplate", () -> new Granitecrushedstone_kuijia_armorArmorItem.Chestplate());
	public static final RegistryObject<Item> GRANITECRUSHEDSTONE_KUIJIA_ARMOR_ARMOR_LEGGINGS = REGISTRY.register("granitecrushedstone_kuijia_armor_armor_leggings", () -> new Granitecrushedstone_kuijia_armorArmorItem.Leggings());
	public static final RegistryObject<Item> GRANITECRUSHEDSTONE_KUIJIA_ARMOR_ARMOR_BOOTS = REGISTRY.register("granitecrushedstone_kuijia_armor_armor_boots", () -> new Granitecrushedstone_kuijia_armorArmorItem.Boots());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}

	private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
