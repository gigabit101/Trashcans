package gigabit101.trashcans.block;

import gigabit101.trashcans.block.tile.TileTrashcanFluid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

public class BlockTrashcanFluid extends BlockMod
{
	
	public BlockTrashcanFluid() 
	{
		super();
		setUnlocalizedName("trashcanfluid");
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(player.getHeldItemMainhand() != null)
		{
			ItemStack stack = player.getHeldItemMainhand();
			if(FluidContainerRegistry.isFilledContainer(stack))
			{
				FluidStack fluid = FluidContainerRegistry.getFluidForFilledItem(stack);
				if(fluid != null)
				{
                    if (!player.inventory.addItemStackToInventory(FluidContainerRegistry.drainFluidContainer(stack))) 
                    {
                        player.dropPlayerItemWithRandomChoice(FluidContainerRegistry.drainFluidContainer(stack), false);
                    }
                    stack.stackSize--;
				}
			}
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileTrashcanFluid();
	}
}
