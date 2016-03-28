package alchimiacraft.item;

import alchimiacraft.AlchimiaCraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemIronAlchimiaStoneSword extends ItemSword {
	public ItemIronAlchimiaStoneSword(int par1, ToolMaterial toolmaterial) {
		super(toolmaterial);
		this.setTextureName(AlchimiaCraft.resourceDomain+"iron_alchimia_stone_sword");
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("iron_alchimia_stone_sword");
		this.setFull3D();
		this.setMaxStackSize(1);
		this.setNoRepair();
	}
	
	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int i, boolean flag) {
    	if(entity.ticksExisted % 320 == 0 && itemStack.isItemDamaged() == true) {
    		itemStack.damageItem(-1, (EntityLivingBase)entity);
    	}  
    }
}