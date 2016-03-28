package alchimiacraft.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import alchimiacraft.AlchimiaCraft;

public class ItemFireWand extends Item {
	public ItemFireWand() {
		super();
		this.setTextureName(AlchimiaCraft.resourceDomain+"fire_wand");
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("fire_wand");
		this.setMaxDamage(64);
		this.setFull3D();
		this.setMaxStackSize(1);
		this.setNoRepair();
	}
	
	@Override
	public boolean hasEffect(ItemStack itemstack) {
		if(itemstack.getItemDamageForDisplay() < 64){
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
		if(itemstack.getItemDamageForDisplay() < 64) {
			world.playSoundAtEntity(entityplayer, "mob.ghast.fireball", 1.0F, 2.0F / (itemRand.nextFloat() * 0.4F + 1.2F)  * 0.5F);

            if (!world.isRemote) {
            	 EntitySmallFireball entitysmallfireball = new EntitySmallFireball(world);
            	
            	Vec3 look = entityplayer.getLookVec();
                entitysmallfireball.setPosition(
                entityplayer.posX + look.xCoord * 2,
                entityplayer.posY + look.yCoord * 2 + 1,
                entityplayer.posZ + look.zCoord * 2);
                entitysmallfireball.accelerationX = look.xCoord * 0.1;
                entitysmallfireball.accelerationY = look.yCoord * 0.1;
                entitysmallfireball.accelerationZ = look.zCoord * 0.1;
                world.spawnEntityInWorld(entitysmallfireball);
            }
            itemstack.damageItem(1, entityplayer);
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