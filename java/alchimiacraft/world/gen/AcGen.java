package alchimiacraft.world.gen;

import alchimiacraft.init.AcConfig;
import cpw.mods.fml.common.registry.GameRegistry;

public class AcGen { 
	/*生成物の登録*/
	public static void registerWorldGen() {
		
		/*生成の優先度*/
		//AlchimiaOre
		int gWAO = AcConfig.generationWeightAlchimiaOre;
		//LavagistOre
		int gWLO = AcConfig.generationWeightLavagistOre;
		
		//AlchimiaOreの生成
		GameRegistry.registerWorldGenerator(new AlchimiaOreGenerator(),gWAO);
		//LavagistOreの生成
		GameRegistry.registerWorldGenerator(new LavagistGenerator(),gWLO);
	
	}
}