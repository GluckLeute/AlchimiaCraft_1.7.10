package alchimiacraft.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import alchimiacraft.init.AcBlocks;
import alchimiacraft.init.AcItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class AcRecipes{
	/*レシピの登録*/
	public static void registerRecipes() {
		
		/**精錬レシピ**/
		/*バニラアイテム*/
		//パン
		GameRegistry.addSmelting( Items.wheat, new ItemStack( Items.bread),0.1f);
		//革
		GameRegistry.addSmelting( Items.rotten_flesh, new ItemStack( Items.leather),0.2f);
		
		//鉱石-->アイテム
		//AlchimiaOre
		GameRegistry.addSmelting(AcBlocks.alchimia_ore,new ItemStack(AcItems.alchimia_powder),0.7f);
		//EnderJewelOre
		GameRegistry.addSmelting(AcBlocks.ender_jewel_ore,new ItemStack(AcItems.ender_jewel),1.0f);
		
		/**クラフトレシピ**/
		/*バニラアイテム*/
		//チェーン装備一式
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_helmet), 
				new Object[]{ "XXX","X X",
				'X',Blocks.iron_bars});
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_chestplate), 
				new Object[]{ "X X","XXX","XXX",
				'X',Blocks.iron_bars});
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_leggings), 
				new Object[]{ "XXX","X X","X X",
				'X',Blocks.iron_bars});
		GameRegistry.addRecipe(new ItemStack(Items.chainmail_boots), 
				new Object[]{ "X X","X X",
				'X',Blocks.iron_bars});
		
		//経験値ボトル
		GameRegistry.addShapelessRecipe(new ItemStack(Items.experience_bottle,8),
				AcItems.exp_powder,
				Items.glass_bottle);
		
		/*錬金術レシピ*/
		//GunPowder
		GameRegistry.addRecipe(new ItemStack(Items.gunpowder,3), 
				new Object[]{ " X ","X X",
				'X',AcItems.alchimia_powder});
		//ClayBall
		GameRegistry.addRecipe(new ItemStack(Items.clay_ball,4), 
				new Object[]{ "XX","XX",
				'X',AcItems.alchimia_powder});
		//Coal
		GameRegistry.addRecipe(new ItemStack(Items.coal,2), 
				new Object[]{ "X ","XX",
				'X',AcItems.alchimia_powder});
		//IronIngot
		GameRegistry.addRecipe(new ItemStack(Items.iron_ingot), 
				new Object[]{ "XX",
				'X',AcItems.alchimia_powder});
		//RedStone
		GameRegistry.addRecipe(new ItemStack(Items.redstone,3), 
				new Object[]{ " X ","XXX",
				'X',AcItems.alchimia_powder});
		//GoldIngot
		GameRegistry.addRecipe(new ItemStack(Items.gold_ingot,3), 
				new Object[]{ "XXX","XXX",
				'X',AcItems.alchimia_powder});
		//LapisLazuli
		GameRegistry.addRecipe(new ItemStack(Items.dye,6,4), 
				new Object[]{ " XX","XXX","XX ",
				'X',AcItems.alchimia_powder,});
		//Emerald
		GameRegistry.addRecipe(new ItemStack(Items.emerald,2), 
				new Object[]{ " X ","X X"," X ",
				'X',AcItems.alchimia_powder});
		//GlowstoneDust
		GameRegistry.addRecipe(new ItemStack(Items.glowstone_dust,4), 
				new Object[]{ " X ","XYX",
				'X',AcItems.alchimia_powder,
				'Y',Items.blaze_powder});
		//Quartz
		GameRegistry.addRecipe(new ItemStack(Items.quartz,4), 
				new Object[]{ " XX","XXX",
				'X',AcItems.alchimia_powder,});
		//Diamoind
		GameRegistry.addRecipe(new ItemStack(Items.diamond), 
				new Object[]{ " X ","XXX","XXX",
				'X',AcItems.alchimia_powder});
		
		//アイテム-->圧縮アイテム
		//AlchimiaBlock
		GameRegistry.addRecipe(new ItemStack(AcBlocks.alchimia_block), 
				new Object[]{ "XXX","XXX","XXX",
				'X',AcItems.alchimia_powder});
		//LavagistBlock
		GameRegistry.addRecipe(new ItemStack(AcBlocks.lavagist_block), 
				new Object[]{ "XXX","XXX","XXX",
				'X',AcItems.lavagist_ingot});
		
		//圧縮ブロック-->アイテム
		//AlchimiaPowder
		GameRegistry.addShapelessRecipe(new ItemStack(AcItems.alchimia_powder,9),
				AcBlocks.alchimia_block);
		//LavagistIngot
		GameRegistry.addShapelessRecipe(new ItemStack(AcItems.lavagist_ingot,9),
				AcBlocks.lavagist_block);
		
		/*中間素材*/
		//AlchimiaPowder
		GameRegistry.addShapelessRecipe(new ItemStack(AcItems.alchimia_powder,4),
			       AcItems.witch_crystal);
		//JewelFrame
		GameRegistry.addRecipe(new ItemStack(AcItems.iron_alchimia_stone), 
				new Object[]{ " X ","YZY","XXX",
				'X',Items.gold_ingot,
				'Y',Items.quartz,
				'Z',Items.ender_pearl});
		//IronAlchimiaStone
		GameRegistry.addRecipe(new ItemStack(AcItems.iron_alchimia_stone), 
				new Object[]{ " X ","XYX"," X ",
				'X',Items.iron_ingot,
				'Y',AcItems.alchimia_stone});
		//DiamondAlchimiaStone
		GameRegistry.addRecipe(new ItemStack(AcItems.diamond_alchimia_stone), 
				new Object[]{ " X ","XYX"," X ",
				'X',Items.diamond,
				'Y',AcItems.iron_alchimia_stone});
		
		/*Sword*/
		//AlchimaiStoneSword
		GameRegistry.addRecipe(new ItemStack(AcItems.alchimia_stone_sword), 
				new Object[]{ "X","X","Y",
				'X',AcItems.alchimia_stone,
				'Y',Items.gold_ingot});
		//IronAlchimaiStoneSword
		GameRegistry.addRecipe(new ItemStack(AcItems.iron_alchimia_stone_sword), 
				new Object[]{ "X","X","Y",
				'X',AcItems.iron_alchimia_stone,
				'Y',Items.gold_ingot});
		//DiamondAlchimaiStoneSword
		GameRegistry.addRecipe(new ItemStack(AcItems.diamond_alchimia_stone_sword), 
				new Object[]{ "X","X","Y",
				'X',AcItems.diamond_alchimia_stone,
				'Y',Items.gold_ingot});
		//ExplosionSword
		GameRegistry.addRecipe(new ItemStack(AcItems.explosion_sword), 
				new Object[]{ " Z ","ZXZ","XYX",
			'X',Items.gunpowder,
			'Y',AcItems.diamond_alchimia_stone_sword,
			'Z',Blocks.tnt,});
		//LavagistSword
		GameRegistry.addRecipe(new ItemStack(AcItems.lavagist_sword), 
				new Object[]{ "X","X","Y",
				'X',AcItems.lavagist_ingot,
				'Y',Items.blaze_rod});
		
		/*Wand系*/
		//Wand
		GameRegistry.addRecipe(new ItemStack(AcItems.wand), 
				new Object[]{ "X","Y","Y",
				'X',AcItems.jewel_frame,
				'Y',Items.gold_ingot});
		//EnderWand
		GameRegistry.addRecipe(new ItemStack(AcItems.ender_wand), 
				new Object[]{ "CZC","AXA","BYB",
				'X',AcItems.ender_jewel,
				'Y',AcItems.wand,
				'Z',Items.ender_eye,
				'A',Items.ender_pearl,
				'B',Items.blaze_powder,
				'C',AcItems.diamond_alchimia_stone});
		//SnowWand
		GameRegistry.addRecipe(new ItemStack(AcItems.snow_wand), 
				new Object[]{ "CZC","AXA","BYB",
				'X',AcItems.ender_jewel,
				'Y',AcItems.wand,
				'Z',Items.snowball,
				'A',Blocks.snow,
				'B',Items.water_bucket,
				'C',AcItems.alchimia_stone});
		//FireWand
		GameRegistry.addRecipe(new ItemStack(AcItems.fire_wand), 
				new Object[]{ "CZC","AXA","BYB",
				'X',AcItems.ender_jewel,
				'Y',AcItems.wand,
				'Z',Items.fire_charge,
				'A',Items.gunpowder,
				'B',Items.blaze_powder,
				'C',AcItems.alchimia_stone});
		//GhastWand
		GameRegistry.addRecipe(new ItemStack(AcItems.ghast_wand), 
				new Object[]{ "CZC","AXA","BYB",
				'X',AcItems.ender_jewel,
				'Y',AcItems.wand,
				'Z',Items.fire_charge,
				'A',Items.ghast_tear,
				'B',Items.blaze_rod,
				'C',AcItems.iron_alchimia_stone});
		//LightningWand
		GameRegistry.addRecipe(new ItemStack(AcItems.lightning_wand), 
				new Object[]{ "CZC","AXA","BYB",
				'X',AcItems.ender_jewel,
				'Y',AcItems.wand,
				'Z',Blocks.gold_block,
				'A',Blocks.iron_block,
				'B',Blocks.redstone_block,
				'C',AcItems.iron_alchimia_stone});
		//ExplosionWnad
		GameRegistry.addRecipe(new ItemStack(AcItems.explosion_wand), 
				new Object[]{ "CZC","ZXZ","BYB",
				'X',AcItems.ender_jewel,
				'Y',AcItems.wand,
				'Z',Blocks.tnt,
				'B',Items.fire_charge,
				'C',AcItems.diamond_alchimia_stone});
		
		/*AlchimiaStoneApple系*/
		//AlchimiaStoneApple
		GameRegistry.addRecipe(new ItemStack(AcItems.alchimia_stone_apple), 
				new Object[]{ " X ","XYX"," X ",
				'X',AcItems.alchimia_stone,
				'Y',Items.apple});
		//IronAlchimiaStoneApple
		GameRegistry.addRecipe(new ItemStack(AcItems.iron_alchimia_stone_apple), 
				new Object[]{ " X ","XYX"," X ",
				'X',AcItems.iron_alchimia_stone,
				'Y',Items.apple});
		//DiamondAlchimiaStoneApple
		GameRegistry.addRecipe(new ItemStack(AcItems.diamond_alchimia_stone_apple), 
				new Object[]{ " X ","XYX"," X ",
				'X',AcItems.diamond_alchimia_stone,
				'Y',Items.apple});
		//GoldenAlchimiaApple
		GameRegistry.addRecipe(new ItemStack(AcItems.golden_alchimia_apple), 
				new Object[]{ "XXX","XYX","XXX",
				'X',Items.gold_ingot,
				'Y',AcItems.diamond_alchimia_stone});
	}
}