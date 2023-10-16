package baubles.api.render;

import baubles.api.technology.ITechnology;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;

/**
 * 实现这一点的Bauble Item将有挂钩来渲染某些东西
 *  *玩家装备时。
 *  *此类不会扩展IBauble以使API不依赖于Bauble
 *  *API，但有问题的项目仍然需要实现IBauble。
 */
public interface IRenderTechnology extends ITechnology {

    /**
     * 调用在播放器上渲染小玩意。播放器实例可以是
     *      *通过事件参数获取。已应用转换
     *      *传入的RenderType。确保检查类型参数
     *      *渲染。
     */
    void onPlayerBaubleRender(PoseStack stack, Player player, RenderType type, float partialTicks);


    /**
     * 渲染的一些辅助方法。
     */
    final class Helper {

        /**
         * 如果玩家正在偷偷摸摸，则正确旋转小玩意的渲染。
         *          *用于{@link RenderType#BODY}下的渲染。
         */
        public static void rotateIfSneaking(PoseStack stack, Player player) {
            if (player.isCrouching())
                applySneakingRotation(stack);
        }

        /**
         * Rotates the render for a bauble correctly for a sneaking player.
         *          * Use for renders under {@link RenderType#BODY}.
         */
        public static void applySneakingRotation(PoseStack stack) {
            stack.translate(0f, .2f, 0f);
            stack.mulPose(Vector3f.XP.rotationDegrees(90f / (float)Math.PI));
        }

        /**
         * 将小玩意的渲染正确地移到头部，包括偷偷旋转。
         *          *用于{@link RenderType#HEAD}下的渲染。
         */
        public static void translateToHeadLevel(PoseStack stack, Player player) {
            stack.translate(0, -player.getEyeHeight(), 0);
            if (player.isCrouching())
                stack.translate(0.25F * Mth.sin(player.yHeadRot * (float) Math.PI / 180), 0.25F * Mth.cos(player.yHeadRot * (float) Math.PI / 180), 0F);
        }

        /**
         *将小玩意的渲染正确地移动到面部。
         *用于{@link RenderType#HEAD}下的渲染，通常在调用{@link Helper#translateToHeadLevel（PoseStack， Player）}之后。
         */
        public static void translateToFace(PoseStack stack) {
            stack.mulPose(Vector3f.YP.rotationDegrees(90f));
            stack.mulPose(Vector3f.XP.rotationDegrees(180f));
            stack.translate(0f, -4.35f, -1.27f);
        }

        /**
         * 将渲染缩小到正确的大小。
         *          *用于任何渲染。
         */
        public static void defaultTransforms(PoseStack stack) {
            stack.translate(0.0f, 3.0f, 1.0f);
            stack.scale(0.55f, 0.55f, 0.55f);
        }

        /**
         *将小玩意的渲染正确地移到胸部。
         *用于{@link RenderType#BODY}下的渲染，通常在调用{@link Helper#rotateIfSneaking(PoseStack, Player)}之后使用。
         */
        public static void translateToChest(PoseStack stack) {
            stack.mulPose(Vector3f.XP.rotationDegrees(180f));
            stack.translate(0F, -3.2F, -0.85F);
        }
    }

    enum RenderType {
        /**
         *渲染类型为球员的身体，翻译适用于球员的旋转。
         *潜行不会被处理，应该在渲染期间完成。
         *
         * @see Helper
         */
        BODY,

        /**
         *渲染类型为玩家的身体，翻译适用于玩家的头部旋转。
         *潜行不会被处理，应该在渲染期间完成。
         *
         * @see Helper
         */
        HEAD;
    }
}