package alchimiacraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import alchimiacraft.AlchimiaCraft;
import alchimiacraft.init.AcConfig;
import alchimiacraft.init.AcItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockExpConverter extends Block {
	@SideOnly(Side.CLIENT)
	private IIcon TopIcon;
	@SideOnly(Side.CLIENT)
	private IIcon SideIcon;
	@SideOnly(Side.CLIENT)
	private IIcon BottomIcon;

	public BlockExpConverter() {
		super(Material.rock);
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setBlockName("exp_converter");
		this.setHardness(3.0F);
		this.setResistance(16.0F);
		this.setStepSound(Block.soundTypeStone);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int side, float posX, float posY, float posZ) {

		int cREC = AcConfig.conversionRateExpConverter;

		boolean c = player.capabilities.isCreativeMode;
		int exp = player.experienceLevel;
		
		if(cREC <= 0) {
			cREC = 1;
		}

		if (c || player.inventory.hasItem(AcItems.alchimia_powder)) {
			if (c || exp >= cREC) {
				player.inventory.addItemStackToInventory(new ItemStack(AcItems.exp_powder));
				world.playSoundAtEntity(player, "random.pop", 0.4F, 1.8F);

				if (!c) {
					player.inventory.consumeInventoryItem(AcItems.alchimia_powder);
					player.addExperienceLevel(-cREC);
				}
				return true;
			}
		}

		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister IconRegister) {
		this.TopIcon = IconRegister.registerIcon(AlchimiaCraft.resourceDomain+"exp_converter_top");
		this.BottomIcon = IconRegister.registerIcon(AlchimiaCraft.resourceDomain+"exp_converter_bottom");
		this.SideIcon = IconRegister.registerIcon(AlchimiaCraft.resourceDomain+"exp_converter_side");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		if (par1 == 1) {
			return TopIcon;
		} 
		else if (par1 == 0) {
			return BottomIcon;
		} 
		else {
			return SideIcon;
		}

	}
}