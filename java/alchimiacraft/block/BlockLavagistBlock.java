package alchimiacraft.block;

import alchimiacraft.AlchimiaCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLavagistBlock extends Block {
    public BlockLavagistBlock() {
        super(Material.rock);
        setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
        setBlockName("lavagist_block");
        setBlockTextureName(AlchimiaCraft.resourceDomain+"lavagist_block");
        setHardness(5.0F);
        setResistance(10.0F);
        setLightLevel(1.0F);
        setStepSound(Block.soundTypeStone);
        setHarvestLevel("pickaxe", 0);
    }
}