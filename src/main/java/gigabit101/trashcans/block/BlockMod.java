package gigabit101.trashcans.block;

import me.modmuss50.jsonDestroyer.api.ITexturedBlock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import reborncore.RebornCore;

public class BlockMod extends BlockContainer implements ITexturedBlock
{
	private String top = "trashcans:blocks/trashtop";
	private String side = "trashcans:blocks/trashside";
	private String front = "trashcans:blocks/trashfront";
	private String bottom = "trashcans:blocks/trashbottom";
	
	public BlockMod() 
	{
		super(Material.iron);
		setCreativeTab(CreativeTabs.tabMisc);
		setHardness(2.0F);
		RebornCore.jsonDestroyer.registerObject(this);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return null;
	}

	@Override
	public int amountOfStates() 
	{
		return 1;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) 
	{
		return EnumBlockRenderType.MODEL;
	}
	
//	@Override
//	public int getRenderType() 
//	{
//		return 3;
//	}

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
