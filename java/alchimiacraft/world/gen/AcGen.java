package alchimiacraft.world.gen;

import alchimiacraft.init.AcConfig;
import cpw.mods.fml.common.registry.GameRegistry;

public class AcGen { 
	/*¶¬•¨‚Ì“o˜^*/
	public static void registerWorldGen() {
		
		/*¶¬‚Ì—Dæ“x*/
		//AlchimiaOre
		int gWAO = AcConfig.generationWeightAlchimiaOre;
		//LavagistOre
		int gWLO = AcConfig.generationWeightLavagistOre;
		
		//AlchimiaOre‚Ì¶¬
		GameRegistry.registerWorldGenerator(new AlchimiaOreGenerator(),gWAO);
		//LavagistOre‚Ì¶¬
		GameRegistry.registerWorldGenerator(new LavagistGenerator(),gWLO);
	
	}
}