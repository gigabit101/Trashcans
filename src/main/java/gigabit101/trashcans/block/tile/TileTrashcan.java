package gigabit101.trashcans.block.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import reborncore.common.util.Inventory;

public class TileTrashcan extends TileEntity implements IInventory, ITickable
{
	public Inventory inv = new Inventory(1, "trashcan", 64, this);
	
	@Override
	public void update() 
	{
		if(getStackInSlot(0) != null)
		{
			setInventorySlotContents(0, null);
		}
	}
	
	@Override
	public String getName() 
	{
		return inv.getName();
	}

	@Override
	public boolean hasCustomName() 
	{
		return inv.hasCustomName();
	}

	@Override
	public ITextComponent getDisplayName() 
	{
		return inv.getDisplayName();
	}

	@Override
	public int getSizeInventory() 
	{
		return inv.getSizeInventory();
	}

	@Override
	public ItemStack getStackInSlot(int index) 
	{
		return inv.getStackInSlot(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		return inv.decrStackSize(index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) 
	{
		return inv.removeStackFromSlot(index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		inv.setInventorySlotContents(index, stack);
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return inv.getInventoryStackLimit();
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) 
	{
		inv.openInventory(player);
	}

	@Override
	public void closeInventory(EntityPlayer player) 
	{
		inv.closeInventory(player);
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) 
	{
		return inv.isItemValidForSlot(index, stack);
	}

	@Override
	public int getField(int id) 
	{
		return inv.getField(id);
	}

	@Override
	public void setField(int id, int value) 
	{
		inv.setField(id, value);
	}

	@Override
	public int getFieldCount() 
	{
		return inv.getFieldCount();
	}

	@Override
	public void clear() 
	{
		inv.clear();
	}
}
