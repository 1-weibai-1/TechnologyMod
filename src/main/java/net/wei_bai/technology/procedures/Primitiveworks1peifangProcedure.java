package net.wei_bai.technology.procedures;

import net.minecraft.world.level.LevelAccessor;

public class Primitiveworks1peifangProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Primitiveworks1peifang1Procedure.execute(world, x, y, z);
		Primitiveworks1peifang2Procedure.execute();
		Primitiveworks1peifang3Procedure.execute();
	}
}
