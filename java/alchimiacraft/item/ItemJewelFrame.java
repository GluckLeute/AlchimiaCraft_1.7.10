package alchimiacraft.item;

import net.minecraft.item.Item;
import alchimiacraft.AlchimiaCraft;

public class ItemJewelFrame extends Item {
	public ItemJewelFrame() {
		super();
		this.setTextureName(AlchimiaCraft.resourceDomain+"jewel_frame");
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("jewel_frame");
	}
}