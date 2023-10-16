
package net.wei_bai.technology.item;

import net.wei_bai.technology.init.TechnologyModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class DaolianggrassItemsItem extends Item {
	public DaolianggrassItemsItem() {
		super(new Item.Properties().tab(TechnologyModTabs.TAB_TECHNOLOGYTAB).stacksTo(16).rarity(Rarity.COMMON));
	}
}
