package gigabit101.trashcans;

import gigabit101.trashcans.block.BlockTrashcan;
import gigabit101.trashcans.block.BlockTrashcanFluid;
import gigabit101.trashcans.block.tile.TileTrashcan;
import gigabit101.trashcans.block.tile.TileTrashcanFluid;
import gigabit101.trashcans.item.ItemTrashbag;
import gigabit101.trashcans.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(name = "Trashcans", modid = "Trashcans", version = "2.0.2", dependencies = "required-after:reborncore")
public class TrashCans 
{
	@Mod.Instance
	public static TrashCans INSTANCE;
	
	public static Block trashcan;
	public static Block trashcanFluid;
	
	public static Item trashbag;
	
	@SidedProxy(clientSide = "gigabit101.trashcans.proxy.ClientProxy", serverSide = "gigabit101.trashcans.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		trashcan = new BlockTrashcan();
		GameRegistry.registerBlock(trashcan, "trashcan");
		GameRegistry.registerTileEntity(TileTrashcan.class, "tiletrashcan");
		
		trashcanFluid = new BlockTrashcanFluid();
		GameRegistry.registerBlock(trashcanFluid, "trashcanfluid");
		GameRegistry.registerTileEntity(TileTrashcanFluid.class, "tiletrashcanfluid");
		
		trashbag = new ItemTrashbag();
		GameRegistry.registerItem(trashbag, "trashbag");
		
		GameRegistry.addRecipe(new ItemStack(trashcan), 
				"SSS", 
				"CHC", 
				"CCC", 
				'C', new ItemStack(Blocks.COBBLESTONE),
				'H', new ItemStack(Blocks.CHEST),
				'S', new ItemStack(Blocks.STONE));
		
		GameRegistry.addRecipe(new ItemStack(trashcanFluid), 
				"SSS", 
				"CHC", 
				"CCC", 
				'C', new ItemStack(Blocks.COBBLESTONE),
				'H', new ItemStack(Items.BUCKET),
				'S', new ItemStack(Blocks.STONE));
		
		GameRegistry.addRecipe(new ItemStack(trashbag), 
				"LXL", 
				"LCL", 
				"LLL", 
				'C', new ItemStack(trashcan), 
				'L', new ItemStack(Items.LEATHER));
		
		proxy.registerRenders();
		
		NetworkRegistry.INSTANCE.registerGuiHandler("Trashcans", new GuiHandler());
	}
}
