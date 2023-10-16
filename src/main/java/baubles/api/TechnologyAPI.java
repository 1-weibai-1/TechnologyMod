package baubles.api;


import baubles.api.cap.CapabilityTechnologys;
import baubles.api.technology.ITechnologysItemHandler;
import baubles.api.technology.TechnologyType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.util.LazyOptional;
import net.wei_bai.technology.TechnologyMod;

/**
 * @author Azanor
 * @author lazynessmind - porter
 */
@SuppressWarnings({"ConstantConditions", "unused"})
public class TechnologyAPI {

    public static final String MOD_ID = TechnologyMod.MODID;

    //检索提供的播放器的小玩意库存能力处理程序
    public static LazyOptional<ITechnologysItemHandler> getBaublesHandler(Player player) {
        return player.getCapability(CapabilityTechnologys.TECHNOLOGY);
    }

    //如果传入的项目配备在小插槽中，则返回。将返回找到的第一个插槽
    //@如果找不到则返回-1，如果找到则返回插槽号
    public static int isBaubleEquipped(Player player, Item bauble) {
        return getBaublesHandler(player).map(handler -> {
            for (int a = 0; a < handler.getSlots(); a++) {
                if (!handler.getStackInSlot(a).isEmpty() && handler.getStackInSlot(a).getItem() == bauble)
                    return a;
            }
            return -1;
        }).orElse(-1);
    }

    public static int getEmptySlotForBaubleType(Player playerEntity, TechnologyType type) {
        ITechnologysItemHandler itemHandler = getBaublesHandler(playerEntity).orElseThrow(NullPointerException::new);

        for (int i : type.getValidSlots()) {
            if (itemHandler.getStackInSlot(i).isEmpty()) {
                return i;
            }
        }

        return -1;
    }

}