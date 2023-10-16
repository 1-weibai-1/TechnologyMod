package net.wei_bai.technology.world.feature;


import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.wei_bai.technology.init.TechnologyModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> PRIMITIVE_ANCIENT_TREE =
            FeatureUtils.register("primitive_ancient_tree", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(TechnologyModBlocks.PRIMITIVEANCIENTLOG.get()),
                    new StraightTrunkPlacer(4, 4,2),
                    BlockStateProvider.simple(TechnologyModBlocks.PRIMITIVEANCIENTLEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0),4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> PRIMITIVE_ANCIENT_CHECKED =
            PlacementUtils.register("primitive_ancient_checked", PRIMITIVE_ANCIENT_TREE,
                    PlacementUtils.filteredByBlockSurvival(TechnologyModBlocks.PRIMITIVEANCIENTSAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> PRIMITIVE_ANCIENT_SPAWN =
            FeatureUtils.register("primitive_ancient_spawn",Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PRIMITIVE_ANCIENT_CHECKED,
                             0.5F)), PRIMITIVE_ANCIENT_CHECKED));
}
