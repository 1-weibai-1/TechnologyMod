package net.wei_bai.technology.procedures;

import net.minecraft.world.level.LevelAccessor;

public class GenxingstonetoolworkbenchProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		SlottickstonetoolworkbenchProcedure.execute(world, x, y, z);
		TickstonetoolworkbenchProcedure.execute(world, x, y, z);
		IDstonetoolworkbenchProcedure.execute(world, x, y, z);
		PEIFANGstonetoolworkbenchProcedure.execute(world, x, y, z);
	}
}
