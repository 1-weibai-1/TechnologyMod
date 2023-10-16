package net.wei_bai.technology.procedures;

import net.minecraft.world.level.LevelAccessor;

public class PEIFANGstonetoolworkbenchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		PFgravelaxeProcedure.execute(world, x, y, z);
		PFroughlongbowhandleProcedure.execute(world, x, y, z);
		PFroughlongbowProcedure.execute(world, x, y, z);
		PFAAAAAAProcedure.execute(world, x, y, z);
		PFstoneknifeProcedure.execute(world, x, y, z);
		PFgravelpickProcedure.execute(world, x, y, z);
	}
}
