package alchimiacraft.achievement;

import net.minecraft.item.ItemStack;
import alchimiacraft.init.AcItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class AcAchievementEvent {

	@SubscribeEvent
	public void PickUpItems(PlayerEvent.ItemPickupEvent player)
	{
		if(player.pickedUp.getEntityItem().isItemEqual(new ItemStack(AcItems.alchimia_powder)))
		{
			player.player.addStat(AcAchievement.getAlchimiaPowder, 1);
		}
		if(player.pickedUp.getEntityItem().isItemEqual(new ItemStack(AcItems.alchimia_stone)))
		{
			player.player.addStat(AcAchievement.getAlchimiaStone, 1);
		}
		if(player.pickedUp.getEntityItem().isItemEqual(new ItemStack(AcItems.ender_jewel)))
		{
			player.player.addStat(AcAchievement.getEnderJewel, 1);
		}
	}
	
	@SubscribeEvent
	public void CraftingItem(PlayerEvent.ItemCraftedEvent player)
	{
		if(player.crafting.getItem().equals(AcItems.wand))
		{
			player.player.addStat(AcAchievement.craftWand, 1);
		}
		if(player.crafting.getItem().equals(AcItems.iron_alchimia_stone))
		{
			player.player.addStat(AcAchievement.craftIronAlchimiaStone, 1);
		}
		if(player.crafting.getItem().equals(AcItems.diamond_alchimia_stone))
		{
			player.player.addStat(AcAchievement.craftDiamondAlchimiaStone, 1);
		}
		if(player.crafting.getItem().equals(AcItems.golden_alchimia_apple))
		{
			player.player.addStat(AcAchievement.craftGoldenAlchimiaApple, 1);
		}
	}
}