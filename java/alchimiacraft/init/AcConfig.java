package alchimiacraft.init;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLLog;

public class AcConfig {
	
	/*AlchimiaOre*/
	//�z�΂̃h���b�v��
	public static int quantityDroppedAlchimiaOre;
	//fortune�t���̃c�[���ō̌@�����ۂ̍z�΂̃h���b�v������
	public static int quantityDroppedWithBonusAlchimiaOre;
	//�����̗D��x
	public static int generationWeightAlchimiaOre;
	//�����̍ō����x
	public static int generationMaxHeightAlchimiaOre;
	//�����̍Œፂ�x
	public static int generationMinHeightAlchimiaOre;
	//�����p�x
	public static int generationValueAlchimiaOre;
	//���������z���̑傫��
	public static int generationSpawnsizeAlchimiaOre;
	
	/*EnderJewelOre*/
	//�z�΂̃h���b�v��
	public static int quantityDroppedEnderJewelOre;
	//fortune�t���̃c�[���ō̌@�����ۂ̍z�΂̃h���b�v������
	public static int quantityDroppedWithBonusEnderJewelOre;
	
	/*LavagistOre*/
	//�����̗D��x
	public static int generationWeightLavagistOre;
	//�����̍ō����x
	public static int generationMaxHeightLavagistOre;
	//�����̍Œፂ�x
	public static int generationMinHeightLavagistOre;
	//�����p�x
	public static int generationValueLavagistOre;
	//���������z���̑傫��
	public static int generationSpawnsizeLavagistOre;
	
	/*ExpConverter*/
	//�ϊ������o���l�̗�
	public static int conversionRateExpConverter;
	
	
	public void config(Configuration config) {

		try {
			config.load(); //�R���t�B�O�t�@�C����ǂݍ���
		
			//AlchimiaOre
			quantityDroppedAlchimiaOre = config.get("block", "quantityDroppedAlchimiaOre", 4).getInt();
			quantityDroppedWithBonusAlchimiaOre = config.get("block", "quantityDroppedWithBonusAlchimiaOre", 2).getInt();
			generationWeightAlchimiaOre = config.get("system", "generationWeightAlchimiaOre", 10).getInt();
			generationMaxHeightAlchimiaOre = config.get("world", "generationMaxHeightAlchimiaOre", 64).getInt();
			generationMinHeightAlchimiaOre = config.get("world", "generationMinHeightAlchimiaOre", 1).getInt();
			generationValueAlchimiaOre = config.get("world", "generationValueAlchimiaOre", 16).getInt();
			generationSpawnsizeAlchimiaOre = config.get("world", "generationSpawnsizeAlchimiaOre", 6).getInt();
			
			//EnderJewelOre
			quantityDroppedEnderJewelOre = config.get("block", "quantityDroppedEnderJewelOre", 1).getInt();
			quantityDroppedWithBonusEnderJewelOre = config.get("block", "quantityDroppedWithBonusEnderJewelOre", 1).getInt();
			
			//LavagistOre
			generationWeightLavagistOre = config.get("system", "generationWeightLavagistOre", 10).getInt();
			generationMaxHeightLavagistOre = config.get("world", "generationMaxHeightLavagistOre", 64).getInt();
			generationMinHeightLavagistOre = config.get("world", "generationMinHeightLavagistOre", 1).getInt();
			generationValueLavagistOre = config.get("world", "generationValueLavagistOre", 16).getInt();
			generationSpawnsizeLavagistOre = config.get("world", "generationSpawnsizeLavagistOre", 6).getInt();
			
			//ExpConverter
			conversionRateExpConverter = config.get("block", "conversionRateExpConverter", 16).getInt();
			
		}
		
		catch (Exception e) { //��O���������Ȃ�
			FMLLog.severe("ErrorLog"); //ErrorLog�ɏo�͂���
		}
		finally {		
			config.save(); //�R���t�B�O�t�@�C����ۑ�����
		}
	}
}