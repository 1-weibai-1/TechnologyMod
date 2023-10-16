package net.wei_bai.technology;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.IIngameOverlay;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.wei_bai.technology.network.TechnologyModVariables;

import static net.wei_bai.technology.TechnologyMod.MODID;

public class HealthBar implements IIngameOverlay {

	private static final ResourceLocation main_hud = new ResourceLocation(MODID, "textures/gui/main_hud_0.png");
	private static final ResourceLocation fullHealthBarLocation = new ResourceLocation(MODID, "textures/gui/main_hud_1.png");
	private static final ResourceLocation witherBarLocation = new ResourceLocation(MODID, "textures/gui/main_hud_1_wither.png");
	private static final ResourceLocation poisonBarLocation = new ResourceLocation(MODID, "textures/gui/main_hud_1_poison.png");
	private static final ResourceLocation frozenBarLocation = new ResourceLocation(MODID, "textures/gui/main_hud_1_frozen.png");
	private ResourceLocation currentBarLocation = fullHealthBarLocation;
	private static final ResourceLocation intermediateHealthBarLocation = new ResourceLocation(MODID, "textures/gui/main_hud_2.png");
	private static final ResourceLocation emptyHealthBarLocation = new ResourceLocation(MODID, "textures/gui/main_hud_3.png");
	private static final ResourceLocation main_hud_1_hunger = new ResourceLocation(MODID,"textures/gui/main_hud_1_hunger.png");
	private static final ResourceLocation main_hud_1_weakness = new ResourceLocation(MODID,"textures/gui/main_hud_1_weakness.png");
	private static final ResourceLocation main_hud_1_slowness = new ResourceLocation(MODID,"textures/gui/main_hud_1_slowness.png");
	//main_hud_1_slowness

	private static final ResourceLocation emptyHealthBarLocations = new ResourceLocation(MODID, "textures/gui/empty.png");
	private static final ResourceLocation absorptionBarLocation = new ResourceLocation(MODID, "textures/gui/absorption.png");
	private static final ResourceLocation guiIconsLocation = new ResourceLocation("minecraft", "textures/gui/icons.png");

	private float intermediateHealth = 0;

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void render(ForgeIngameGui gui, PoseStack poseStack, float partialTick, int width, int height) {
		if (gui.shouldDrawSurvivalElements()) {
			Font font = gui.getFont();
			Player player = (Player) Minecraft.getInstance().cameraEntity;
			if (player == null) return;
			float w = width/2;
			float x = (float) width / 2 - 91;
			float y = height - 39;
			updateBarTextures(player);
			renderHealthValue(font, poseStack, player,x,y,w);
			renderHealthBar(poseStack, partialTick, x, y, player);
			if (player.getAbsorptionAmount() > 0) {
				renderAbsorptionValue(font, poseStack, x, y, player);
				renderAbsorptionBar(poseStack, x, y, player);
			}

		}
	}


	public void updateBarTextures(Player player) {
		if (player.hasEffect(MobEffects.WITHER)) {
			currentBarLocation = witherBarLocation;
		}else if (player.hasEffect(MobEffects.DIG_SLOWDOWN)){
			currentBarLocation =main_hud_1_slowness;
		}else if (player.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)){
			currentBarLocation =main_hud_1_slowness;
		}else if (player.hasEffect(MobEffects.WEAKNESS)){
			currentBarLocation = main_hud_1_weakness;
		}else if (player.hasEffect(MobEffects.HUNGER)){
			currentBarLocation = main_hud_1_hunger;
		}else if (player.hasEffect(MobEffects.POISON)) {
			currentBarLocation = poisonBarLocation;
		} else if (player.isFullyFrozen()) {
			currentBarLocation = frozenBarLocation;
		} else {
			currentBarLocation = fullHealthBarLocation;
		}
	}


	private void renderHealthValue(Font font, PoseStack poseStack, Player player, float x, float y,float w) {

		//double max_health = (int) player.getMaxHealth();
		double max_health =(((player.getCapability(TechnologyModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TechnologyModVariables.PlayerVariables())).max_health));


		String text1 = "" + (new java.text.DecimalFormat("##.###").format(max_health));
		String text2 = "" + (new java.text.DecimalFormat("##.###").format(Math.ceil(player.getHealth() * 10) / 10));
		String text = text2 + "/" + text1;

		Minecraft.getInstance().font.draw(poseStack,  text2 + "/" + text1, w - font.width(text)-20, y + 1, 0xFF0000);
		RenderSystem.setShaderTexture(0, guiIconsLocation);
		// blit heart container
		GuiComponent.blit(poseStack,
				(int) (w -20), (int)y ,
				16, 0,
				9, 9,
				256, 256);
		RenderSystem.setShaderColor(255.0F, 0, 0.0F, 0.0F);
		GuiComponent.blit(poseStack,
				(int) (w -20), (int)y ,
				160, 0,
				9, 9,
				256, 256);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

	}

	private void renderHealthBar(PoseStack poseStack, float partialTick, float x, float y, Player player) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		float health = player.getHealth();
		float maxHealth = player.getMaxHealth();
		// Calculate bar proportions
		float healthProportion;
		float intermediateProportion;
		if (health < intermediateHealth) {
			healthProportion = health / maxHealth;
			intermediateProportion = (intermediateHealth - health) / maxHealth;
		} else {
			healthProportion = intermediateHealth / maxHealth;
			intermediateProportion = 0;
		}
		if (healthProportion > 1) healthProportion = 1F;
		if (healthProportion + intermediateProportion > 1) intermediateProportion = 1 - healthProportion;
		int healthWidth = (int) Math.ceil(181 * healthProportion);
		int intermediateWidth = (int) Math.ceil(181 * intermediateProportion);




		// 血皮
		RenderSystem.setShaderTexture(0, currentBarLocation);
		GuiComponent.blit(poseStack,
				48, 3,
				0, 0,
				healthWidth, 17,
				181, 17);
		// 受伤血
		RenderSystem.setShaderTexture(0, intermediateHealthBarLocation);
		GuiComponent.blit(poseStack,
				48 + healthWidth, 3,
				healthWidth, 0,
				intermediateWidth, 17,
				181, 17);
		// 血底
		RenderSystem.setShaderTexture(0, emptyHealthBarLocation);
		GuiComponent.blit(poseStack,
				48 + healthWidth + intermediateWidth, 3,
				healthWidth + intermediateWidth, 0,
				181 - healthWidth - intermediateWidth, 17,
				181, 17);
		// Update intermediate health
		this.intermediateHealth += (health - intermediateHealth) * partialTick * 0.08;
		if (Math.abs(health - intermediateHealth) <= 0.25) {
			this.intermediateHealth = health;
		}
	}

	private void renderAbsorptionValue(Font font, PoseStack poseStack, float x, float y, Player player) {
		double absorption = Math.ceil(player.getAbsorptionAmount());
		String text = String.valueOf(absorption / 2);
		text = text.replace(".0", "");
		font.draw(poseStack, text, x - font.width(text) - 16, y - 9, 0xFFFF00);
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.setShaderTexture(0, guiIconsLocation);
		// blit heart container
		GuiComponent.blit(poseStack,
				(int) x - 16, (int) y - 10,
				16, 0,
				9, 9,
				256, 256);
		// blit heart
		RenderSystem.setShaderColor(255.0F, 255.0F, 0.0F, 0.0F);
		GuiComponent.blit(poseStack,
				(int) x - 16, (int) y - 10,
				160, 0,
				9, 9,
				256, 256);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
	}

	private void renderAbsorptionBar(PoseStack poseStack, float x, float y, Player player) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		float absorption = player.getAbsorptionAmount();
		float maxHealth = player.getMaxHealth();
		// Calculate bar proportions
		float absorptionProportion = absorption / maxHealth;
		if (absorptionProportion > 1) absorptionProportion = 1F;
		int absorptionWidth = (int) Math.ceil(80 * absorptionProportion);
		// Display full part
		RenderSystem.setShaderTexture(0, absorptionBarLocation);
		GuiComponent.blit(poseStack,
				(int) x, (int) y - 10,
				0, 0,
				absorptionWidth, 9,
				80, 9);
		// Display empty part
		RenderSystem.setShaderTexture(0, emptyHealthBarLocations);
		GuiComponent.blit(poseStack,
				(int) x + absorptionWidth, (int) y - 10,
				absorptionWidth, 0,
				80 - absorptionWidth, 9,
				80, 9);
	}

}
