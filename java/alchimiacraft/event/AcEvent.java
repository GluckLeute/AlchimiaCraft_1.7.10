package alchimiacraft.event;

import alchimiacraft.entity.living.EntityWitchLivingDeathEvent;
import alchimiacraft.init.AcItems;
import alchimiacraft.item.ItemFalltherBoots;
import alchimiacraft.item.ItemLavagistSword;
import net.minecraftforge.common.MinecraftForge;

public class AcEvent { 
	/*ƒCƒxƒ“ƒg‚Ì“o˜^*/
	public static void registerEvent() {
		
		//LavagistSword‚Ì‰Šãˆ—
		MinecraftForge.EVENT_BUS.register(new ItemLavagistSword(0, AcItems.LAVAGIST));
		//FalltherBoots‚Ì—‰ºˆ—
		MinecraftForge.EVENT_BUS.register(new ItemFalltherBoots(0));
		//Witch‚ª€–Sˆ—
		MinecraftForge.EVENT_BUS.register(new EntityWitchLivingDeathEvent());
	}
}