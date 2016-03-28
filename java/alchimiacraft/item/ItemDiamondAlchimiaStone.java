package alchimiacraft.item;

import alchimiacraft.AlchimiaCraft;
import net.minecraft.item.Item;

public class ItemDiamondAlchimiaStone extends Item {
	public ItemDiamondAlchimiaStone() {
		super();
		this.setTextureName(AlchimiaCraft.resourceDomain+"diamond_alchimia_stone");
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("diamond_alchimia_stone");
	}
}