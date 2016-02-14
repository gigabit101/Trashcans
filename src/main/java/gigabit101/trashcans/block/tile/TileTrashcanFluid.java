package gigabit101.trashcans.block.tile;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.IFluidContainerItem;
import reborncore.common.util.Tank;

public class TileTrashcanFluid extends TileEntity implements IFluidContainerItem, ITickable
{
	public Tank tank = new Tank("trashtank", 1000, this);
	
	@Override
	public void update() 
	{
		if(!tank.isEmpty())
		{
			tank.setFluid(null);
		}
	}

	@Override
	public FluidStack getFluid(ItemStack container) 
	{
		return tank.getFluid();
	}

	@Override
	public int getCapacity(ItemStack container) 
	{
		return tank.getCapacity();
	}

	@Override
	public int fill(ItemStack container, FluidStack resource, boolean doFill) 
	{
		return tank.fill(resource, doFill);
	}

	@Override
	public FluidStack drain(ItemStack container, int maxDrain, boolean doDrain) 
	{
		return tank.drain(maxDrain, doDrain);
	}
}
