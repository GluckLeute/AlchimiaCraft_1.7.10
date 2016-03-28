package alchimiacraft.item;

import alchimiacraft.AlchimiaCraft;
import net.minecraft.item.Item;

public class ItemAlchimiaPowder extends Item {
	public ItemAlchimiaPowder() {
		super();
		this.setTextureName(AlchimiaCraft.resourceDomain+"alchimia_powder");
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("alchimia_powder");
	}
}	