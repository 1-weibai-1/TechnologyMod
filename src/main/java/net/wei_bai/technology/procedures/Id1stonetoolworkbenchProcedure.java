package net.wei_bai.technology.procedures;

import net.minecraft.world.level.LevelAccessor;

public class Id1stonetoolworkbenchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ID0airProcedure.execute(world, x, y, z);
		ID1apinchofslagProcedure.execute(world, x, y, z);
		ID2amositefragmentsProcedure.execute(world, x, y, z);
		ID3coalminefragmentsProcedure.execute(world, x, y, z);
		ID4crushedstoneProcedure.execute(world, x, y, z);
		ID5crushedstoneknifeProcedure.execute(world, x, y, z);
	}
}
