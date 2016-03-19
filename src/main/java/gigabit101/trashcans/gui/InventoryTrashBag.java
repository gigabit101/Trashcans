package gigabit101.trashcans.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import reborncore.common.util.Inventory;

public class InventoryTrashBag implements IInventory
{	
	public InventoryTrashBag(EntityPlayer player) {}

	@Override
	public String getName() 
	{
		return "invtrashbag";
	}

	@Override
	public boolean hasCustomName() 
	{
		return false;
	}

	@Override
	public ITextComponent getDisplayName() 
	{
		return null;
	}

	@Override
	public int getSizeInventory() 
	{
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int index) 
	{
		return null;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		return null;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) 
	{
		return null;
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return true;
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) 
	{
		return true;
	}

	@Override
	public int getField(int id) 
	{
		return 0;
	}

	@Override
	public int getFieldCount() 
	{
		return 0;
	}
	
	@Override
	public void setInventorySlotContents(int index, ItemStack stack){}
	
	@Override
	public void markDirty(){}
	
	@Override
	public void openInventory(EntityPlayer player){}

	@Override
	public void closeInventory(EntityPlayer player){}
	
	@Override
	public void setField(int id, int value){}
	
	@Override
	public void clear(){}
}
