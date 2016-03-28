package alchimiacraft.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import alchimiacraft.AlchimiaCraft;

public class ItemAlchimiaStoneApple extends ItemFood {
	public ItemAlchimiaStoneApple(int par1, boolean flag) {
		super(par1,flag);
		this.setTextureName(AlchimiaCraft.resourceDomain+"alchimia_stone_apple");
		this.maxStackSize = 1;
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("alchimia_stone_apple");
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
			player.getFoodStats().addStats(3, 0.6F);
			world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
			itemStack.damageItem(1, player);
			return itemStack;
    }
		return itemStack;
}
	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int i, boolean flag) {
    	if(entity.ticksExisted % 640 == 0 && itemStack.isItemDamaged() == true) {
    		itemStack.damageItem(-1, (EntityLivingBase)entity);
    	}  
    }
}