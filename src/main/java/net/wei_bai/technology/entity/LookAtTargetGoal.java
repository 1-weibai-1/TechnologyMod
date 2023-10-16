package net.wei_bai.technology.entity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class LookAtTargetGoal extends Goal {
    private final TigerEntity entity;
    private LivingEntity target;

    public LookAtTargetGoal(TigerEntity entity) {
        this.entity = entity;
        this.setFlags(EnumSet.of(Flag.LOOK));
    }

    @Override
    public boolean canUse() {
        this.target = this.entity.getTarget();
        return this.target != null;
    }

    @Override
    public boolean canContinueToUse() {
        return this.target.isAlive();
    }

    @Override
    public void start() {
        this.entity.getNavigation().stop();
    }

    @Override
    public void tick() {
        this.entity.getLookControl().setLookAt(this.target, 180.0F, 180.0F);
    }
}


