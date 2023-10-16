package net.wei_bai.technology.world.feature.tree;


import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.wei_bai.technology.world.feature.ModConfiguredFeatures;

import javax.annotation.Nullable;
import java.util.Random;

public class PrimitiveAncientTreeGrower extends AbstractTreeGrower {
        @Nullable
        @Override
        protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random p_204307_, boolean p_204308_) {
                return ModConfiguredFeatures.PRIMITIVE_ANCIENT_TREE;
        }
}