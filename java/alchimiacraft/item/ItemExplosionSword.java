package alchimiacraft.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import alchimiacraft.AlchimiaCraft;

public class ItemExplosionSword extends ItemSword {
	public ItemExplosionSword(int par1, ToolMaterial EnumToolMaterial) {
		super(EnumToolMaterial);
		this.setTextureName(AlchimiaCraft.resourceDomain+"explosion_sword");
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("explosion_sword");
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
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {

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
        if(!entityplayer.isSneaking() &&itemstack.getItemDamageForDisplay() < 60) {

        if(position != null && position.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {

            int x = position.blockX;
            int y = position.blockY + 1;
            int z = position.blockZ;
                
            world.newExplosion(entityplayer, x, y, z, 2F, false, false);
            
            itemstack.damageItem(4, entityplayer);
            
      return itemstack;
     }
    	}
        else if(entityplayer.isSneaking() &&itemstack.getItemDamageForDisplay() < 56) {
        	if(position != null && position.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {

                int x = position.blockX;
                int y = position.blockY + 1;
                int z = position.blockZ;
                    
                world.newExplosion(entityplayer, x, y, z, 4F, true, false);
                
                itemstack.damageItem(8, entityplayer);
                
          return itemstack;    	
    	}
		return itemstack;
    	}
		return itemstack;
    }
	
	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int i, boolean flag) {
    	if(entity.ticksExisted % 200 == 0 && itemStack.isItemDamaged() == true) {
    		itemStack.damageItem(-1, (EntityLivingBase)entity);
    	}  
    }
}