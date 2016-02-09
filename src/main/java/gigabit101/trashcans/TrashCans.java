package gigabit101.trashcans;

import gigabit101.trashcans.block.BlockTrashcan;
import gigabit101.trashcans.block.TileTrashcan;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(name = "Trashcans", modid = "Trashcans", version = "1.0.0", dependencies = "required-after:reborncore")
public class TrashCans 
{
	@Mod.Instance
	public static TrashCans INSTANCE;
	
	public static Block trashcan;
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		trashcan = new BlockTrashcan();
		GameRegistry.registerBlock(trashcan, "trashcan");
		GameRegistry.registerTileEntity(TileTrashcan.class, "tiletrashcan");
		
		GameRegistry.addRecipe(new ItemStack(trashcan), 
				"SSS", 
				"CHC", 
				"CCC", 
				'C', new ItemStack(Blocks.cobblestone), 
				'H', new ItemStack(Blocks.chest),
				'S', new ItemStack(Blocks.stone));
		
		NetworkRegistry.INSTANCE.registerGuiHandler("Trashcans", new GuiHandler());
	}
}
