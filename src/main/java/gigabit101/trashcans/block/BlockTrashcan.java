package gigabit101.trashcans.block;

import gigabit101.trashcans.GuiHandler;
import gigabit101.trashcans.TrashCans;
import me.modmuss50.jsonDestroyer.api.ITexturedBlock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import reborncore.RebornCore;

public class BlockTrashcan extends BlockContainer implements ITexturedBlock
{ 
	private String top = "trashcans:blocks/trashtop";
	private String side = "trashcans:blocks/trashside";
	private String front = "trashcans:blocks/trashfront";
	private String bottom = "trashcans:blocks/trashbottom";
	
	public BlockTrashcan() 
	{
		super(Material.iron);
		setUnlocalizedName("trashcan");
		setCreativeTab(CreativeTabs.tabMisc);
		setHardness(2.0F);
		RebornCore.jsonDestroyer.registerObject(this);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!player.isSneaking())
		{
			player.openGui(TrashCans.INSTANCE, GuiHandler.trashcanID, world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileTrashcan();
	}

	@Override
	public int amountOfStates() 
	{
		return 1;
	}
	
	@Override
	public int getRenderType() 
	{
		return 3;
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
