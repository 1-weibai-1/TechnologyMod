
package net.wei_bai.technology.item;

import net.wei_bai.technology.init.TechnologyModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class ToughstonelineItem extends Item {
	public ToughstonelineItem() {
		super(new Item.Properties().tab(TechnologyModTabs.TAB_TECHNOLOGYTAB).stacksTo(64).rarity(Rarity.COMMON));
	}
}
