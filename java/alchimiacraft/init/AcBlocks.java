package alchimiacraft.init;

import alchimiacraft.block.*;
import net.minecraft.block.Block;

public class AcBlocks { 
	
	/*ブロックの変数を宣言*/
	//Ore
	public static Block alchimia_ore;
	public static Block ender_jewel_ore;
	public static Block lavagist_ore;
	
	//Block
	public static Block alchimia_block;
	public static Block lavagist_block;
	
	//
	public static Block exp_converter;
	
	/*ブロックのインスタンスを生成*/
	public static void setBlocks() {
		
		//Ore
		alchimia_ore = new BlockAlchimiaOre();
		ender_jewel_ore = new BlockEnderJewelOre();
		lavagist_ore = new BlockLavagistOre();
		
		//Block
		alchimia_block = new BlockAlchimiaBlock();
		lavagist_block = new BlockLavagistBlock();
		
		//
		exp_converter = new BlockExpConverter();
		
	}
}