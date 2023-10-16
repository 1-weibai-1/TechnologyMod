
package net.wei_bai.technology.item;

import net.wei_bai.technology.init.TechnologyModTabs;
import net.wei_bai.technology.init.TechnologyModItems;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class GravelpickItem extends PickaxeItem {
	public GravelpickItem() {
		super(new Tier() {
			public int getUses() {
				return 98;
			}

			public float getSpeed() {
				return 0.64f;
			}

			public float getAttackDamageBonus() {
				return 0f;
			}

			public int getLevel() {
				return 10;
			}

			public int getEnchantmentValue() {
				return 10;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TechnologyModItems.GRANITECRUSHEDSTONE.get()));
			}
		}, 1, -3.2f, new Item.Properties().tab(TechnologyModTabs.TAB_TECHNOLOGYTAB));
	}
}
