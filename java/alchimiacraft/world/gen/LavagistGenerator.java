package alchimiacraft.world.gen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import alchimiacraft.init.AcConfig;
import alchimiacraft.init.AcBlocks;
import cpw.mods.fml.common.IWorldGenerator;

public class LavagistGenerator implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		
		if (world.provider instanceof WorldProviderHell) {
			this.generateOre(world, random, chunkX << 4, chunkZ << 4);
		}
	}
	private void generateOre(World world, Random random, int x, int z){
		int gMaxLO = AcConfig.generationMaxHeightLavagistOre;
		int gMinLO = AcConfig.generationMinHeightLavagistOre;
		int gVLO = AcConfig.generationValueLavagistOre;
		int gSLO = AcConfig.generationSpawnsizeLavagistOre;
		
			for (int i = 0; i < gVLO; ++i) { //�����������J��Ԃ�
				int genX =  x + random.nextInt(16);
				int genY = gMinLO + random.nextInt(gMaxLO);
				int genZ =  z + random.nextInt(16);
				
				//���������u���b�N�A���^�f�[�^�A�z���̑傫���A�u�������u���b�N
				new WorldGenMinable(AcBlocks.lavagist_ore,0, gSLO, Blocks.lava).generate(world, random, genX, genY, genZ);
			}
		}

}