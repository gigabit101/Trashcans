package gigabit101.trashcans;

import gigabit101.trashcans.block.tile.TileTrashcan;
import gigabit101.trashcans.gui.ContainerTrashBag;
import gigabit101.trashcans.gui.ContainerTrashcan;
import gigabit101.trashcans.gui.GuiTrashBag;
import gigabit101.trashcans.gui.GuiTrashcan;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	public static int trashcanID = 0;
	public static int trashbagID = 1;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == trashcanID)
		{
			return new ContainerTrashcan((TileTrashcan) world.getTileEntity(new BlockPos(x,y,z)), player);
		}
		if(ID == trashbagID)
		{
			return new ContainerTrashBag(player);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if(ID == trashcanID)
		{
			return new GuiTrashcan(player, (TileTrashcan) world.getTileEntity(new BlockPos(x,y,z)));
		}
		if(ID == trashbagID)
		{
			return new GuiTrashBag(player);
		}
		return null;
	}
}
