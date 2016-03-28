package alchimiacraft.item;
 
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import alchimiacraft.AlchimiaCraft;
import alchimiacraft.init.AcItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
 
public class ItemFalltherBoots extends ItemArmor {
 
	public ItemFalltherBoots(int type) {
		super(AcItems.FALLTHER, 0, type);
		setTextureName(AlchimiaCraft.resourceDomain+"fallther_boots");
		setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		setUnlocalizedName("fallther_boots");
	}
	
 
	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type) {
		if (this.armorType == 2) {
			return "ac:textures/models/armor/fallther_layer_2.png";
		}
		return "ac:textures/models/armor/fallther_layer_1.png";
	}
	
	@SubscribeEvent
	public void LivingFallEvent(LivingFallEvent event) {

	      if(event.entityLiving.getEquipmentInSlot(1) != null && event.entityLiving.getEquipmentInSlot(1	).getItem() == AcItems.fallther_boots) {
	         event.distance = 0;
	      }
	}
}