package alchimiacraft.item;

import alchimiacraft.AlchimiaCraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemEnderJewel extends Item {
	public ItemEnderJewel() {
		super();
		this.setTextureName(AlchimiaCraft.resourceDomain+"ender_jewel");
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("ender_jewel");
	}
	
	@Override
	public boolean hasEffect(ItemStack itemstack) {
		return true;
	}
}