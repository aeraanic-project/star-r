package eu.ansquare.starr.blocks;

import eu.ansquare.starr.StarR;
import eu.ansquare.starr.superdude.SuperDudes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class TvBlock extends HorizontalFacingBlock {
	public TvBlock(Settings settings) {
		super(settings);
		setDefaultState(getDefaultState().with(FACING, Direction.WEST));

	}
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		Vec3d offset = state.getModelOffset(world, pos);
		return (switch (state.get(FACING)) {
			default -> createCuboidShape(0, 0, 7, 16, 14, 9);
			case NORTH -> createCuboidShape(0, 0, 7, 16, 14, 9);
			case EAST -> createCuboidShape(7, 0, 0, 9, 14, 16);
			case WEST -> createCuboidShape(7, 0, 0, 9, 14, 16);
		}).offset(offset.x, offset.y, offset.z);
	}
	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (!world.isClient) {
			SuperDudes.applyToPlayer(player, SuperDudes.TELEMAN);
		}

		return ActionResult.SUCCESS;
	}
	@Override
	public BlockState getPlacementState(ItemPlacementContext context) {
		return this.getDefaultState().with(FACING, context.getPlayerFacing().getOpposite());
	}
}
