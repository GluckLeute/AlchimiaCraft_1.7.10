package alchimiacraft.world.gen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import alchimiacraft.init.AcConfig;
import alchimiacraft.init.AcBlocks;
import cpw.mods.fml.common.IWorldGenerator;

public class AlchimiaOreGenerator implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		if (world.provider instanceof WorldProviderSurface) {
			this.generateOre(world, random, chunkX << 4, chunkZ << 4);
		}
	}
	
	private void generateOre(World world, Random random, int x, int z){
		int gMaxAO = AcConfig.generationMaxHeightAlchimiaOre;
		int gMinAO = AcConfig.generationMinHeightAlchimiaOre;
		int gVAO = AcConfig.generationValueAlchimiaOre;
		int gSAO = AcConfig.generationSpawnsizeAlchimiaOre;
		
			for (int i = 0; i < gVAO; ++i) { //生成処理を繰り返す
				int genX =  x + random.nextInt(16);
				int genY = gMinAO + random.nextInt(gMaxAO);
				int genZ =  z + random.nextInt(16);
				
				//生成されるブロック、メタデータ、鉱脈の大きさ、置き換わるブロック
				new WorldGenMinable(AcBlocks.alchimia_ore,0, gSAO, Blocks.stone).generate(world, random, genX, genY, genZ);
			}
		}

}