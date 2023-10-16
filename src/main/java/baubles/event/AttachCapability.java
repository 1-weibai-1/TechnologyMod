package baubles.event;


import baubles.api.TechnologyAPI;
import baubles.api.cap.CapabilityTechnologys;
import baubles.api.technology.ITechnology;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, modid = TechnologyAPI.MOD_ID)
public class AttachCapability {

    private static final ResourceLocation CAP = new ResourceLocation(TechnologyAPI.MOD_ID, "technology_cap");

    @SubscribeEvent
    public static void attachCaps(AttachCapabilitiesEvent<ItemStack> event) {
        ItemStack stack = event.getObject();
        if (stack.getItem() instanceof ITechnology technology) {
            event.addCapability(CAP, new ICapabilityProvider() {
                private final LazyOptional<ITechnology> opt = LazyOptional.of(() -> technology);

                @SuppressWarnings("ConstantConditions")
                @Nonnull
                @Override
                public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
                    return CapabilityTechnologys.ITEM_TECHNOLOGYS.orEmpty(cap, opt);
                }
            });
        }
    }
}
