package alchimiacraft.block;
 
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import alchimiacraft.AlchimiaCraft;
import alchimiacraft.init.AcConfig;
import alchimiacraft.init.AcItems;
 
public class BlockAlchimiaOre extends Block {
    public BlockAlchimiaOre() {
        super(Material.rock);
        this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
        this.setBlockName("alchimia_ore");
        this.setBlockTextureName(AlchimiaCraft.resourceDomain+"alchimia_ore");
        this.setHardness(3.0F);
        this.setResistance(5.0F);
        this.setStepSound(Block.soundTypeStone);
        this.setHarvestLevel("pickaxe", 1);
    }
    
    private Random random = new Random();
    
    //ドロップする経験値
    @Override
	public int getExpDrop(IBlockAccess iBlockAccess, int meta, int fortune) {
		return MathHelper.getRandomIntegerInRange(random, 2, 5);
	}
    
    //ドロップするアイテム
    @Override
    public Item getItemDropped(int meta, Random random, int fortune) {
        return AcItems.alchimia_powder;
    }
    
    //アイテムのドロップ数
    @Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
    	
    	int qDAO = AcConfig.quantityDroppedAlchimiaOre;
    	int qDWBAO = AcConfig.quantityDroppedWithBonusAlchimiaOre;
		
    	if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, random, fortune)) {
			int i = random.nextInt(fortune + 2) - 1;
			if (i < 0) {
				i = 0;
			}
            return qDAO * (i + qDWBAO); //Fortune付きのツールで採掘した際のドロップ数
        }
        else {
            return qDAO; //Fortune付きでないツールで採掘した際のドロップ数
        }
    }
}