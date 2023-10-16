
package net.wei_bai.technology.item;

import net.wei_bai.technology.init.TechnologyModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class StonetoolsyntheticclothItem extends Item {
	public StonetoolsyntheticclothItem() {
		super(new Item.Properties().tab(TechnologyModTabs.TAB_TECHNOLOGYTAB).stacksTo(4).rarity(Rarity.COMMON));
	}
}
