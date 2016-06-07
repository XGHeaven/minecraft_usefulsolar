package cn.xgheaven.usefulsolar.tile;

import cn.xgheaven.usefulsolar.tile.fuel.FuelBlock;
import cn.xgheaven.usefulsolar.tile.solar.AdvanceSolar;
import cn.xgheaven.usefulsolar.tile.solar.BasicSolarTileEntity;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by xgheaven on 6/5/16.
 */
public class USBlocks {
    public static Block advance_solar;
    public static Block hybird_solar;
    public static Block advance_hybird_solar;

    // fuel
    public static Block lava_block;
    public static Block lava_coal_block;

    public static void createBlocks() {
        advance_solar = new AdvanceSolar();
        lava_block = new FuelBlock("lava_block", 18000, 0.8f);
        lava_coal_block = new FuelBlock("lava_coal_block", 50000, 0.5f);
    }

    public static void registerBlock(String name, Block block, Class<? extends BasicSolarTileEntity> te) {
        GameRegistry.registerBlock(block, name);
        GameRegistry.registerTileEntity(te, name+"_tileentity");
    }

    public static void registerBlock(String name, Block block) {
        GameRegistry.registerBlock(block, name);
    }
}
