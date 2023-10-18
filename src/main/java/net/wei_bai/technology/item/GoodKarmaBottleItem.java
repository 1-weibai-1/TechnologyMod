
package net.wei_bai.technology.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.wei_bai.technology.client.renderer.ThrownGoodKarmaBottle;
import net.wei_bai.technology.init.TechnologyModTabs;

public class GoodKarmaBottleItem extends Item {
	public GoodKarmaBottleItem() {
		super(new Item.Properties().tab(TechnologyModTabs.TAB_TECHNOLOGYTAB).stacksTo(64).rarity(Rarity.COMMON));
	}

	public boolean isFoil(ItemStack itemStack) {
		return true;
	}

	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
		ItemStack itemstack = player.getItemInHand(interactionHand);
		level.playSound((Player)null, player.getX(), player.getY(), player.getZ(),
				SoundEvents.EXPERIENCE_BOTTLE_THROW,
				SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
		if (!level.isClientSide) {
			ThrownGoodKarmaBottle thrownGoodKarmaBottle = new ThrownGoodKarmaBottle(level, player);
			thrownGoodKarmaBottle.setItem(itemstack);
			thrownGoodKarmaBottle.shootFromRotation(player, player.getXRot(), player.getYRot(), -20.0F, 0.7F, 1.0F);
			level.addFreshEntity(thrownGoodKarmaBottle);
		}

		player.awardStat(Stats.ITEM_USED.get(this));
		if (!player.getAbilities().instabuild) {
			itemstack.shrink(1);
		}

		return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	}
}
