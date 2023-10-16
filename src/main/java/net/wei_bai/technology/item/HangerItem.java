
package net.wei_bai.technology.item;

import net.wei_bai.technology.init.TechnologyModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class HangerItem extends Item {
	public HangerItem() {
		super(new Item.Properties().tab(TechnologyModTabs.TAB_TECHNOLOGYTAB).durability(34).rarity(Rarity.COMMON));
	}

	@Override
	public int getEnchantmentValue() {
		return 5;
	}
}
