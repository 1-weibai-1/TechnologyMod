package baubles.client.gui;

import baubles.container.PlayerExpandedContainer;
import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.EffectRenderingInventoryScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import javax.annotation.Nonnull;

import static net.wei_bai.technology.TechnologyMod.KEY_TECHNOLOGY;
import static net.wei_bai.technology.TechnologyMod.MODID;

public class PlayerExpandedScreen extends EffectRenderingInventoryScreen<PlayerExpandedContainer> {

    public static final ResourceLocation BACKGROUND = new ResourceLocation(MODID, "textures/gui/expanded_inventory.png");

    protected int imageWidth = 229;

    private float oldMouseX;
    private float oldMouseY;

    public PlayerExpandedScreen(PlayerExpandedContainer container, Inventory inventory, Component name) {
        super(container, inventory, name);
    }

    @Override
    public void containerTick() {
        this.menu.technology.setEventBlock(false);
        this.canSeeEffects();
        this.resetGuiLeft();
    }

    @Override
    protected void init() {
        this.renderables.clear();
        super.init();
        this.resetGuiLeft();
    }


    @Override
    protected void renderLabels(@Nonnull PoseStack matrixStack, int mouseX, int mouseY) {
        if (this.minecraft != null) {
            this.minecraft.font.draw(matrixStack, new TranslatableComponent("container.crafting"), 115, 8, 4210752);
        }
    }

    @Override
    public void render(@Nonnull PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
        this.oldMouseX = (float) mouseX;
        this.oldMouseY = (float) mouseY;
    }

    @Override
    protected void renderBg(@Nonnull PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, BACKGROUND);
        if (this.minecraft != null && this.minecraft.player != null) {
            int k = this.leftPos;
            int l = this.topPos;
            this.blit(matrixStack, k, l, 0, 0, 229, 167);
            for (int i1 = 0; i1 < this.menu.slots.size(); ++i1) {
                var slot = this.menu.slots.get(i1);
                if (slot.hasItem() && slot.getMaxStackSize() == 1) {
                    this.blit(matrixStack, k + slot.x, l + slot.y, 236, 0, 16, 16);
                }

            }
            InventoryScreen.renderEntityInInventory(k + 51, l + 75, 30, (float) (k + 51) - this.oldMouseX, (float) l + 75  - this.oldMouseY, this.minecraft.player);
        }
    }


    @Override
    public boolean keyPressed(int keyCode, int scanCode, int what) {
        if (KEY_TECHNOLOGY.isActiveAndMatches(InputConstants.getKey(keyCode, scanCode))) {
            if (this.minecraft != null && this.minecraft.player != null) {
                this.minecraft.player.closeContainer();
            }
            return true;
        } else {
            return super.keyPressed(keyCode, scanCode, what);
        }
    }

    private void resetGuiLeft() {
        this.leftPos = (this.width - this.imageWidth-150) / 2;
    }
}