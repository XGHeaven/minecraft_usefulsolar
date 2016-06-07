package cn.xgheaven.usefulsolar.common.proxy;

import cn.xgheaven.usefulsolar.recipe.USRecipe;
import cn.xgheaven.usefulsolar.tile.USBlocks;
import cn.xgheaven.usefulsolar.tile.fuel.FuelHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by xgheaven on 6/5/16.
 */
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        USBlocks.createBlocks();
        FuelHandler.registerFuelHandler();
    }

    public void init(FMLInitializationEvent e) {
        USRecipe.createRecipe();
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
