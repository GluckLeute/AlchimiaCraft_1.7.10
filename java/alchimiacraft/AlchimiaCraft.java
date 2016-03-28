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
    
    //クリエイティブタブ
    public static CreativeTabs tabAlchimiaCraft = new AcCreativeTabs("AlchimiaCraftTab");
    
    /*初期化前処理*/
    @Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
    	
    	//ブロックの追加
    	AcBlocks.setBlocks();
    	//ブロックの登録
		BlockRegister.registerBlocks();
    	
    	//アイテムの追加
    	AcItems.setItems();
    	//アイテムの登録
		ItemRegister.registerItems();
		
		//コンフィグの設定
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		(new AcConfig()).config(config);
	}
    
    /*初期化処理*/
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		//レシピの登録
		AcRecipes.registerRecipes();
		
		//燃料の登録
		AcFuels.registerFuels();
		
		//生成物の登録
		AcGen.registerWorldGen();
		
		//イベントの登録
		AcEvent.registerEvent();
		
		//実績の登録
		AcAchievement.registerAchievement();
	} 
}