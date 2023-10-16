package baubles.api.cap;


import baubles.api.technology.ITechnology;
import baubles.api.technology.ITechnologysItemHandler;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class CapabilityTechnologys {
    public static final Capability<ITechnologysItemHandler> TECHNOLOGY = CapabilityManager.get(new CapabilityToken<>() {});
    public static final Capability<ITechnology> ITEM_TECHNOLOGYS = CapabilityManager.get(new CapabilityToken<>() {});


}