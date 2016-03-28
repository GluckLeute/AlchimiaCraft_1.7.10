package alchimiacraft.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import alchimiacraft.AlchimiaCraft;

public class ItemGhastWand extends Item {
	public ItemGhastWand() {
		super();
		this.setTextureName(AlchimiaCraft.resourceDomain+"ghast_wand");
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("ghast_wand");
		this.setMaxDamage(64);
		this.setFull3D();
		this.setMaxStackSize(1);
		this.setNoRepair();
	}
	
	@Override
	public boolean hasEffect(ItemStack itemstack) {
		if(itemstack.getItemDamageForDisplay() < 60){
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
		if(itemstack.getItemDamageForDisplay() < 60) {
			world.playSoundAtEntity(entityplayer, "mob.ghast.charge", 1.0F, 3.0F / (itemRand.nextFloat() * 0.4F + 1.2F)  * 0.5F);

            if (!world.isRemote) {
            	EntityLargeFireball entitylargefireball = new EntityLargeFireball(world);
            	
            	Vec3 look = entityplayer.getLookVec();
                entitylargefireball.setPosition(
                entityplayer.posX + look.xCoord * 2,
                entityplayer.posY + look.yCoord * 2 + 1,
                entityplayer.posZ + look.zCoord * 2);
                entitylargefireball.accelerationX = look.xCoord * 0.1;
                entitylargefireball.accelerationY = look.yCoord * 0.1;
                entitylargefireball.accelerationZ = look.zCoord * 0.1;
                world.spawnEntityInWorld(entitylargefireball);
            }
            itemstack.damageItem(4, entityplayer);
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