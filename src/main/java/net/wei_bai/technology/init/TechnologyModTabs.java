
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.wei_bai.technology.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class TechnologyModTabs {
	public static CreativeModeTab TAB_TECHNOLOGYTAB;

	public static void load() {
		TAB_TECHNOLOGYTAB = new CreativeModeTab("tabtechnologytab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(TechnologyModItems.TECHNOLOGYITEM.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
