
package net.wei_bai.technology.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class TechnologybookItem extends Item {
	public TechnologybookItem() {
		super(new Item.Properties().tab(null).stacksTo(0).rarity(Rarity.COMMON));
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState state) {
		return true;
	}
}
