package baubles.capability;


import baubles.api.cap.CapabilityTechnologys;
import baubles.api.technology.ITechnologysItemHandler;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;

@SuppressWarnings("ConstantConditions")
public class TechnologysContainerProvider implements INBTSerializable<CompoundTag>, ICapabilityProvider {

    private final TechnologysContainer inner;
    private final LazyOptional<ITechnologysItemHandler> baublesHandlerCap;

    public TechnologysContainerProvider(Player player) {
        this.inner = new TechnologysContainer(player);
        this.baublesHandlerCap = LazyOptional.of(() -> this.inner);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, Direction facing) {
        return CapabilityTechnologys.TECHNOLOGY.orEmpty(capability, this.baublesHandlerCap);
    }

    @Override
    public CompoundTag serializeNBT() {
        return this.inner.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        this.inner.deserializeNBT(nbt);
    }
}