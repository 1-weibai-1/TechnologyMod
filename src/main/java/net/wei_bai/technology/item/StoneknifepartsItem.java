
package net.wei_bai.technology.item;

import net.wei_bai.technology.init.TechnologyModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class StoneknifepartsItem extends Item {
	public StoneknifepartsItem() {
		super(new Item.Properties().tab(TechnologyModTabs.TAB_TECHNOLOGYTAB).stacksTo(1).rarity(Rarity.COMMON));
	}
}
