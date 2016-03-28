package alchimiacraft.world.gen;

import alchimiacraft.init.AcConfig;
import cpw.mods.fml.common.registry.GameRegistry;

public class AcGen { 
	/*�������̓o�^*/
	public static void registerWorldGen() {
		
		/*�����̗D��x*/
		//AlchimiaOre
		int gWAO = AcConfig.generationWeightAlchimiaOre;
		//LavagistOre
		int gWLO = AcConfig.generationWeightLavagistOre;
		
		//AlchimiaOre�̐���
		GameRegistry.registerWorldGenerator(new AlchimiaOreGenerator(),gWAO);
		//LavagistOre�̐���
		GameRegistry.registerWorldGenerator(new LavagistGenerator(),gWLO);
	
	}
}