package net.wei_bai.technology.procedures;

import net.minecraft.world.level.LevelAccessor;

public class Primitiveworks1GengXinYouXiKeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Primitiveworks1gengxinyouxike1Procedure.execute(world, x, y, z);
		Primitiveworks1gengxinyouxike2Procedure.execute(world, x, y, z);
		Primitiveworks1gengxinyouxike3Procedure.execute();
		Primitiveworks1gengxinyouxike4Procedure.execute();
	}
}
