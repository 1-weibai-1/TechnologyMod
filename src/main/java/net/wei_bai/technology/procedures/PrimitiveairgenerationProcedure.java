package net.wei_bai.technology.procedures;

import net.wei_bai.technology.init.TechnologyModBlocks;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.Map;

@Mod.EventBusSubscriber
public class PrimitiveairgenerationProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if ((new ResourceLocation("technology:primitiveplain").equals(world.getBiome(new BlockPos(x, y, z)).value().getRegistryName())
				|| new ResourceLocation("technology:primitive_forest").equals(world.getBiome(new BlockPos(x, y, z)).value().getRegistryName()))
				&& (Blocks.AIR == (world.getBlockState(new BlockPos(x, y, z))).getBlock() || Blocks.VOID_AIR == (world.getBlockState(new BlockPos(x, y, z))).getBlock() || Blocks.CAVE_AIR == (world.getBlockState(new BlockPos(x, y, z))).getBlock())) {
			{
				BlockPos _bp = new BlockPos(x, y, z);
				BlockState _bs = TechnologyModBlocks.PRIMITIVEANCIENTAIR.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
	}
}
