package baubles.api.technology;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

/**
 * This interface should be extended by items that can be worn in bauble slots
 *
 * @author Azanor
 * @author lazynessmind - porter
 */

@SuppressWarnings("unused")
public interface ITechnology {



    /**
     * Get the attack boost of this technology.
     *
     * @param stack The item stack.
     * @return The attack boost of this technology.
     */


    TechnologyType getTechnologyType(ItemStack stack);

    /**
     *如果玩家佩戴小玩意，则每次刻度调用一次此方法
     */
    default void onWornTick(LivingEntity player, ItemStack stack) {
    }

    /**
     *当玩家装备小玩意时调用此方法
     */
    default void onEquipped(LivingEntity player, ItemStack stack) {
    }

    /**
     * 当玩家没有装备小玩意时调用此方法
     */
    default void onUnequipped(LivingEntity player, ItemStack stack) {
    }


    /**
     * 这个小玩意可以放在小玩意槽里吗？
     */
    default boolean canEquip(LivingEntity player) {
        return true;
    }

    /**
     * 这个小玩意可以从小玩意槽中取出吗？
     */
    default boolean canUnequip(LivingEntity player) {
        return true;
    }

    /**
     * 如果检测到其NBT或损坏值发生变化，bauble会自动同步到客户端吗？
     *      *默认为关闭，因此如果要自动同步，请覆盖并设置为true。
     *      *此同步不是即时的，而是每10个滴答（.5秒）发生一次。
     */
    default boolean willAutoSync(LivingEntity player) {
        return false;
    }


}