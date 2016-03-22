package gigabit101.trashcans.proxy;

import gigabit101.trashcans.TrashCans;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenders()
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(TrashCans.trashcan), 0, new ModelResourceLocation("trashcans:trashcan", "inventory"));
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(TrashCans.trashcanFluid), 0, new ModelResourceLocation("trashcans:trashcanfluid", "inventory"));
	}
}
