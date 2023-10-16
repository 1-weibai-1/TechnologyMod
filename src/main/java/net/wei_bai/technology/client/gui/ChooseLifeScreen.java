
package net.wei_bai.technology.client.gui;

import net.wei_bai.technology.world.inventory.ChooseLifeMenu;
import net.wei_bai.technology.procedures.VARChoose_lifeProcedure;
import net.wei_bai.technology.network.ChooseLifeButtonMessage;
import net.wei_bai.technology.TechnologyMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ChooseLifeScreen extends AbstractContainerScreen<ChooseLifeMenu> {
	private final static HashMap<String, Object> guistate = ChooseLifeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	Button button_empty1;
	Button button_que_ding;
	Button button_empty2;
	Button button_empty3;
	Button button_empty4;
	Button button_empty5;

	public ChooseLifeScreen(ChooseLifeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 183;
		this.imageHeight = 204;
	}

	private static final ResourceLocation texture = new ResourceLocation("technology:textures/screens/choose_life.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack,

				VARChoose_lifeProcedure.execute(entity), 79, 13, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.technology.choose_life.label_xiu_fa_dao_lu"), 73, 40, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.technology.choose_life.label_dao_fa_ze"), 83, 67, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_empty = new Button(this.leftPos + 8, this.topPos + 8, 30, 20, new TranslatableComponent("gui.technology.choose_life.button_empty"), e -> {
			if (true) {
				TechnologyMod.PACKET_HANDLER.sendToServer(new ChooseLifeButtonMessage(0, x, y, z));
				ChooseLifeButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = new Button(this.leftPos + 145, this.topPos + 8, 30, 20, new TranslatableComponent("gui.technology.choose_life.button_empty1"), e -> {
			if (true) {
				TechnologyMod.PACKET_HANDLER.sendToServer(new ChooseLifeButtonMessage(1, x, y, z));
				ChooseLifeButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
		button_que_ding = new Button(this.leftPos + 73, this.topPos + 179, 35, 20, new TranslatableComponent("gui.technology.choose_life.button_que_ding"), e -> {
			if (true) {
				TechnologyMod.PACKET_HANDLER.sendToServer(new ChooseLifeButtonMessage(2, x, y, z));
				ChooseLifeButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_que_ding", button_que_ding);
		this.addRenderableWidget(button_que_ding);
		button_empty2 = new Button(this.leftPos + 8, this.topPos + 33, 30, 20, new TranslatableComponent("gui.technology.choose_life.button_empty2"), e -> {
		});
		guistate.put("button:button_empty2", button_empty2);
		this.addRenderableWidget(button_empty2);
		button_empty3 = new Button(this.leftPos + 145, this.topPos + 33, 30, 20, new TranslatableComponent("gui.technology.choose_life.button_empty3"), e -> {
		});
		guistate.put("button:button_empty3", button_empty3);
		this.addRenderableWidget(button_empty3);
		button_empty4 = new Button(this.leftPos + 145, this.topPos + 60, 30, 20, new TranslatableComponent("gui.technology.choose_life.button_empty4"), e -> {
		});
		guistate.put("button:button_empty4", button_empty4);
		this.addRenderableWidget(button_empty4);
		button_empty5 = new Button(this.leftPos + 8, this.topPos + 60, 30, 20, new TranslatableComponent("gui.technology.choose_life.button_empty5"), e -> {
		});
		guistate.put("button:button_empty5", button_empty5);
		this.addRenderableWidget(button_empty5);
	}
}
