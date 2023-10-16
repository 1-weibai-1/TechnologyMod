package baubles.container;


import baubles.api.cap.CapabilityTechnologys;
import baubles.api.technology.ITechnologysItemHandler;
import baubles.container.slots.ArmorSlot;
import baubles.container.slots.OffHandSlot;
import baubles.container.slots.SlotTechnology;
import baubles.setup.ModMenus;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import javax.annotation.Nonnull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SuppressWarnings("ConstantConditions")
public class PlayerExpandedContainer extends AbstractContainerMenu  {

    public static final ResourceLocation[] ARMOR_SLOT_TEXTURES = new ResourceLocation[]{InventoryMenu.EMPTY_ARMOR_SLOT_BOOTS, InventoryMenu.EMPTY_ARMOR_SLOT_LEGGINGS, InventoryMenu.EMPTY_ARMOR_SLOT_CHESTPLATE, InventoryMenu.EMPTY_ARMOR_SLOT_HELMET};
    private static final EquipmentSlot[] VALID_EQUIPMENT_SLOTS = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
    private final CraftingContainer craftMatrix = new CraftingContainer(this, 2, 2);
    private final ResultContainer craftResult = new ResultContainer();
    public final boolean isLocalWorld;
    private final Player player;
    private float oldMouseX;
    private float oldMouseY;
    public ITechnologysItemHandler technology;

    public PlayerExpandedContainer(int id, Inventory playerInventory, boolean localWorld) {
        super(ModMenus.PLAYER_TECHNOLOGY.get(), id);
        this.isLocalWorld = localWorld;
        this.player = playerInventory.player;


        this.technology = this.player.getCapability(CapabilityTechnologys.TECHNOLOGY).orElseThrow(NullPointerException::new);





        //合成输出
        this.addSlot(new ResultSlot(playerInventory.player, this.craftMatrix, this.craftResult, 0, 154, 28));

        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 2; ++j) {
                this.addSlot(new Slot(this.craftMatrix, j + i * 2, 116 + j * 18, 18 + i * 18));
            }
        }

        for (int k = 0; k < 4; ++k) {
            var equipmentSlotType = VALID_EQUIPMENT_SLOTS[k];
            this.addSlot(new ArmorSlot(playerInventory, 36 + (3 - k), 8, 8 + k * 18, equipmentSlotType, this.player));
        }

//1
        this.addSlot(new SlotTechnology(player, technology, 0, 77, 8));
        this.addSlot(new SlotTechnology(player, technology, 1, 77, 8 + 18));
        this.addSlot(new SlotTechnology(player, technology, 2, 77, 8 + 2 * 18));
        this.addSlot(new SlotTechnology(player, technology, 3, 77, 8 + 3 * 18));
        //2
        this.addSlot(new SlotTechnology(player, technology, 4, 96, 8));
        this.addSlot(new SlotTechnology(player, technology, 5, 96, 8 + 18));
        this.addSlot(new SlotTechnology(player, technology, 6, 96, 8 + 2 * 18));
//3
        this.addSlot(new SlotTechnology(player, technology, 7, 114, 8 + 3 * 18));
        this.addSlot(new SlotTechnology(player, technology, 8, 132, 8 + 3 * 18));
        this.addSlot(new SlotTechnology(player, technology, 9, 150, 8 + 3 * 18));
        //4
        this.addSlot(new SlotTechnology(player, technology, 10, 170, 52));
        this.addSlot(new SlotTechnology(player, technology, 11, 170, 52 + 18));
        this.addSlot(new SlotTechnology(player, technology, 12, 170, 52 + 2 * 18));
        this.addSlot(new SlotTechnology(player, technology, 13, 170, 52 + 3 * 18));
        this.addSlot(new SlotTechnology(player, technology, 14, 170, 52 + 4 * 18));
        this.addSlot(new SlotTechnology(player, technology, 15, 170, 52 + 5 * 18));
        //5
        this.addSlot(new SlotTechnology(player, technology, 16, 188, 16));
        this.addSlot(new SlotTechnology(player, technology, 17, 188, 16 + 18));
        this.addSlot(new SlotTechnology(player, technology, 18, 188, 16 + 2 * 18));
        this.addSlot(new SlotTechnology(player, technology, 19, 188, 16 + 3 * 18));
        this.addSlot(new SlotTechnology(player, technology, 20, 188, 16 + 4 * 18));
        this.addSlot(new SlotTechnology(player, technology, 21, 188, 16 + 5 * 18));
        this.addSlot(new SlotTechnology(player, technology, 22, 188, 16 + 6 * 18));
        this.addSlot(new SlotTechnology(player, technology, 23, 188, 16 + 7 * 18));
        //6
        this.addSlot(new SlotTechnology(player, technology, 24, 206, 16));
        this.addSlot(new SlotTechnology(player, technology, 25, 206, 16 + 18));
        this.addSlot(new SlotTechnology(player, technology, 26, 206, 16 + 2 * 18));
        this.addSlot(new SlotTechnology(player, technology, 27, 206, 16 + 3 * 18));
        this.addSlot(new SlotTechnology(player, technology, 28, 206, 16 + 4 * 18));
        this.addSlot(new SlotTechnology(player, technology, 29, 206, 16 + 5 * 18));
        this.addSlot(new SlotTechnology(player, technology, 30, 206, 16 + 6 * 18));
        this.addSlot(new SlotTechnology(player, technology, 31, 206, 16 + 7 * 18));


        for (int l = 0; l < 3; ++l) {
            for (int j1 = 0; j1 < 9; ++j1) {
                this.addSlot(new Slot(playerInventory, j1 + (l + 1) * 9, 8 + j1 * 18, 84 + l * 18));
            }
        }

        for (int i1 = 0; i1 < 9; ++i1) {
            this.addSlot(new Slot(playerInventory, i1, 8 + i1 * 18, 142));
        }


        //副手
        this.addSlot(new OffHandSlot(playerInventory, 40, 96, 62));




    }


    @Override
    public void slotsChanged(@Nonnull Container container) {
        try {
            Method onCraftChange = ObfuscationReflectionHelper.findMethod(CraftingMenu.class, "m_150546_", AbstractContainerMenu.class, Level.class, Player.class, CraftingContainer.class, ResultContainer.class);
            onCraftChange.invoke(null, this, this.player.level, this.player, this.craftMatrix, this.craftResult);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void removed(@Nonnull Player player) {
        super.removed(player);
        this.craftResult.clearContent();

        if (!player.level.isClientSide) {
            this.clearContainer(player, this.craftMatrix);
        }
    }


    @Override
    public boolean stillValid(@Nonnull Player par1PlayerEntity) {
        return true;
    }

    @Override
    @Nonnull
    public ItemStack quickMoveStack(@Nonnull Player playerIn, int index) {
        var itemStack = ItemStack.EMPTY;
        var slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            var stackInSlot = slot.getItem();
            itemStack = stackInSlot.copy();

            var entityEquipmentSlot = Mob.getEquipmentSlotForItem(itemStack);

            int slotShift = technology.getSlots();

            if (index == 0) {
                if (!this.moveItemStackTo(stackInSlot, 9 + slotShift, 45 + slotShift, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(stackInSlot, itemStack);
            } else if (index >= 1 && index < 5) {
                if (!this.moveItemStackTo(stackInSlot, 9 + slotShift, 45 + slotShift, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 5 && index < 9) {
                if (!this.moveItemStackTo(stackInSlot, 9 + slotShift, 45 + slotShift, false)) {
                    return ItemStack.EMPTY;
                }
            }

            // baubles -> inv
            else if (index >= 9 && index < 9 + slotShift) {
                if (!this.moveItemStackTo(stackInSlot, 9 + slotShift, 45 + slotShift, false)) {
                    return ItemStack.EMPTY;
                }
            }

            // inv -> armor
            else if (entityEquipmentSlot.getType() == EquipmentSlot.Type.ARMOR && !(this.slots.get(8 - entityEquipmentSlot.getIndex())).hasItem()) {
                int i = 8 - entityEquipmentSlot.getIndex();

                if (!this.moveItemStackTo(stackInSlot, i, i + 1, false)) {
                    return ItemStack.EMPTY;
                }
            }

            // inv -> offhand
            else if (entityEquipmentSlot == EquipmentSlot.OFFHAND && !(this.slots.get(45 + slotShift)).hasItem()) {
                if (!this.moveItemStackTo(stackInSlot, 45 + slotShift, 46 + slotShift, false)) {
                    return ItemStack.EMPTY;
                }
            }
            // inv -> bauble
            else if (itemStack.getCapability(CapabilityTechnologys.ITEM_TECHNOLOGYS, null).isPresent()) {
                var bauble = itemStack.getCapability(CapabilityTechnologys.ITEM_TECHNOLOGYS, null).orElseThrow(NullPointerException::new);
                for (int baubleSlot : bauble.getTechnologyType(itemStack).getValidSlots()) {
                    if (bauble.canEquip(this.player) && !(this.slots.get(baubleSlot + 9)).hasItem() &&
                            !this.moveItemStackTo(stackInSlot, baubleSlot + 9, baubleSlot + 10, false)) {
                        return ItemStack.EMPTY;
                    }
                    if (stackInSlot.getCount() == 0) break;
                }
            } else if (index >= 9 + slotShift && index < 36 + slotShift) {
                if (!this.moveItemStackTo(stackInSlot, 36 + slotShift, 45 + slotShift, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 36 + slotShift && index < 45 + slotShift) {
                if (!this.moveItemStackTo(stackInSlot, 9 + slotShift, 36 + slotShift, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(stackInSlot, 9 + slotShift, 45 + slotShift, false)) {
                return ItemStack.EMPTY;
            }

            if (stackInSlot.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (stackInSlot.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            if (stackInSlot.isEmpty() && !technology.isEventBlocked() && slot instanceof SlotTechnology && itemStack.getCapability(CapabilityTechnologys.ITEM_TECHNOLOGYS, null).isPresent()) {
                var finalItemStack = itemStack;
                itemStack.getCapability(CapabilityTechnologys.ITEM_TECHNOLOGYS, null).ifPresent((iBauble -> iBauble.onEquipped(playerIn, finalItemStack)));
            }

            //TODO
            /*ItemStack itemstack2 = slot.onTake(playerIn, stackInSlot);

            if (index == 0) {
                playerIn.drop(itemstack2, false);
            }*/
        }

        return itemStack;
    }




    private boolean isHovering(int x, int y, int width, int height, int mouseX, int mouseY) {
        double relativeX = mouseX ;
        double relativeY = mouseY ;
        return relativeX >= x && relativeY >= y && relativeX < x + width && relativeY < y + height;
    }




    @Override
    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.craftResult && super.canTakeItemForPickAll(stack, slot);
    }


}
