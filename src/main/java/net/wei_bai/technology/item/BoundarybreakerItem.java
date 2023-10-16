
package net.wei_bai.technology.item;

import net.wei_bai.technology.procedures.BoundarybreakerDangShiTiHuiDongWuPinShiProcedure;
import net.wei_bai.technology.init.TechnologyModTabs;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

public class BoundarybreakerItem extends PickaxeItem {
	public BoundarybreakerItem() {
		super(new Tier() {
			public int getUses() {
				return 100;
			}

			public float getSpeed() {
				return 10f;
			}

			public float getAttackDamageBonus() {
				return -2f;
			}

			public int getLevel() {
				return 10;
			}

			public int getEnchantmentValue() {
				return 0;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 1, -4f, new Item.Properties().tab(TechnologyModTabs.TAB_TECHNOLOGYTAB));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		BoundarybreakerDangShiTiHuiDongWuPinShiProcedure.execute(entity.level, entity);
		return retval;
	}
}
