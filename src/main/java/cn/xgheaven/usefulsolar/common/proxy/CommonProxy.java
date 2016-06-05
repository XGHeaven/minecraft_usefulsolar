package cn.xgheaven.usefulsolar.common.proxy;

import cn.xgheaven.usefulsolar.tile.USBlocks;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by xgheaven on 6/5/16.
 */
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        USBlocks.createBlocks();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
