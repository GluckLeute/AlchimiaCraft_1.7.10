package alchimiacraft.item;

import alchimiacraft.AlchimiaCraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemLightningWand extends Item {
	public ItemLightningWand() {
		super();
		this.setTextureName(AlchimiaCraft.resourceDomain+"lightning_wand");
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("lightning_wand");
		this.setMaxDamage(64);
		this.setFull3D();
		this.setMaxStackSize(1);
		this.setNoRepair();
	}
	
	@Override
	public boolean hasEffect(ItemStack itemstack) {
		if(itemstack.getItemDamageForDisplay() < 56){
			 return true;
			}
			else {
				return false;
			}
	}
	
	@Override
	public boolean isBookEnchantable(ItemStack itemstack, ItemStack book) {
        return false;
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if(itemstack.getItemDamageForDisplay() < 56) {

		    float f = 1.0f;

		        float f1 = entityplayer.prevRotationPitch + (entityplayer.rotationPitch - entityplayer.prevRotationPitch) * f;
		        float f2 = entityplayer.prevRotationYaw + (entityplayer.rotationYaw - entityplayer.prevRotationYaw) * f;

		        double d = (double)f;

		        double d1 = entityplayer.prevPosX + (entityplayer.posX - entityplayer.prevPosX) * d;
		        double d2 = (entityplayer.prevPosY + (entityplayer.posY - entityplayer.prevPosY) * d + 1.6200000000000001d) - (double)entityplayer.yOffset;
		        double d3 = entityplayer.prevPosZ + (entityplayer.posZ - entityplayer.prevPosZ) * d;

		        Vec3 vec1 = Vec3.createVectorHelper(d1, d2, d3);

		        float f11 = MathHelper.cos(-f2 * 0.01745329f - 3.141593f);
		        float f12 = MathHelper.sin(-f2 * 0.01745329f - 3.141593f);
		        float f13 = -MathHelper.cos(-f1 * 0.01745329f);
		        float f14 = MathHelper.sin(-f1 * 0.01745329f);

		        float f15 = f12 * f13;
		        float f16 = f14;
		        float f17 = f11 * f13;

		        double d11 = 5000d;

		        Vec3 vec2 = vec1.addVector((double)f15 * d11, (double)f16 * d11, (double)f17 * d11);

		        MovingObjectPosition position = world.func_147447_a(vec1, vec2, false, true, true);

		        if(position != null && position.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {

		            int x = position.blockX;
		            int y = position.blockY;
		            int z = position.blockZ;

		            EntityLightningBolt lightning = new EntityLightningBolt(world, x, y+1, z);

		            world.spawnEntityInWorld(lightning);
		            
		            itemstack.damageItem(4, entityplayer);
            }
            return itemstack;
		}
		return itemstack;
}
	
	@Override
	public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        return itemstack;
    }
	
	@Override
    public int getMaxItemUseDuration(ItemStack itemstack) {
        return 72000;
    }
	
	@Override
    public EnumAction getItemUseAction(ItemStack itemstack) {
        return EnumAction.bow;
    }
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int i, boolean flag)
    {
    	if(entity.ticksExisted %  100 == 0 && itemstack.isItemDamaged() == true)
    	{
    		itemstack.damageItem(-1, (EntityLivingBase)entity);
    	}  
    }
}