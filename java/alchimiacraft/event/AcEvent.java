package alchimiacraft.event;

import alchimiacraft.entity.living.EntityWitchLivingDeathEvent;
import alchimiacraft.init.AcItems;
import alchimiacraft.item.ItemFalltherBoots;
import alchimiacraft.item.ItemLavagistSword;
import net.minecraftforge.common.MinecraftForge;

public class AcEvent { 
	/*�C�x���g�̓o�^*/
	public static void registerEvent() {
		
		//LavagistSword�̉��㏈��
		MinecraftForge.EVENT_BUS.register(new ItemLavagistSword(0, AcItems.LAVAGIST));
		//FalltherBoots�̗�������
		MinecraftForge.EVENT_BUS.register(new ItemFalltherBoots(0));
		//Witch�����S����
		MinecraftForge.EVENT_BUS.register(new EntityWitchLivingDeathEvent());
	}
}