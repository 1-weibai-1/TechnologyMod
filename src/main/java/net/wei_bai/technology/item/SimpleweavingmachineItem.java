
package net.wei_bai.technology.item;

import net.wei_bai.technology.init.TechnologyModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SimpleweavingmachineItem extends Item {
	public SimpleweavingmachineItem() {
		super(new Item.Properties().tab(TechnologyModTabs.TAB_TECHNOLOGYTAB).durability(25).rarity(Rarity.COMMON));
	}

	@Override
	public int getEnchantmentValue() {
		return 10;
	}
}
