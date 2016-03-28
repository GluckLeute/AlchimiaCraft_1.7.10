package alchimiacraft.item;

import alchimiacraft.AlchimiaCraft;
import net.minecraft.item.Item;

public class ItemAlchimiaStone extends Item {
	public ItemAlchimiaStone() {
		super();
		this.setTextureName(AlchimiaCraft.resourceDomain+"alchimia_stone");
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("alchimia_stone");
	}
}