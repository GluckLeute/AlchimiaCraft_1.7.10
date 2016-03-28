package alchimiacraft.achievement;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;
import alchimiacraft.AlchimiaCraft;
import alchimiacraft.init.AcItems;
import alchimiacraft.recipe.AcRecipes;
import cpw.mods.fml.common.FMLCommonHandler;

public class AcAchievement {
	
	//AlchimiaPowder����肷��
	public static Achievement getAlchimiaPowder;
	//Wand���N���t�g����
	public static Achievement craftWand;
	//AlchimiaStone�����
	public static Achievement getAlchimiaStone;
	//IronAlchimiaStone���N���t�g����
	public static Achievement craftIronAlchimiaStone;
	//DiamondAlchimiaStone���N���t�g����
	public static Achievement craftDiamondAlchimiaStone;
	//GoldenAlchimiaApple���N���t�g����
	public static Achievement craftGoldenAlchimiaApple;
	//GoldenAlchimiaApple���g�p����
	public static Achievement useGoldenAlchimiaApple;
	//EnderJewel����肷��
	public static Achievement getEnderJewel;
	
	static Achievement[] AcAchievementsList;
	public static AchievementPage AcAchievementPage;
	public static final String newAchievement = "AlchimiaCraft";
	
	public static void registerAchievement() {
		
		getAlchimiaPowder = new Achievement(AlchimiaCraft.resourceDomain+"getAlchimiaPowder", "getAlchimiaPowder", 0, 0, new ItemStack(
				AcItems.alchimia_powder), AchievementList.buildBetterPickaxe).initIndependentStat().registerStat();
		craftWand = new Achievement(AlchimiaCraft.resourceDomain+"craftWand", "craftWand", 2, 0, new ItemStack(
				AcItems.wand), getAlchimiaPowder).registerStat();
		getAlchimiaStone = new Achievement(AlchimiaCraft.resourceDomain+"getAlchimiaStone", "getAlchimiaStone", 2, 2, new ItemStack(
				AcItems.alchimia_stone), craftWand).registerStat();
		craftIronAlchimiaStone = new Achievement(AlchimiaCraft.resourceDomain+"craftIronAlchimiaStone", "getAlchimiaStone", 0, 2, new ItemStack(
				AcItems.iron_alchimia_stone), getAlchimiaStone).registerStat();
		craftDiamondAlchimiaStone = new Achievement(AlchimiaCraft.resourceDomain+"craftDiamondAlchimiaStone", "craftDiamondAlchimiaStone", -2, 2, new ItemStack(
				AcItems.diamond_alchimia_stone), craftIronAlchimiaStone).registerStat();
		craftGoldenAlchimiaApple = new Achievement(AlchimiaCraft.resourceDomain+"craftGoldAlchimiaStoneApple", "craftGoldAlchimiaStoneApple", -2,0, new ItemStack(
				AcItems.golden_alchimia_apple), craftDiamondAlchimiaStone).registerStat();
		useGoldenAlchimiaApple = new Achievement(AlchimiaCraft.resourceDomain+"useGoldAlchimiaStoneApple", "useGoldAlchimiaStoneApple", -1, -1, new ItemStack(
				AcItems.golden_alchimia_apple), craftGoldenAlchimiaApple).setSpecial().registerStat();
		getEnderJewel = new Achievement(AlchimiaCraft.resourceDomain+"getEnderJewel", "getEnderJewel", 2, -2, new ItemStack(
				AcItems.ender_jewel), craftWand).registerStat();
		
		AcAchievementsList = new Achievement[] {
				getAlchimiaPowder,craftWand,getAlchimiaStone,getEnderJewel,craftGoldenAlchimiaApple,
				craftIronAlchimiaStone,craftDiamondAlchimiaStone,
				useGoldenAlchimiaApple
				};
		AcAchievementPage = new AchievementPage(newAchievement, AcAchievementsList);
		AchievementPage.registerAchievementPage(AcAchievementPage);
		
		FMLCommonHandler.instance().bus().register(new AcAchievementEvent());
		FMLCommonHandler.instance().bus().register(new AcRecipes());
		
	}
}