package cn.xgheaven.usefulsolar.utils;

import ic2.api.energy.event.EnergyTileEvent;
import net.minecraftforge.common.MinecraftForge;

/**
 * Created by xgheaven on 6/5/16.
 */
public class USEvent {
    /**
     * post event to minecraft forge event bus
     * @param e {EnergyTileEvent} event to post
     */
    public static void mfpost(EnergyTileEvent e) {
        MinecraftForge.EVENT_BUS.post(e);
    }
}
