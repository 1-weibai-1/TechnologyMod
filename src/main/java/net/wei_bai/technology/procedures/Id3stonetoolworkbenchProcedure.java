package net.wei_bai.technology.procedures;

import net.minecraft.world.level.LevelAccessor;

public class Id3stonetoolworkbenchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ID12gravelaxeProcedure.execute(world, x, y, z);
		ID13gravelpickProcedure.execute(world, x, y, z);
		ID14gravelpickheadProcedure.execute(world, x, y, z);
		ID15hangerProcedure.execute(world, x, y, z);
		ID16plantfibreProcedure.execute(world, x, y, z);
		ID17rockfragmentsProcedure.execute(world, x, y, z);
	}
}
