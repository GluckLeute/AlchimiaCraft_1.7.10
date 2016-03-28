package alchimiacraft.init;

import alchimiacraft.item.*;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class AcItems { 
	
	/*アイテムの変数を宣言*/
	//Material
	public static Item alchimia_powder;
	public static Item jewel_frame;
	public static Item ender_jewel;
	public static Item alchimia_stone;
	public static Item iron_alchimia_stone;
	public static Item diamond_alchimia_stone;
	public static Item lavagist_ingot;
	public static Item witch_crystal;
	public static Item exp_powder;
	
	//Sword
	public static Item alchimia_stone_sword;
	public static Item iron_alchimia_stone_sword;
	public static Item diamond_alchimia_stone_sword;
	public static Item explosion_sword;
	public static Item lavagist_sword;
	
	//Armor
	public static Item fallther_boots;
	
	//Wand
	public static Item wand;
	public static Item ender_wand;
	public static Item snow_wand;
	public static Item fire_wand;
	public static Item ghast_wand;
	public static Item lightning_wand;
	public static Item explosion_wand;
	
	//Food
	public static Item alchimia_stone_apple;
	public static Item iron_alchimia_stone_apple;
	public static Item diamond_alchimia_stone_apple;
	public static Item golden_alchimia_apple;
	
	/*素材の性能*/
	//ToolMaterial
	public static final Item.ToolMaterial ALCHIMIASTONE = EnumHelper.addToolMaterial("ALCHIMIASTONE", 1,  32,  4.0F, 1.0F,  5);
	public static final Item.ToolMaterial IRONALCHIMIASTONE = EnumHelper.addToolMaterial("IRONALCHIMIASTONE", 2,  64,  6.0F, 2.0F, 14);
	public static final Item.ToolMaterial DIAMONDALCHIMIASTONE = EnumHelper.addToolMaterial("DIAMONDALCHIMIASTONE", 3, 64,  8.0F, 3.0F, 10);
	public static final Item.ToolMaterial LAVAGIST = EnumHelper.addToolMaterial("LAVAGIST", 3, 64,  4.0F, 1.0F, 15);
	
	//ArmorMaterial
	public static final ArmorMaterial FALLTHER = EnumHelper.addArmorMaterial("FALLTHER", 15, new int[] { 0, 0, 0, 2 }, 8);
	
	/*アイテムのインスタンスを生成*/
	public static void setItems() {
		
		//Material
		alchimia_powder = new ItemAlchimiaPowder();
		jewel_frame = new ItemJewelFrame();
		ender_jewel = new ItemEnderJewel();
		alchimia_stone = new ItemAlchimiaStone();
		iron_alchimia_stone = new ItemIronAlchimiaStone();
		diamond_alchimia_stone = new ItemDiamondAlchimiaStone();
		lavagist_ingot = new ItemLavagistIngot();
		witch_crystal = new ItemWitchCrystal();
		exp_powder = new ItemExpPowder();
		
		//Sword
		alchimia_stone_sword = new ItemAlchimiaStoneSword(0, ALCHIMIASTONE);
		iron_alchimia_stone_sword = new ItemIronAlchimiaStoneSword(0,IRONALCHIMIASTONE);
		diamond_alchimia_stone_sword = new ItemDiamondAlchimiaStoneSword(0, DIAMONDALCHIMIASTONE);
		explosion_sword = new ItemExplosionSword(0, DIAMONDALCHIMIASTONE);
		lavagist_sword = new ItemLavagistSword(0, LAVAGIST);
		
		//Armor
		fallther_boots = new ItemFalltherBoots(3);
		
		//Wand
		wand = new ItemWand();
		ender_wand = new ItemEnderWand();
		snow_wand = new ItemSnowWand();
		fire_wand = new ItemFireWand();
		ghast_wand = new ItemGhastWand();
		lightning_wand = new ItemLightningWand();
		explosion_wand = new ItemExplosionWand();
		
		//Food
		alchimia_stone_apple = new ItemAlchimiaStoneApple(0, false);
		iron_alchimia_stone_apple = new ItemIronAlchimiaStoneApple(0, false);
		diamond_alchimia_stone_apple = new ItemDiamondAlchimiaStoneApple(0, false);
		golden_alchimia_apple = new ItemGoldenAlchimiaApple(0, false);
		
		//素材の修繕アイテム
		FALLTHER.customCraftingMaterial = Items.feather;
	}
}