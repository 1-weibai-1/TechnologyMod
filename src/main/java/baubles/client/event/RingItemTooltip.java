package baubles.client.event;


import baubles.api.TechnologyAPI;
import baubles.api.cap.CapabilityTechnologys;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TechnologyAPI.MOD_ID, value = Dist.CLIENT)
public class RingItemTooltip {

    @SuppressWarnings("ConstantConditions")
    @SubscribeEvent
    public static void tooltipEvent(ItemTooltipEvent event) {

        if (!event.getItemStack().isEmpty()) {
            if (event.getItemStack().getCapability(CapabilityTechnologys.ITEM_TECHNOLOGYS).isPresent()) {
                event.getItemStack().getCapability(CapabilityTechnologys.ITEM_TECHNOLOGYS).ifPresent(technology -> {
                    var bt = technology.getTechnologyType(event.getItemStack());
                    var text = new TranslatableComponent("name." + bt);
                    text.withStyle(ChatFormatting.GOLD);
                    event.getToolTip().add(text);
                });

            }
        }

        if(event.getItemStack().is(ItemTags.create(new ResourceLocation("forge:technology_stone_age")))) {
            if(Screen.hasShiftDown()){
                var text1 = new TranslatableComponent("tooltip.technology.tooltip_1");
                event.getToolTip().add(text1);
            }else {
                var text2 = new TranslatableComponent("tooltip.technology.tooltip.shift_down");
                event.getToolTip().add(text2);
            }
        }

    }
}
