
package net.wei_bai.technology.client.gui;

import net.wei_bai.technology.world.inventory.StoneToolWorkbenchGuiMenu;
import net.wei_bai.technology.procedures.TruetrueProcedure;
import net.wei_bai.technology.procedures.Time_baifengbiProcedure;
import net.wei_bai.technology.procedures.Tick_maxProcedure;
import net.wei_bai.technology.procedures.TickProcedure;
import net.wei_bai.technology.procedures.Slot_2_levelProcedure;
import net.wei_bai.technology.procedures.Slot_2_idProcedure;
import net.wei_bai.technology.procedures.Slot_1_levelProcedure;
import net.wei_bai.technology.procedures.Slot_0_levelProcedure;
import net.wei_bai.technology.procedures.Slot_0_idProcedure;
import net.wei_bai.technology.procedures.Slot1idProcedure;
import net.wei_bai.technology.procedures.ProgressBar9StonetoolworkbenchProcedure;
import net.wei_bai.technology.procedures.ProgressBar8StonetoolworkbenchProcedure;
import net.wei_bai.technology.procedures.ProgressBar7StonetoolworkbenchProcedure;
import net.wei_bai.technology.procedures.ProgressBar6StonetoolworkbenchProcedure;
import net.wei_bai.technology.procedures.ProgressBar5StonetoolworkbenchProcedure;
import net.wei_bai.technology.procedures.ProgressBar4StonetoolworkbenchProcedure;
import net.wei_bai.technology.procedures.ProgressBar3StonetoolworkbenchProcedure;
import net.wei_bai.technology.procedures.ProgressBar2StonetoolworkbenchProcedure;
import net.wei_bai.technology.procedures.ProgressBar1StonetoolworkbenchProcedure;
import net.wei_bai.technology.procedures.ProgressBar15StonetoolworkbenchProcedure;
import net.wei_bai.technology.procedures.ProgressBar14StonetoolworkbenchProcedure;
import net.wei_bai.technology.procedures.ProgressBar13StonetoolworkbenchProcedure;
import net.wei_bai.technology.procedures.ProgressBar12StonetoolworkbenchProcedure;
import net.wei_bai.technology.procedures.ProgressBar11StonetoolworkbenchProcedure;
import net.wei_bai.technology.procedures.ProgressBar10StonetoolworkbenchProcedure;
import net.wei_bai.technology.procedures.Item_trueProcedure;
import net.wei_bai.technology.network.StoneToolWorkbenchGuiButtonMessage;
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

public class StoneToolWorkbenchGuiScreen extends AbstractContainerScreen<StoneToolWorkbenchGuiMenu> {
	private final static HashMap<String, Object> guistate = StoneToolWorkbenchGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_zhi_zuo;

	public StoneToolWorkbenchGuiScreen(StoneToolWorkbenchGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 199;
	}

	private static final ResourceLocation texture = new ResourceLocation("technology:textures/screens/stone_tool_workbench_gui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/arrow3.png"));
		this.blit(ms, this.leftPos + 43, this.topPos + 41, 0, 0, 75, 31, 75, 31);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 50, this.topPos + 19, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 21, this.topPos + 47, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 50, this.topPos + 75, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 119, this.topPos + 47, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/progress_bar.png"));
		this.blit(ms, this.leftPos + 140, this.topPos + 47, 0, 0, 9, 19, 9, 19);

		if (ProgressBar1StonetoolworkbenchProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/progress_bar_1.png"));
			this.blit(ms, this.leftPos + 142, this.topPos + 49, 0, 0, 5, 15, 5, 15);
		}
		if (ProgressBar2StonetoolworkbenchProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/progress_bar_2.png"));
			this.blit(ms, this.leftPos + 142, this.topPos + 49, 0, 0, 5, 15, 5, 15);
		}
		if (ProgressBar3StonetoolworkbenchProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/progress_bar_3.png"));
			this.blit(ms, this.leftPos + 142, this.topPos + 49, 0, 0, 5, 15, 5, 15);
		}
		if (ProgressBar4StonetoolworkbenchProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/progress_bar_4.png"));
			this.blit(ms, this.leftPos + 142, this.topPos + 49, 0, 0, 5, 15, 5, 15);
		}
		if (ProgressBar5StonetoolworkbenchProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/progress_bar_5.png"));
			this.blit(ms, this.leftPos + 142, this.topPos + 49, 0, 0, 5, 15, 5, 15);
		}
		if (ProgressBar6StonetoolworkbenchProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/progress_bar_6.png"));
			this.blit(ms, this.leftPos + 142, this.topPos + 49, 0, 0, 5, 15, 5, 15);
		}
		if (ProgressBar7StonetoolworkbenchProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/progress_bar_7.png"));
			this.blit(ms, this.leftPos + 142, this.topPos + 49, 0, 0, 5, 15, 5, 15);
		}
		if (ProgressBar8StonetoolworkbenchProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/progress_bar_8.png"));
			this.blit(ms, this.leftPos + 142, this.topPos + 49, 0, 0, 5, 15, 5, 15);
		}
		if (ProgressBar9StonetoolworkbenchProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/progress_bar_9.png"));
			this.blit(ms, this.leftPos + 142, this.topPos + 49, 0, 0, 5, 15, 5, 15);
		}
		if (ProgressBar10StonetoolworkbenchProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/progress_bar_10.png"));
			this.blit(ms, this.leftPos + 142, this.topPos + 49, 0, 0, 5, 15, 5, 15);
		}
		if (ProgressBar11StonetoolworkbenchProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/progress_bar_11.png"));
			this.blit(ms, this.leftPos + 142, this.topPos + 49, 0, 0, 5, 15, 5, 15);
		}
		if (ProgressBar12StonetoolworkbenchProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/progress_bar_12.png"));
			this.blit(ms, this.leftPos + 142, this.topPos + 49, 0, 0, 5, 15, 5, 15);
		}
		if (ProgressBar13StonetoolworkbenchProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/progress_bar_13.png"));
			this.blit(ms, this.leftPos + 142, this.topPos + 49, 0, 0, 5, 15, 5, 15);
		}
		if (ProgressBar14StonetoolworkbenchProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/progress_bar_14.png"));
			this.blit(ms, this.leftPos + 142, this.topPos + 49, 0, 0, 5, 15, 5, 15);
		}
		if (ProgressBar15StonetoolworkbenchProcedure.execute(world, x, y, z)) {
			RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/progress_bar_15.png"));
			this.blit(ms, this.leftPos + 142, this.topPos + 49, 0, 0, 5, 15, 5, 15);
		}

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 6, this.topPos + 117, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 24, this.topPos + 117, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 24, this.topPos + 153, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 42, this.topPos + 135, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 6, this.topPos + 153, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 60, this.topPos + 117, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 60, this.topPos + 153, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 78, this.topPos + 135, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 96, this.topPos + 153, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 96, this.topPos + 117, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 96, this.topPos + 135, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 78, this.topPos + 117, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 78, this.topPos + 153, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 42, this.topPos + 117, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 6, this.topPos + 135, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 24, this.topPos + 135, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 42, this.topPos + 153, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 60, this.topPos + 135, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 132, this.topPos + 135, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 150, this.topPos + 117, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 150, this.topPos + 153, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 114, this.topPos + 117, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 114, this.topPos + 153, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 114, this.topPos + 135, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 150, this.topPos + 135, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 132, this.topPos + 117, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 132, this.topPos + 153, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 6, this.topPos + 175, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 24, this.topPos + 175, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 42, this.topPos + 175, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 60, this.topPos + 175, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 78, this.topPos + 175, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 96, this.topPos + 175, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 114, this.topPos + 175, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 132, this.topPos + 175, 0, 0, 19, 19, 19, 19);

		RenderSystem.setShaderTexture(0, new ResourceLocation("technology:textures/screens/lattice_0.png"));
		this.blit(ms, this.leftPos + 150, this.topPos + 175, 0, 0, 19, 19, 19, 19);

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

				Slot_0_levelProcedure.execute(world, x, y, z), 2, 52, -12829636);
		this.font.draw(poseStack,

				Slot_1_levelProcedure.execute(world, x, y, z), 33, 23, -12829636);
		this.font.draw(poseStack,

				Slot_2_levelProcedure.execute(world, x, y, z), 31, 80, -12829636);
		this.font.draw(poseStack,

				TickProcedure.execute(world, x, y, z), 149, 33, -12829636);
		this.font.draw(poseStack,

				Tick_maxProcedure.execute(world, x, y, z), 150, 47, -12829636);
		this.font.draw(poseStack,

				Time_baifengbiProcedure.execute(world, x, y, z), 150, 61, -12829636);
		this.font.draw(poseStack,

				TruetrueProcedure.execute(world, x, y, z), 124, 97, -12829636);
		this.font.draw(poseStack,

				Item_trueProcedure.execute(world, x, y, z), 61, 44, -12829636);
		this.font.draw(poseStack,

				Slot_0_idProcedure.execute(world, x, y, z), 21, 38, -12829636);
		this.font.draw(poseStack,

				Slot1idProcedure.execute(world, x, y, z), 51, 8, -12829636);
		this.font.draw(poseStack,

				Slot_2_idProcedure.execute(world, x, y, z), 50, 95, -12829636);
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
		button_zhi_zuo = new Button(this.leftPos + 114, this.topPos + 77, 35, 20, new TranslatableComponent("gui.technology.stone_tool_workbench_gui.button_zhi_zuo"), e -> {
			if (true) {
				TechnologyMod.PACKET_HANDLER.sendToServer(new StoneToolWorkbenchGuiButtonMessage(0, x, y, z));
				StoneToolWorkbenchGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_zhi_zuo", button_zhi_zuo);
		this.addRenderableWidget(button_zhi_zuo);
	}
}
