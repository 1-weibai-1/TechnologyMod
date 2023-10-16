package baubles.client.renderer;

import baubles.api.cap.CapabilityTechnologys;
import baubles.api.render.IRenderTechnology;
import baubles.api.technology.ITechnologysItemHandler;
import baubles.setup.ModConfigs;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

@SuppressWarnings("ConstantConditions")
public class TechnologyRenderLayer<T extends Player, M extends PlayerModel<T>> extends RenderLayer<T, M> {

    public TechnologyRenderLayer(RenderLayerParent<T, M> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(PoseStack matrixStack, MultiBufferSource iRenderTypeBuffer, int i, Player player, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {

        if (!ModConfigs.RENDER_TECHNOLOGY.get() || player.getEffect(MobEffects.INVISIBILITY) != null)
            return;

        player.getCapability(CapabilityTechnologys.TECHNOLOGY).ifPresent(inv -> {

            this.dispatchRenders(matrixStack, inv, player, IRenderTechnology.RenderType.BODY, partialTicks);

            float yaw = player.yHeadRotO + (player.yHeadRot - player.yHeadRotO) * partialTicks;
            float yawOffset = player.yBodyRotO + (player.yBodyRot - player.yBodyRotO) * partialTicks;
            float xRot = ObfuscationReflectionHelper.getPrivateValue(Entity.class, player, "f_19858_");
            float pitch = player.xRotO + (xRot - player.xRotO) * partialTicks;

            matrixStack.pushPose();
            matrixStack.mulPose(Vector3f.YN.rotationDegrees(yawOffset));
            matrixStack.mulPose(Vector3f.YP.rotationDegrees(yaw - 270));
            matrixStack.mulPose(Vector3f.ZP.rotationDegrees(pitch));
            this.dispatchRenders(matrixStack, inv, player, IRenderTechnology.RenderType.HEAD, partialTicks);
            matrixStack.popPose();
        });
    }

    private void dispatchRenders(PoseStack poseStack, ITechnologysItemHandler inv, Player player, IRenderTechnology.RenderType type, float partialTicks) {
        for (int i = 0; i < inv.getSlots(); i++) {
            ItemStack stack = inv.getStackInSlot(i);
            if (!stack.isEmpty()) {
                stack.getCapability(CapabilityTechnologys.ITEM_TECHNOLOGYS).ifPresent(bauble -> {
                    if (bauble instanceof IRenderTechnology rb) {
                        poseStack.pushPose();
                        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
                        rb.onPlayerBaubleRender(poseStack, player, type, partialTicks);
                        poseStack.popPose();
                    }
                });
            }
        }
    }
}