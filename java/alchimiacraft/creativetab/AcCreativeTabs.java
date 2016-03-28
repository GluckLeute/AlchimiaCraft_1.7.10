package alchimiacraft.creativetab;
 
import alchimiacraft.init.AcItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
 
public class AcCreativeTabs extends CreativeTabs {
 
	public AcCreativeTabs(String label) {
		super(label);
	}
	
	@Override
	public Item getTabIconItem() {
		return AcItems.alchimia_powder;
	}
 
}