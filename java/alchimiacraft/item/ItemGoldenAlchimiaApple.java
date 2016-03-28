package alchimiacraft.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import alchimiacraft.AlchimiaCraft;
import alchimiacraft.achievement.AcAchievement;

public class ItemGoldenAlchimiaApple extends ItemFood {
	public ItemGoldenAlchimiaApple(int par1, boolean flag) {
		super(par1,flag);
		this.setTextureName(AlchimiaCraft.resourceDomain+"golden_alchimia_apple");
		this.maxStackSize = 1;
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("golden_alchimia_apple");
		this.setMaxDamage(8); //�ő�ϋv�l��8
		this.setAlwaysEdible(); //�����������Ă��Ȃ��Ă��H�ׂ���
	}
	
	//�A�C�e���ɃG���`�����g�G�t�F�N�g��t�^����
	@Override
	public boolean hasEffect(ItemStack itemstack) {   
		if(itemstack.getItemDamageForDisplay() < 8) { //�_���[�W��8�����Ȃ�
			 return true; //�t�^����
			}
			else {
				return false; //�t�^���Ȃ�
			}
    }
	
	//�H�ׂ����ɌĂ΂��
	@Override
	public ItemStack onEaten(ItemStack itemStack, World world, EntityPlayer player) {
		if(itemStack.getItemDamageForDisplay() < 8) {
			
			//�����x�̉񕜗ʁA�B�������x�̉񕜗�
			player.getFoodStats().addStats(4, 1.2F);
			player.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 2400, 0));
			world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
			itemStack.damageItem(1, player);
			
			//���т���������
			player.triggerAchievement(AcAchievement.useGoldenAlchimiaApple);
			
			return itemStack;
		}
		return itemStack;
	}
	
	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int i, boolean flag) {
    	if(entity.ticksExisted % 4800 == 0 && itemStack.isItemDamaged() == true) {
    		itemStack.damageItem(-1, (EntityLivingBase)entity);
    	}  
    }
}