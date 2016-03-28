package alchimiacraft.register;

import alchimiacraft.init.AcBlocks;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegister {
	
	/*�u���b�N�̓o�^*/
	//�����ł̕��т��N���G�C�e�B�u�^�u�ł̕��тɂȂ�
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