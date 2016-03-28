package alchimiacraft.block;
 
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import alchimiacraft.AlchimiaCraft;
import alchimiacraft.init.AcConfig;
import alchimiacraft.init.AcItems;
 
public class BlockEnderJewelOre extends Block {
	
    public BlockEnderJewelOre() {
        super(Material.rock);
        this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
        this.setBlockName("ender_jewel_ore");
        this.setBlockTextureName(AlchimiaCraft.resourceDomain+"ender_jewel_ore");
        this.setHardness(3.0F);
        this.setResistance(15.0F);
        this.setStepSound(Block.soundTypeStone);
        this.setHarvestLevel("pickaxe", 3);
    }
    
    //Entityがこのブロックを破壊できるか
    @Override
    public boolean canEntityDestroy(IBlockAccess iBlockAccess, int x, int y, int z, Entity entity) {
		return false; //�できない
    }
    
    //このブロックのドロップ処理
    //基本的にBlockAlchimiaOreと同じ
    private Random random = new Random();
    
   	@Override
   	public int getExpDrop(IBlockAccess iBlockAccess, int meta, int fortune) {
   		return MathHelper.getRandomIntegerInRange(random, 3, 7);
   	}
   	
    @Override
	public Item getItemDropped(int meta, Random random, int fortune) {
		return AcItems.ender_jewel;
	}
    
    @Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
    	
    	int qDEJO = AcConfig.quantityDroppedEnderJewelOre;
    	int qDWBEJO = AcConfig.quantityDroppedWithBonusEnderJewelOre;
		
    	if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, random, fortune)) {
			int i = random.nextInt(fortune + 2) - 1;
			if (i < 0) {
				i = 0;
			}
            return qDEJO * (i + qDWBEJO);
        }
        else {
            return qDEJO;
        }
    }
}