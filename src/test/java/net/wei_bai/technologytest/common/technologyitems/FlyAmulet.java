package net.wei_bai.technologytest.common.technologyitems;

import baubles.api.technology.ITechnology;
import baubles.api.technology.TechnologyType;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.wei_bai.technology.init.TechnologyModMobEffects;
import net.wei_bai.technology.init.TechnologyModTabs;

import java.util.UUID;

import static baubles.api.technology.TechnologyType.AMULET;

public class FlyAmulet extends Item implements ITechnology {

    private static final Attribute Attributess = Attributes.ATTACK_DAMAGE;

    private static final UUID ATTACK_MODIFIER = UUID.fromString("e4315b6f-bc15-4602-a2c6-9e1e27b91ff2");
    private static double ded =4;
    private static final AttributeModifier ATTACK_BOOST = new AttributeModifier(ATTACK_MODIFIER, "Attack boost",
            ded, AttributeModifier.Operation.ADDITION);


    public FlyAmulet() {
        super( new Item.Properties().tab(TechnologyModTabs.TAB_TECHNOLOGYTAB).stacksTo(1));

    }

    @Override
    public void onWornTick(LivingEntity player, ItemStack stack) {
        LivingEntity living = player;
        if (!living.level.isClientSide() && living.tickCount % 40 == 0) {
            living.addEffect(new MobEffectInstance(TechnologyModMobEffects.DAOLIANGRICEEFFENCE.get(), 80, 0, true, true));
        }
    }

    @Override
    public TechnologyType getTechnologyType(ItemStack stack) {
        return AMULET;
    }

    @Override
    public boolean canEquip(LivingEntity player) {
        return true;
    }

    @Override
    public void onEquipped(LivingEntity livingEntity, ItemStack itemStack) {
        if (livingEntity instanceof Player player) {
            player.getAttribute(Attributess).addPermanentModifier(ATTACK_BOOST);
        }
    }

    @Override
    public void onUnequipped(LivingEntity livingEntity, ItemStack itemStack) {
        if (livingEntity instanceof Player player) {
            player.getAttribute(Attributess).removeModifier(ATTACK_BOOST);
        }
    }

    @SubscribeEvent
    public static void tooltipEvent(ItemTooltipEvent event) {
        if(Screen.hasShiftDown()){
            var text1 = new TextComponent("%s".formatted(Attributess )+ ded);
            event.getToolTip().add(text1);
        }else {
            var text2 = new TranslatableComponent("tooltip.technology.tooltip.shift_down");
            event.getToolTip().add(text2);
        }
    }

}