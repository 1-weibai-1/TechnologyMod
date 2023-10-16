package net.wei_bai.technology.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class Arrowprogressbar13Procedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (812.5 <= new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "Arrow_progress_bar")) {
			return true;
		}
		return false;
	}
}
