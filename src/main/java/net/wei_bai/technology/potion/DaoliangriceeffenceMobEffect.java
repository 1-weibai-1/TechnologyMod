
package net.wei_bai.technology.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class DaoliangriceeffenceMobEffect extends MobEffect {
	public DaoliangriceeffenceMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -5735897);
	}

	@Override
	public String getDescriptionId() {
		return "effect.technology.daoliangriceeffence";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
