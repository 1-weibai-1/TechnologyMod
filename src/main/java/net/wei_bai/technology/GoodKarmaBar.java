package net.wei_bai.technology;

public class GoodKarmaBar{ /*implements IIngameOverlay {
    protected static final ResourceLocation GOODKARMABAR = new ResourceLocation("textures/gui/widgets.png");
    protected final Minecraft minecraft;
    protected int screenHeight;
    protected int screenWidth;
    public int experienceLevel;
    public float experienceProgress;
    public GoodKarmaBar(Minecraft minecraft) {
        this.minecraft = minecraft;
    }
    public Font getFont() {
        return this.minecraft.font;
    }
    @Override
    public void render(ForgeIngameGui gui, PoseStack poseStack, float partialTick, int width, int height) {
        if (gui.shouldDrawSurvivalElements()) {
            renderExperienceBar(poseStack, height);
        }
    }

    public int getXpNeededForNextLevel() {
        if (this.experienceLevel >= 30) {
            return 112 + (this.experienceLevel - 30) * 9;
        } else {
            return this.experienceLevel >= 15 ? 37 + (this.experienceLevel - 15) * 5 : 7 + this.experienceLevel * 2;
        }
    }
    public void renderExperienceBar(PoseStack p_93072_, int p_93073_) {
        this.minecraft.getProfiler().push("expBar");
        RenderSystem.setShaderTexture(0, GuiComponent.GUI_ICONS_LOCATION);
        int i = getXpNeededForNextLevel();
        if (i > 0) {
            int j = 182;
            int k = (int)(this.minecraft.player.experienceProgress * 183.0F);
            int l = this.screenHeight - 32 + 3;
            RenderSystem.setShaderTexture(0, GOODKARMABAR);
            this.blit(p_93072_, p_93073_, l, 0, 64, 182, 5);
            if (k > 0) {
                this.blit(p_93072_, p_93073_, l, 0, 69, k, 5);
            }
        }

        this.minecraft.getProfiler().pop();
        if (this.minecraft.player.experienceLevel > 0) {
            this.minecraft.getProfiler().push("expLevel");
            String s = "" + this.minecraft.player.experienceLevel;
            int i1 = (this.screenWidth - this.getFont().width(s)) / 2;
            int j1 = this.screenHeight - 31 - 4;
            this.getFont().draw(p_93072_, s, (float)(i1 + 1), (float)j1, 0);
            this.getFont().draw(p_93072_, s, (float)(i1 - 1), (float)j1, 0);
            this.getFont().draw(p_93072_, s, (float)i1, (float)(j1 + 1), 0);
            this.getFont().draw(p_93072_, s, (float)i1, (float)(j1 - 1), 0);
            this.getFont().draw(p_93072_, s, (float)i1, (float)j1, 8453920);
            this.minecraft.getProfiler().pop();
        }

    }*/
}
