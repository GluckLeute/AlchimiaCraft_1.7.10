package alchimiacraft.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import alchimiacraft.AlchimiaCraft;

public class ItemDiamondAlchimiaStoneApple extends ItemFood {
	public ItemDiamondAlchimiaStoneApple(int par1, boolean flag) {
		super(par1,flag);
		this.setTextureName(AlchimiaCraft.resourceDomain+"diamond_alchimia_stone_apple");
		this.maxStackSize = 1;
		this.setCreativeTab(AlchimiaCraft.tabAlchimiaCraft);
		this.setUnlocalizedName("diamond_alchimia_stone_apple");
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
			player.getFoodStats().addStats(8, 1.2F);
			world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
			itemStack.damageItem(1, player);
			return itemStack;
    }
		return itemStack;
}
	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int i, boolean flag) {
    	if(entity.ticksExisted % 320 == 0 && itemStack.isItemDamaged() == true) {
    		itemStack.damageItem(-2, (EntityLivingBase)entity);
    	}  
    }
}