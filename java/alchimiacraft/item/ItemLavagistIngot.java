package alchimiacraft.item;

import alchimiacraft.AlchimiaCraft;
import net.minecraft.item.Item;

public class ItemLavagistIngot extends Item {
	public ItemLavagistIngot() {
		super();
		this.setTextureName(AlchimiaCraft.resourceDomain+"lavagist_ingot");
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("lavagist_ingot");
	}
}	