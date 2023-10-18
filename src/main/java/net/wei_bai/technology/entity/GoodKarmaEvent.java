package net.wei_bai.technology.entity;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Cancelable;

public class GoodKarmaEvent extends PlayerEvent
{

    public GoodKarmaEvent(Player player)
    {
        super(player);
    }

    /**
     * This event is fired after the player collides with an experience orb, but before the player has been given the experience.
     * It can be cancelled, and no further processing will be done.
     */
    @Cancelable
    public static class PickupXp extends GoodKarmaEvent
    {

        private final GoodKarmaEntity orb;

        public PickupXp(Player player, GoodKarmaEntity orb)
        {
            super(player);
            this.orb = orb;
        }

        public GoodKarmaEntity getOrb()
        {
            return orb;
        }

    }

    /**
     * This event is fired when the player's experience changes through the {@link Player#giveExperiencePoints(int)} method.
     * It can be cancelled, and no further processing will be done.
     */
    @Cancelable
    public static class XpChange extends GoodKarmaEvent
    {

        private int amount;

        public XpChange(Player player, int amount)
        {
            super(player);
            this.amount = amount;
        }

        public int getAmount()
        {
            return this.amount;
        }

        public void setAmount(int amount)
        {
            this.amount = amount;
        }

    }

    /**
     * This event is fired when the player's experience level changes through the {@link Player#giveExperienceLevels(int)} method.
     * It can be cancelled, and no further processing will be done.
     */
    @Cancelable
    public static class LevelChange extends GoodKarmaEvent
    {

        private int levels;

        public LevelChange(Player player, int levels)
        {
            super(player);
            this.levels = levels;
        }

        public int getLevels()
        {
            return this.levels;
        }

        public void setLevels(int levels)
        {
            this.levels = levels;
        }

    }

}