package gigabit101.trashcans.block;

import gigabit101.trashcans.block.tile.TileTrashcanFluid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;

public class BlockTrashcanFluid extends BlockMod
{ 
	private String top = "trashcans:blocks/trashtop";
	private String side = "trashcans:blocks/trashside";
	private String front = "trashcans:blocks/trashfront";
	private String bottom = "trashcans:blocks/trashbottom";
	
	public BlockTrashcanFluid() 
	{
		super();
		setUnlocalizedName("trashcanfluid");
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) 
	{
		if(player.getCurrentEquippedItem() != null)
		{
			ItemStack stack = player.getCurrentEquippedItem();
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

	@Override
	public String getTextureNameFromState(IBlockState arg0, EnumFacing arg1)
	{
		if(arg1 == arg1.DOWN)
			return bottom;
		if(arg1 == arg1.UP)
			return top;
		else 
			return front;
	}
}
