package alchimiacraft.event;

import alchimiacraft.entity.living.EntityWitchLivingDeathEvent;
import alchimiacraft.init.AcItems;
import alchimiacraft.item.ItemFalltherBoots;
import alchimiacraft.item.ItemLavagistSword;
import net.minecraftforge.common.MinecraftForge;

public class AcEvent { 
	/*イベントの登録*/
	public static void registerEvent() {
		
		//LavagistSwordの炎上処理
		MinecraftForge.EVENT_BUS.register(new ItemLavagistSword(0, AcItems.LAVAGIST));
		//FalltherBootsの落下処理
		MinecraftForge.EVENT_BUS.register(new ItemFalltherBoots(0));
		//Witchが死亡処理
		MinecraftForge.EVENT_BUS.register(new EntityWitchLivingDeathEvent());
	}
}