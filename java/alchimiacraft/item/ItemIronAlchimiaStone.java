package alchimiacraft.item;

import alchimiacraft.AlchimiaCraft;
import net.minecraft.item.Item;

public class ItemIronAlchimiaStone extends Item {
	public ItemIronAlchimiaStone() {
		super();
		this.setTextureName(AlchimiaCraft.resourceDomain+"iron_alchimia_stone");
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("iron_alchimia_stone");
	}
}