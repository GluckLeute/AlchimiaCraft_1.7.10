package alchimiacraft.init;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLLog;

public class AcConfig {
	
	/*AlchimiaOre*/
	//鉱石のドロップ数
	public static int quantityDroppedAlchimiaOre;
	//fortune付きのツールで採掘した際の鉱石のドロップ増加量
	public static int quantityDroppedWithBonusAlchimiaOre;
	//生成の優先度
	public static int generationWeightAlchimiaOre;
	//生成の最高高度
	public static int generationMaxHeightAlchimiaOre;
	//生成の最低高度
	public static int generationMinHeightAlchimiaOre;
	//生成頻度
	public static int generationValueAlchimiaOre;
	//生成される鉱脈の大きさ
	public static int generationSpawnsizeAlchimiaOre;
	
	/*EnderJewelOre*/
	//鉱石のドロップ数
	public static int quantityDroppedEnderJewelOre;
	//fortune付きのツールで採掘した際の鉱石のドロップ増加量
	public static int quantityDroppedWithBonusEnderJewelOre;
	
	/*LavagistOre*/
	//生成の優先度
	public static int generationWeightLavagistOre;
	//生成の最高高度
	public static int generationMaxHeightLavagistOre;
	//生成の最低高度
	public static int generationMinHeightLavagistOre;
	//生成頻度
	public static int generationValueLavagistOre;
	//生成される鉱脈の大きさ
	public static int generationSpawnsizeLavagistOre;
	
	/*ExpConverter*/
	//変換される経験値の量
	public static int conversionRateExpConverter;
	
	
	public void config(Configuration config) {

		try {
			config.load(); //コンフィグファイルを読み込む
		
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
		
		catch (Exception e) { //例外があったなら
			FMLLog.severe("ErrorLog"); //ErrorLogに出力する
		}
		finally {		
			config.save(); //コンフィグファイルを保存する
		}
	}
}