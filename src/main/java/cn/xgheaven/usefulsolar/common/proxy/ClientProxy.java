package cn.xgheaven.usefulsolar.common.proxy;

import cn.xgheaven.usefulsolar.tile.BlockRender;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by xgheaven on 6/5/16.
 */
public final class ClientProxy extends CommonProxy {
    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        BlockRender.registerRender();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }
}
