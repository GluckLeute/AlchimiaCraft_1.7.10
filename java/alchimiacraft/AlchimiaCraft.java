package alchimiacraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import alchimiacraft.init.AcConfig;
import alchimiacraft.achievement.AcAchievement;
import alchimiacraft.creativetab.AcCreativeTabs;
import alchimiacraft.event.AcEvent;
import alchimiacraft.fuel.AcFuels;
import alchimiacraft.init.AcBlocks;
import alchimiacraft.init.AcItems;
import alchimiacraft.recipe.AcRecipes;
import alchimiacraft.register.BlockRegister;
import alchimiacraft.register.ItemRegister;
import alchimiacraft.world.gen.AcGen;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = AlchimiaCraft.modid ,name = AlchimiaCraft.modname ,version = AlchimiaCraft.version +"1.7.10")

public class AlchimiaCraft {
	
    public static final String modid = "alchimiacraft";
    public static final String modname = "AlchimiaCraft";
    public static final String version = "1.0.0";
    public static final String resourceDomain = "alchimiacraft:";
    
    //�N���G�C�e�B�u�^�u
    public static CreativeTabs tabAlchimiaCraft = new AcCreativeTabs("AlchimiaCraftTab");
    
    /*�������O����*/
    @Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
    	
    	//�u���b�N�̒ǉ�
    	AcBlocks.setBlocks();
    	//�u���b�N�̓o�^
		BlockRegister.registerBlocks();
    	
    	//�A�C�e���̒ǉ�
    	AcItems.setItems();
    	//�A�C�e���̓o�^
		ItemRegister.registerItems();
		
		//�R���t�B�O�̐ݒ�
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		(new AcConfig()).config(config);
	}
    
    /*����������*/
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		//���V�s�̓o�^
		AcRecipes.registerRecipes();
		
		//�R���̓o�^
		AcFuels.registerFuels();
		
		//�������̓o�^
		AcGen.registerWorldGen();
		
		//�C�x���g�̓o�^
		AcEvent.registerEvent();
		
		//���т̓o�^
		AcAchievement.registerAchievement();
	} 
}