package net.wei_bai.technology.world.feature;


import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> PRIMITIVE_ANCIENT_PLACED =
            PlacementUtils.register("primitive_ancient_placed",
                    ModConfiguredFeatures.PRIMITIVE_ANCIENT_SPAWN, VegetationPlacements.treePlacement(
                            PlacementUtils.countExtra(3, 0.1f, 2)
                    ));
}
