package alchimiacraft.item;

import alchimiacraft.AlchimiaCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWitchCrystal extends Item {
	public ItemWitchCrystal() {
		super();
		setTextureName(AlchimiaCraft.resourceDomain+"witch_crystal");
		setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		setUnlocalizedName("witch_crystal");
		maxStackSize = 16;
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack itemstack, World world, EntityPlayer player, int par4){
		int j = this.getMaxItemUseDuration(itemstack) - par4;
		
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;
     
            if ((double)f < 0.1D) {
                return;
            }
     
            if (f > 1.0F){
                f = 1.0F;
            }
            
            player.clearActivePotions();
            world.playSoundAtEntity(player, "portal.trigger", 1.0F, 5.0F / (itemRand.nextFloat() * 0.4F + 1.2F)  * 0.5F);
            
            if(!player.capabilities.isCreativeMode) {
            --itemstack.stackSize;
            }
		}
	
	@Override
    public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player) {
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
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
    	player.setItemInUse(itemstack, this.getMaxItemUseDuration(itemstack));
 
        return itemstack;
    }
}