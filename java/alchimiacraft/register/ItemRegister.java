package alchimiacraft.register;

import alchimiacraft.init.AcItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRegister {
	
	/*アイテムの登録*/
	//ここでの並びがクリエイティブタブでの並びになる
	public static void registerItems() {
		
		//Material
		GameRegistry.registerItem(AcItems.alchimia_powder,"alchimia_powder");
		GameRegistry.registerItem(AcItems.jewel_frame,"jewel_frame");
		GameRegistry.registerItem(AcItems.ender_jewel,"ender_jewel");
		GameRegistry.registerItem(AcItems.alchimia_stone,"alchimia_stone");
		GameRegistry.registerItem(AcItems.iron_alchimia_stone,"iron_alchimia_stone");
		GameRegistry.registerItem(AcItems.diamond_alchimia_stone,"diamond_alchimia_stone");
		GameRegistry.registerItem(AcItems.lavagist_ingot,"lavagist_ingot");
		GameRegistry.registerItem(AcItems.witch_crystal,"witch_crystal");
		GameRegistry.registerItem(AcItems.exp_powder,"exp_powder");
		
		//Sword
		GameRegistry.registerItem(AcItems.alchimia_stone_sword,"alchimia_stone_sword");
		GameRegistry.registerItem(AcItems.iron_alchimia_stone_sword,"iron_alchimia_stone_sword");
		GameRegistry.registerItem(AcItems.diamond_alchimia_stone_sword,"diamond_alchimia_stone_sword");
		GameRegistry.registerItem(AcItems.explosion_sword,"explosion_sword");
		GameRegistry.registerItem(AcItems.lavagist_sword,"lavagist_sword");
		
		//Armor
		GameRegistry.registerItem(AcItems.fallther_boots,"fallther_boots");
		
		//Wand
		GameRegistry.registerItem(AcItems.wand,"wand");
		GameRegistry.registerItem(AcItems.ender_wand,"ender_wand");
		GameRegistry.registerItem(AcItems.snow_wand,"snow_wand");
		GameRegistry.registerItem(AcItems.fire_wand,"fire_wand");
		GameRegistry.registerItem(AcItems.ghast_wand,"ghast_wand");
		GameRegistry.registerItem(AcItems.lightning_wand,"lightning_wand");
		GameRegistry.registerItem(AcItems.explosion_wand,"explosion_wand");
		
		//Food
		GameRegistry.registerItem(AcItems.alchimia_stone_apple,"alchimia_stone_apple");
		GameRegistry.registerItem(AcItems.iron_alchimia_stone_apple,"iron_alchimia_stone_apple");
		GameRegistry.registerItem(AcItems.diamond_alchimia_stone_apple,"diamond_alchimia_stone_apple");
		GameRegistry.registerItem(AcItems.golden_alchimia_apple,"golden_alchimia_apple");
	}
}