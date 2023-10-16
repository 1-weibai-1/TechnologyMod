
package net.wei_bai.technology.block;

import io.netty.buffer.Unpooled;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.wei_bai.technology.block.entity.Primitiveworks1BlockEntity;
import net.wei_bai.technology.init.TechnologyModBlocks;
import net.wei_bai.technology.procedures.Primitiveworks1FangZhiFangKuaiShiProcedure;
import net.wei_bai.technology.procedures.Primitiveworks1GengXinYouXiKeProcedure;
import net.wei_bai.technology.world.inventory.Primitiveworks1GUIMenu;

import java.util.List;
import java.util.Random;

public class Primitiveworks1Block extends Block
		implements

			EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

	public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

	public Primitiveworks1Block() {
		super(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(5f, 600f).noOcclusion()
				.isRedstoneConductor((bs, br, bp) -> false).noDrops());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}


	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {

		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(0, 0, 0, 16, 16, 16), box(3, 0, 0, 13, 22.5, 16), box(3, 0, 10.5, 13, 23, 16), box(3, 0, 13, 13, 23.5, 16),
					box(3, 0, 14.5, 13, 24, 16), box(3, 0, 0, 13, 23, 5.5), box(3, 0, 0, 13, 23.5, 3), box(3, 0, 0, 13, 24, 1.5));
			case NORTH -> Shapes.or(box(0, 0, 0, 16, 16, 16), box(3, 0, 0, 13, 22.5, 16), box(3, 0, 0, 13, 23, 5.5), box(3, 0, 0, 13, 23.5, 3),
					box(3, 0, 0, 13, 24, 1.5), box(3, 0, 10.5, 13, 23, 16), box(3, 0, 13, 13, 23.5, 16), box(3, 0, 14.5, 13, 24, 16));
			case EAST -> Shapes.or(box(0, 0, 0, 16, 16, 16), box(0, 0, 3, 16, 22.5, 13), box(10.5, 0, 3, 16, 23, 13), box(13, 0, 3, 16, 23.5, 13),
					box(14.5, 0, 3, 16, 24, 13), box(0, 0, 3, 5.5, 23, 13), box(0, 0, 3, 3, 23.5, 13), box(0, 0, 3, 1.5, 24, 13));
			case WEST -> Shapes.or(box(0, 0, 0, 16, 16, 16), box(0, 0, 3, 16, 22.5, 13), box(0, 0, 3, 5.5, 23, 13), box(0, 0, 3, 3, 23.5, 13),
					box(0, 0, 3, 1.5, 24, 13), box(10.5, 0, 3, 16, 23, 13), box(13, 0, 3, 16, 23.5, 13), box(14.5, 0, 3, 16, 24, 13));
		};
	}



	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 1);
		Primitiveworks1FangZhiFangKuaiShiProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, Random random) {
		super.tick(blockstate, world, pos, random);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();

		Primitiveworks1GengXinYouXiKeProcedure.execute(world, x, y, z);
		world.scheduleTick(pos, this, 1);
	}

	@Override
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		if (entity instanceof ServerPlayer player) {
			NetworkHooks.openGui(player, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return new TextComponent("Primitiveworks 1");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new Primitiveworks1GUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
				}
			}, pos);
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new Primitiveworks1BlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity == null ? false : blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof Primitiveworks1BlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof Primitiveworks1BlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		ItemBlockRenderTypes.setRenderLayer(TechnologyModBlocks.PRIMITIVEWORKS_1.get(), renderType -> renderType == RenderType.cutout());
	}
}
