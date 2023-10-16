
package net.wei_bai.technology.world.biome;

import net.wei_bai.technology.world.features.treedecorators.PrimitiveForestTrunkDecorator;
import net.wei_bai.technology.world.features.treedecorators.PrimitiveForestLeaveDecorator;
import net.wei_bai.technology.init.TechnologyModBlocks;

import net.minecraft.world.level.levelgen.placement.SurfaceWaterDepthFilter;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.placement.NoiseThresholdCountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class PrimitiveForestBiome {
	public static final List<Climate.ParameterPoint> PARAMETER_POINTS = List.of(
			new Climate.ParameterPoint(Climate.Parameter.span(-0.4f, 0.4f), Climate.Parameter.span(-0.4f, 0.4f), Climate.Parameter.span(0.14f, 0.9400000000000001f), Climate.Parameter.span(0.4999999999999999f, 1.2999999999999998f),
					Climate.Parameter.point(0.0f), Climate.Parameter.span(-0.32100402367800973f, 0.4789959763219903f), 0),
			new Climate.ParameterPoint(Climate.Parameter.span(-0.4f, 0.4f), Climate.Parameter.span(-0.4f, 0.4f), Climate.Parameter.span(0.14f, 0.9400000000000001f), Climate.Parameter.span(0.4999999999999999f, 1.2999999999999998f),
					Climate.Parameter.point(1.0f), Climate.Parameter.span(-0.32100402367800973f, 0.4789959763219903f), 0));

	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-3342337).waterColor(-7604737).waterFogColor(-3342337).skyColor(-3342337).foliageColorOverride(-15401100).grassColorOverride(-10813589).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION,
				PlacementUtils.register("technology:tree_primitive_forest",
						FeatureUtils.register("technology:tree_primitive_forest", Feature.TREE,
								new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(TechnologyModBlocks.PRIMITIVEANCIENTLOG.get().defaultBlockState()), new StraightTrunkPlacer(7, 2, 0),
										BlockStateProvider.simple(TechnologyModBlocks.PRIMITIVEANCIENTLEAVES.get().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1))
										.decorators(ImmutableList.of(PrimitiveForestLeaveDecorator.INSTANCE, PrimitiveForestTrunkDecorator.INSTANCE)).build()),
						List.of(CountPlacement.of(6), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("technology:grass_primitive_forest", VegetationFeatures.PATCH_GRASS,
				List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
		biomeGenerationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, PlacementUtils.register("technology:flower_primitive_forest", VegetationFeatures.FLOWER_DEFAULT,
				List.of(CountPlacement.of(5), RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));
		BiomeDefaultFeatures.addSavannaGrass(biomeGenerationSettings);
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).biomeCategory(Biome.BiomeCategory.NONE).temperature(0.5f).downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build())
				.generationSettings(biomeGenerationSettings.build()).build();
	}
}
