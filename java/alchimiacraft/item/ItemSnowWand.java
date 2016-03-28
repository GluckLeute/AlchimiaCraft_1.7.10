package alchimiacraft.item;

import alchimiacraft.AlchimiaCraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSnowWand extends Item {
	public ItemSnowWand() {
		super();
		this.setTextureName(AlchimiaCraft.resourceDomain+"snow_wand");
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("snow_wand");
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
            world.playSoundAtEntity(entityplayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!world.isRemote) {
                world.spawnEntityInWorld(new EntitySnowball(world, entityplayer));
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