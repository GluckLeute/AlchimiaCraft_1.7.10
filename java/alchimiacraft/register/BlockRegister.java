package alchimiacraft.register;

import alchimiacraft.init.AcBlocks;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegister {
	
	/*ブロックの登録*/
	//ここでの並びがクリエイティブタブでの並びになる
	public static void registerBlocks() {
		
		//Ore
		GameRegistry.registerBlock(AcBlocks.alchimia_ore,"alchimia_ore");
		GameRegistry.registerBlock(AcBlocks.ender_jewel_ore,"ender_jewel_ore");
		GameRegistry.registerBlock(AcBlocks.lavagist_ore,"lavagist_ore");
		
		//Block
		GameRegistry.registerBlock(AcBlocks.alchimia_block,"alchimia_block");
		GameRegistry.registerBlock(AcBlocks.lavagist_block,"lavagist_block");
		
		//
		GameRegistry.registerBlock(AcBlocks.exp_converter,"exp_converter");
		
	}
}