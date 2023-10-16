
package net.wei_bai.technology.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class TechnologyitemItem extends Item {
	public TechnologyitemItem() {
		super(new Item.Properties().tab(null).stacksTo(64).rarity(Rarity.COMMON));
	}
}
