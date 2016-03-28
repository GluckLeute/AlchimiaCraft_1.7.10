package alchimiacraft.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import alchimiacraft.AlchimiaCraft;
import alchimiacraft.init.AcBlocks;
import alchimiacraft.init.AcConfig;

public class ItemExpPowder extends Item {
	public ItemExpPowder() {
		super();
		setTextureName(AlchimiaCraft.resourceDomain+"exp_powder");
		setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		setUnlocalizedName("exp_powder");
	}
	
	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float posX, float posY, float posZ) {
		int cREC = AcConfig.conversionRateExpConverter;
		
		if(cREC <= 0) {
			cREC = 2;
		}
		
		if (!player.canPlayerEdit(x, y, z, side, itemstack)) {
            return false;
        }
		
            Block block = world.getBlock(x, y, z);

             if (side != 0 && (block == AcBlocks.exp_converter)) {
            	 world.playSoundAtEntity(player, "random.ord", 0.1F, 0.5F);
            	 
                    if (world.isRemote) {
                        return true;
                    }
                    else {
                        player.addExperienceLevel(--cREC);
                        --itemstack.stackSize;
                        return true;
                    }
                }
			return true;
    }
}