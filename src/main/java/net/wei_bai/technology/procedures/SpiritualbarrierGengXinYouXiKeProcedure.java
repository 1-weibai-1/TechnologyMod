package net.wei_bai.technology.procedures;

import net.wei_bai.technology.init.TechnologyModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class SpiritualbarrierGengXinYouXiKeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y + 0, z))).getBlock() == TechnologyModBlocks.SPIRITUALBARRIER.get()) {
			if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == Blocks.BEDROCK || (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.BEDROCK
					|| (world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get() || (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get()
					|| (world.getBlockState(new BlockPos(x + 1, y + 1, z + 0))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get() || (world.getBlockState(new BlockPos(x - 1, y + 1, z + 0))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get()
					|| (world.getBlockState(new BlockPos(x + 1, y - 1, z + 0))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get() || (world.getBlockState(new BlockPos(x - 1, y - 1, z + 0))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get()
					|| (world.getBlockState(new BlockPos(x + 0, y - 1, z + 1))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get() || (world.getBlockState(new BlockPos(x + 0, y - 1, z - 1))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get()
					|| (world.getBlockState(new BlockPos(x + 0, y + 1, z + 1))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get() || (world.getBlockState(new BlockPos(x + 0, y + 1, z - 1))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get()
					|| (world.getBlockState(new BlockPos(x + 1, y + 0, z + 0))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get() || (world.getBlockState(new BlockPos(x - 1, y + 0, z + 0))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get()
					|| (world.getBlockState(new BlockPos(x + 1, y - 0, z + 0))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get() || (world.getBlockState(new BlockPos(x - 1, y - 0, z + 0))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get()
					|| (world.getBlockState(new BlockPos(x + 0, y - 0, z + 1))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get() || (world.getBlockState(new BlockPos(x + 0, y - 0, z - 1))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get()
					|| (world.getBlockState(new BlockPos(x + 0, y + 0, z + 1))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get()
					|| (world.getBlockState(new BlockPos(x + 0, y + 0, z - 1))).getBlock() == TechnologyModBlocks.ENCLOSUREBLOCK.get()) {
				world.setBlock(new BlockPos(x, y, z), TechnologyModBlocks.SPIRITUALBARRIER.get().defaultBlockState(), 3);
			} else if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == TechnologyModBlocks.SPIRITUALBARRIER.get() || (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == TechnologyModBlocks.SPIRITUALBARRIER.get()) {
				world.setBlock(new BlockPos(x, y + 1, z), TechnologyModBlocks.SPIRITUALBARRIER.get().defaultBlockState(), 3);
				world.setBlock(new BlockPos(x, y - 1, z), TechnologyModBlocks.SPIRITUALBARRIER.get().defaultBlockState(), 3);
			}
		}
	}
}
