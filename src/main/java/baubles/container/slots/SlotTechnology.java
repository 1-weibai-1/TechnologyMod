package baubles.container.slots;


import baubles.api.cap.CapabilityTechnologys;
import baubles.api.technology.ITechnology;
import baubles.api.technology.ITechnologysItemHandler;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class SlotTechnology extends SlotItemHandler {
    int technologySlot;

    Player player;

    public SlotTechnology(Player player, ITechnologysItemHandler itemHandler, int slot, int par4, int par5) {
        super(itemHandler, slot, par4, par5);
        this.technologySlot = slot;
        this.player = player;
    }

    /**
     * 检查堆栈是否是此插槽的有效项目。
     */
    @Override
    public boolean mayPlace(ItemStack stack) {
        return ((ITechnologysItemHandler) getItemHandler()).isItemValidForSlot(technologySlot, stack);
    }

    @Override
    public boolean mayPickup(Player player) {
        ItemStack stack = getItem();
        if (stack.isEmpty())
            return false;

        ITechnology bauble = stack.getCapability(CapabilityTechnologys.ITEM_TECHNOLOGYS).orElseThrow(NullPointerException::new);
        return bauble.canUnequip(player);
    }

    @Override
    public void onTake(Player playerIn, ItemStack stack) {
        if (!hasItem() && !((ITechnologysItemHandler) getItemHandler()).isEventBlocked() && stack.getCapability(CapabilityTechnologys.ITEM_TECHNOLOGYS).isPresent()) {
            stack.getCapability(CapabilityTechnologys.ITEM_TECHNOLOGYS, null).ifPresent((iTechnology) -> iTechnology.onUnequipped(playerIn, stack));
        }
        super.onTake(playerIn, stack);
    }

    @Override
    public void set(ItemStack stack) {
        if (hasItem() && !ItemStack.isSame(stack, getItem()) && !((ITechnologysItemHandler) getItemHandler()).isEventBlocked() && getItem().getCapability(CapabilityTechnologys.ITEM_TECHNOLOGYS, null).isPresent()) {
            getItem().getCapability(CapabilityTechnologys.ITEM_TECHNOLOGYS, null).ifPresent((iTechnology) -> iTechnology.onUnequipped(player, stack));
        }

        ItemStack oldstack = getItem().copy();
        super.set(stack);

        if (hasItem() && !ItemStack.isSame(oldstack, getItem()) && !((ITechnologysItemHandler) getItemHandler()).isEventBlocked() && getItem().getCapability(CapabilityTechnologys.ITEM_TECHNOLOGYS, null).isPresent()) {
            getItem().getCapability(CapabilityTechnologys.ITEM_TECHNOLOGYS, null).ifPresent((iTechnology) -> iTechnology.onEquipped(player, stack));
        }
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }



}