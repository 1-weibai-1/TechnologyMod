package net.wei_bai.technology.procedures;

import net.minecraft.world.level.LevelAccessor;

public class Primitiveworks1peifang1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Primitiveworks1gaotouProcedure.execute(world, x, y, z);
		Primitiveworks1rockfragmentsProcedure.execute(world, x, y, z);
		Primitiveworks1sharprockfragmentsProcedure.execute(world, x, y, z);
		Primitiveworks1crushedstoneknifeProcedure.execute(world, x, y, z);
	}
}
