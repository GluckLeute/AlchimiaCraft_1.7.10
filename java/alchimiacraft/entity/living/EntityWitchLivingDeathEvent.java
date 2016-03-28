package alchimiacraft.entity.living;

import alchimiacraft.init.AcItems;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntityWitchLivingDeathEvent {
	 
	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if(event.entityLiving.worldObj.isRemote) {
			return;
		}
		if(event.entityLiving instanceof EntityWitch) {
			if(event.entityLiving.worldObj.rand.nextInt(4) == 0) {
				event.entityLiving.dropItem(AcItems.witch_crystal, 1);
			}
			if(event.entityLiving.worldObj.rand.nextInt(6) == 0) {
				event.entityLiving.dropItem(AcItems.witch_crystal, 1);
					}
		}
	}
}