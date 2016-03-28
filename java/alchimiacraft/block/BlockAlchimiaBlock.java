package alchimiacraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import alchimiacraft.AlchimiaCraft;
 
public class BlockAlchimiaBlock extends Block {
    public BlockAlchimiaBlock() {
        super(Material.rock);
        this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
        this.setBlockName("alchimia_powder_block");
        this.setBlockTextureName(AlchimiaCraft.resourceDomain+"alchimia_powder_block");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setStepSound(Block.soundTypeStone);
        this.setHarvestLevel("pickaxe", 0);
    }

}