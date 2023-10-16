package baubles.capability;


import baubles.api.cap.CapabilityTechnologys;
import baubles.api.technology.ITechnologysItemHandler;
import baubles.event.EventHandlerEntity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("ConstantConditions")
public class TechnologysContainer extends ItemStackHandler implements ITechnologysItemHandler {

    private final static int TECHNOLOGY_SLOTS = 32;
    private final ItemStack[] previous = new ItemStack[TECHNOLOGY_SLOTS];
    private final boolean[] changed = new boolean[TECHNOLOGY_SLOTS];
    private boolean blockEvents = false;
    private final LivingEntity holder;

    public TechnologysContainer(LivingEntity player) {
        super(TECHNOLOGY_SLOTS);
        this.holder = player;
        Arrays.fill(this.previous, ItemStack.EMPTY);
    }

    @Override
    public void setSize(int size) {
        if (size != TECHNOLOGY_SLOTS) System.out.println("Cannot resize baubles container");
    }

    /**
     * 如果允许自动化插入给定的堆栈，则返回true（忽略
     *      *堆栈大小）放入给定的插槽。
     */
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        var baubleCap = stack.getCapability(CapabilityTechnologys.ITEM_TECHNOLOGYS);
        if (stack.isEmpty() || !baubleCap.isPresent()) return false;
        var bauble = baubleCap.orElseThrow(NullPointerException::new);
        return bauble.canEquip(holder) && bauble.getTechnologyType(stack).hasSlot(slot);
    }

    @Override
    public void setStackInSlot(int slot, @Nonnull ItemStack stack) {
        if (stack.isEmpty() || this.isItemValidForSlot(slot, stack)) super.setStackInSlot(slot, stack);
    }

    @Override
    @Nonnull
    public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
        if (!this.isItemValidForSlot(slot, stack)) return stack;
        return super.insertItem(slot, stack, simulate);
    }

    @Override
    public boolean isEventBlocked() {
        return this.blockEvents;
    }

    @Override
    public void setEventBlock(boolean blockEvents) {
        this.blockEvents = blockEvents;
    }

    @Override
    protected void onContentsChanged(int slot) {
        this.changed[slot] = true;
    }

    public void tick() {
        for (int i = 0; i < getSlots(); i++) {
            var stack = getStackInSlot(i);
            stack.getCapability(CapabilityTechnologys.ITEM_TECHNOLOGYS).ifPresent(b -> b.onWornTick(this.holder, stack));
        }
        this.sync();
    }

    private void sync() {
        if (!(holder instanceof ServerPlayer)) return;

        final var holder = (ServerPlayer) this.holder;

        List<ServerPlayer> receivers = null;
        for (byte i = 0; i < getSlots(); i++) {
            final var stack = getStackInSlot(i);
            boolean autoSync = stack.getCapability(CapabilityTechnologys.ITEM_TECHNOLOGYS).map(b -> b.willAutoSync(this.holder)).orElse(false);
            if (changed[i] || autoSync && !ItemStack.isSame(stack, previous[i])) {
                if (receivers == null) {
                    receivers = new ArrayList<>(((ServerLevel) this.holder.level).getPlayers((serverPlayerEntity) -> true));
                    receivers.add(holder);
                }
                EventHandlerEntity.syncSlot(holder, i, stack, receivers);
                this.changed[i] = false;
                previous[i] = stack.copy();
            }
        }
    }
}
