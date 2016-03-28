package alchimiacraft.item;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import alchimiacraft.AlchimiaCraft;
import alchimiacraft.init.AcBlocks;
import alchimiacraft.init.AcItems;

public class ItemWand extends Item {
	public ItemWand() {
		super();
		this.setTextureName(AlchimiaCraft.resourceDomain+"wand");
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("wand");
		this.setFull3D();
		this.setMaxDamage(3);
		this.setMaxStackSize(1);
	}
	
	//このアイテムを使用した際に呼ばれる
	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int par1, float par2, float par3, float par4) {
		if (!entityplayer.canPlayerEdit(x, y, z, par1, itemstack)) {
            return false;
        }
		
            Block block = world.getBlock(x, y, z);
            if(!entityplayer.isSneaking()){ //スニーク状態でなければ
             if (par1 != 0 && (block == AcBlocks.alchimia_ore)) { //右クリックしたブロック
                    world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "random.break", 1.0F, itemRand.nextFloat() * 0.0F + 0.8F);

                    if (world.isRemote) {
                        return true;
                    }
                    else {
                    	//AlchimiaStoneをドロップさせる
                        world.setBlockToAir(x, y, z);
                        EntityItem item = new EntityItem(world, x, y, z, new ItemStack(AcItems.alchimia_stone));
                        world.spawnEntityInWorld(item);
                        itemstack.damageItem(1, entityplayer);
                        return true;
                    }
                }
             if (par1 != 0 && (block == Blocks.end_stone) && itemstack.getItemDamageForDisplay() < 1) { //�ｿｽN�ｿｽ�ｿｽ�ｿｽb�ｿｽN�ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽu�ｿｽ�ｿｽ�ｿｽb�ｿｽN
                 world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "mob.endermen.portal", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                 
                 if (world.isRemote) {
                     return true;
                 }
                 else {
                	 //EnderJewelOreを生成する
                     world.setBlock(x, y, z, AcBlocks.ender_jewel_ore);
                     --itemstack.stackSize; //このアイテムを消費する
                     return true;
                 }
             }
            }
			return false;
	}
}