
package net.wei_bai.technology.item;

import net.wei_bai.technology.init.TechnologyModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class WoodstickItem extends Item {
	public WoodstickItem() {
		super(new Item.Properties().tab(TechnologyModTabs.TAB_TECHNOLOGYTAB).stacksTo(64).rarity(Rarity.COMMON));
	}
}
