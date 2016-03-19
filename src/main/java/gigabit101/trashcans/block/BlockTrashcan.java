package gigabit101.trashcans.block;

import gigabit101.trashcans.GuiHandler;
import gigabit101.trashcans.TrashCans;
import gigabit101.trashcans.block.tile.TileTrashcan;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTrashcan extends BlockMod
{ 
	private String top = "trashcans:blocks/trashtop";
	private String side = "trashcans:blocks/trashside";
	private String front = "trashcans:blocks/trashfront";
	private String bottom = "trashcans:blocks/trashbottom";
	
	public BlockTrashcan() 
	{
		super();
		setUnlocalizedName("trashcan");
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (!player.isSneaking())
		{
			player.openGui(TrashCans.INSTANCE, GuiHandler.trashcanID, world, pos.getX(), pos.getY(), pos.getZ());
		}
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileTrashcan();
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
