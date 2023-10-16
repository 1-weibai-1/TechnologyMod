package net.wei_bai.technology.procedures;

import net.wei_bai.technology.init.TechnologyModItems;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.Random;

@Mod.EventBusSubscriber
public class ObtainPlantFibreProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getPlayer().getUsedItemHand())
			return;
		execute(event, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.GRASS || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.FERN || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.DANDELION
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.POPPY || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.BLUE_ORCHID || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.ALLIUM
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.AZURE_BLUET || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.RED_TULIP
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.ORANGE_TULIP || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.WHITE_TULIP
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.PINK_TULIP || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.OXEYE_DAISY
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.CORNFLOWER || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.LILY_OF_THE_VALLEY
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.LILAC || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.TALL_GRASS || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.LARGE_FERN
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.VINE || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.GLOW_LICHEN || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.LILY_PAD)
				&& !(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false) && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
			world.destroyBlock(new BlockPos(x, y, z), false);
			if (15 >= Mth.nextDouble(new Random(), 1, 100)) {
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TechnologyModItems.PLANTFIBRE.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
			if (5 >= Mth.nextDouble(new Random(), 1, 100)) {
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TechnologyModItems.PLANTFIBRE.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TechnologyModItems.PLANTFIBRE.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
	}
}
