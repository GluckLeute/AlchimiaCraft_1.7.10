package alchimiacraft.fuel;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import alchimiacraft.init.AcBlocks;
import alchimiacraft.init.AcItems;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class AcFuels implements IFuelHandler { 
	/*”R—¿‚Ì“o˜^*/
	public static void registerFuels() {
		
	GameRegistry.registerFuelHandler(new AcFuels());
	}
	
	@Override
	public int getBurnTime(ItemStack itemstack) {
				
		if (itemstack.getItem() == AcItems.lavagist_ingot) return 20000;
		if (itemstack.getItem() == Item.getItemFromBlock(AcBlocks.lavagist_block)) return 200000;
				
		return 0;
	}
}