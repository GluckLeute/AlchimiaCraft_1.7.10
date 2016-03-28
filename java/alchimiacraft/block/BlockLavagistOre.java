package alchimiacraft.block;
 
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import alchimiacraft.AlchimiaCraft;
import alchimiacraft.init.AcItems;
 
public class BlockLavagistOre extends Block {
    public BlockLavagistOre() {
        super(Material.rock);
        this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
        this.setBlockName("lavagist_ore");
        this.setBlockTextureName(AlchimiaCraft.resourceDomain+"lavagist_ore");
        this.setHardness(4.0F);
        this.setResistance(5.0F);
        this.setLightLevel(1.0F);
        this.setStepSound(Block.soundTypeStone);
        this.setHarvestLevel("pickaxe", 2);
    }
    
    //ブロックを置いた時に呼ばれる
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack) {
	   world.scheduleBlockUpdate(x, y, z,this,this.tickRate(world) ) ; //次にブロック更新される時間を決める
	}
    
    @Override
    public int tickRate(World world) {
		return 10;
	}
    
    //ブロックが更新された時に呼ばれる
    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
    	
		int i = 0;
		
		//ブロックが水又は水流ブロックに面しているとi++される
		if(world.getBlock(x+1, y, z) == Blocks.water || world.getBlock(x+1, y, z) == Blocks.waterlily) {
			 i++;
		}
		if(world.getBlock(x-1, y, z) == Blocks.water || world.getBlock(x-1, y, z) == Blocks.waterlily) {
			 i++;
		}
		if(world.getBlock(x, y+1, z) == Blocks.water || world.getBlock(x, y+1, z) == Blocks.waterlily) {
			 i++;
		}
		if(world.getBlock(x, y-1, z) == Blocks.water || world.getBlock(x, y-1, z) == Blocks.waterlily) {
			 i++;
		}
		if(world.getBlock(x, y, z+1) == Blocks.water || world.getBlock(x, y, z+1) == Blocks.waterlily) {
			 i++;
		}
		if(world.getBlock(x, y, z-1) == Blocks.water || world.getBlock(x, y, z-1) == Blocks.waterlily) {
			 i++;
		}
		
		//3つ以上面していたら
		if(i >= 3) {
		   world.setBlockToAir(x, y, z);
		   world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
           
		   //アイテムと経験値をドロップする
		   EntityItem item = new EntityItem(world, x, y, z, new ItemStack(AcItems.lavagist_ingot));
           world.spawnEntityInWorld(item);
           EntityXPOrb exp = new EntityXPOrb(world, x, y, z, 7);
           world.spawnEntityInWorld(exp);
		}
		else {
			world.scheduleBlockUpdate(x, y, z,this,this.tickRate(world)); //�ｿｽﾄび趣ｿｽ�ｿｽﾉブ�ｿｽ�ｿｽ�ｿｽb�ｿｽN�ｿｽ�ｿｽ�ｿｽX�ｿｽV�ｿｽ�ｿｽ�ｿｽ骼橸ｿｽ�ｿｽ�ｿｽ�ｿｽ�ｿｽﾟゑｿｽ
		}
    }
}