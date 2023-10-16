
package net.wei_bai.technology.item;

import net.wei_bai.technology.init.TechnologyModTabs;
import net.wei_bai.technology.init.TechnologyModItems;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

public class GravelaxeItem extends AxeItem {
	public GravelaxeItem() {
		super(new Tier() {
			public int getUses() {
				return 95;
			}

			public float getSpeed() {
				return 0.64f;
			}

			public float getAttackDamageBonus() {
				return 6f;
			}

			public int getLevel() {
				return 10;
			}

			public int getEnchantmentValue() {
				return 10;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TechnologyModItems.CRUSHEDSTONE.get()));
			}
		}, 1, -3.2f, new Item.Properties().tab(TechnologyModTabs.TAB_TECHNOLOGYTAB));
	}
}
