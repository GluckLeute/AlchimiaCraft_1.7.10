package alchimiacraft.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import alchimiacraft.AlchimiaCraft;

public class ItemAlchimiaStoneSword extends ItemSword {
	public ItemAlchimiaStoneSword(int par1, ToolMaterial toolmaterial) {
		super(toolmaterial);
		this.setTextureName(AlchimiaCraft.resourceDomain+"alchimia_stone_sword");
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("alchimia_stone_sword");
		this.setFull3D();
		this.setMaxStackSize(1);
		this.setNoRepair();
	}
	
	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int i, boolean flag) {
    	if(entity.ticksExisted % 640 == 0 && itemStack.isItemDamaged() == true) {
    		itemStack.damageItem(-1, (EntityLivingBase)entity);
    	}  
    }
}