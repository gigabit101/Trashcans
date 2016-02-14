package gigabit101.trashcans.item;

import gigabit101.trashcans.GuiHandler;
import gigabit101.trashcans.TrashCans;
import me.modmuss50.jsonDestroyer.api.ITexturedItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import reborncore.RebornCore;

public class ItemTrashbag extends Item implements ITexturedItem
{
	private String texture = "trashcans:items/trashbag";

	public ItemTrashbag() 
	{
		setUnlocalizedName("trashbag");
		setCreativeTab(CreativeTabs.tabMisc);
		setMaxStackSize(1);
		RebornCore.jsonDestroyer.registerObject(this);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) 
	{
		player.openGui(TrashCans.INSTANCE, GuiHandler.trashbagID, world, 0, 0, 0);
		return stack;
	}

	@Override
	public int getMaxMeta() 
	{
		return 1;
	}

	@Override
	public String getTextureName(int arg0) 
	{
		return texture;
	}
}
