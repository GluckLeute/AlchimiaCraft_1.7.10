package alchimiacraft.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import alchimiacraft.AlchimiaCraft;
import alchimiacraft.init.AcItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ItemLavagistSword extends ItemSword {
	public ItemLavagistSword(int par1, ToolMaterial ToolMaterial) {
		super(ToolMaterial);
		setTextureName(AlchimiaCraft.resourceDomain+"lavagist_sword");
		setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		setUnlocalizedName("lavagist_sword");
		setFull3D();
		setMaxStackSize(1);
		setNoRepair();
	}
	
	//Entityを殴った際に呼ばれる
	@Override
	public boolean hitEntity(ItemStack itemStack, EntityLivingBase living_hit, EntityLivingBase living_used) {
		 super.hitEntity(itemStack, living_hit, living_used);
	    	living_hit.setFire(3);
	        return true;
    }
	
	//アイテムを右クリックした際に呼ばれる
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if(itemstack.getItemDamageForDisplay() < 59) {
			if(!player.isBurning()) {
			player.setFire(5);
			itemstack.damageItem(5, player);
			}
		}
		return itemstack;
	}
	
	@Override
	public  void onUpdate(ItemStack itemStack, World world, Entity entity,int i, boolean flag) {
		if(entity.isBurning()) {
			if(entity.ticksExisted % 320 == 0 && itemStack.isItemDamaged() == true) {
    		itemStack.damageItem(-2, (EntityLivingBase)entity);
    	}
    	
		//プレイヤーが炎上していたらポーションエフェクトを付与する
    	if(entity.isBurning() && flag) {
    		((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.damageBoost.id, 5*20, 1));
    	}
		}
	}
	
	/*
	 * ∧＿∧
	 *（　´∀｀）＜ ぬるぽ
	 */
	/**
	@SubscribeEvent
	public void onLivingAttackEvent (LivingAttackEvent event) {
		
		if(event.entityLiving.worldObj.isRemote) {
			return;
		}
		if(event.entityLiving instanceof EntityPlayer) {
			if(event.entityLiving.getAITarget() != null && event.entityLiving.getAITarget().getHeldItem().getItem() == AcItems.lavagist_sword) {
			event.entityLiving.setFire(5);
		}
			else {
				return ;
			}
		}
		else if(event.entityLiving.getAITarget() != null && event.entityLiving.getAITarget().getHeldItem().getItem() == AcItems.lavagist_sword) {
			event.entityLiving.setFire(5);
		}
	}
	**/
	
	//このアイテムを持ったEntityLivingが炎上していたらポーションエフェクトを付与する
	@SubscribeEvent
	public void onLivingHurtEvent (LivingHurtEvent event) {
		
		if(event.entityLiving.worldObj.isRemote) {
			return;
		}
		if(event.entityLiving.getHeldItem() != null && event.entityLiving.getHeldItem().getItem() == AcItems.lavagist_sword) {
			if(event.entityLiving.isBurning()) {
			event.entityLiving.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 5*20, 1));
			}
			}
		}
}