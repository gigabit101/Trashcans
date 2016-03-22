package gigabit101.trashcans;

import gigabit101.trashcans.block.BlockTrashcan;
import gigabit101.trashcans.block.BlockTrashcanFluid;
import gigabit101.trashcans.block.tile.TileTrashcan;
import gigabit101.trashcans.block.tile.TileTrashcanFluid;
import gigabit101.trashcans.item.ItemTrashbag;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(name = "Trashcans", modid = "Trashcans", version = "2.0.1", dependencies = "required-after:reborncore")
public class TrashCans 
{
	@Mod.Instance
	public static TrashCans INSTANCE;
	
	public static Block trashcan;
	public static Block trashcanFluid;
	
	public static Item trashbag;
	
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
				'C', new ItemStack(Blocks.cobblestone), 
				'H', new ItemStack(Blocks.chest),
				'S', new ItemStack(Blocks.stone));
		
		GameRegistry.addRecipe(new ItemStack(trashcanFluid), 
				"SSS", 
				"CHC", 
				"CCC", 
				'C', new ItemStack(Blocks.cobblestone), 
				'H', new ItemStack(Items.bucket),
				'S', new ItemStack(Blocks.stone));
		
		GameRegistry.addRecipe(new ItemStack(trashbag), 
				"LXL", 
				"LCL", 
				"LLL", 
				'C', new ItemStack(trashcan), 
				'L', new ItemStack(Items.leather));
		
		NetworkRegistry.INSTANCE.registerGuiHandler("Trashcans", new GuiHandler());
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(trashcan), 0, new ModelResourceLocation("trashcans:trashcan", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(trashcanFluid), 0, new ModelResourceLocation("trashcans:trashcanfluid", "inventory"));
	}
}
