package cn.xgheaven.usefulsolar.tile;

import cn.xgheaven.usefulsolar.tile.solar.AdvanceSolar;
import cn.xgheaven.usefulsolar.tile.solar.AdvanceSolarTileEntity;
import cn.xgheaven.usefulsolar.tile.solar.BasicSolar;
import cn.xgheaven.usefulsolar.tile.solar.BasicSolarTileEntity;
import cn.xgheaven.usefulsolar.tile.test.DataBlock;
import ic2.api.energy.prefab.BasicSource;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by xgheaven on 6/5/16.
 */
public class USBlocks {
    public static Block advance_solar;
    public static Block hybird_solar;
    public static Block advance_hybird_solar;

    public static void createBlocks() {
        advance_solar = new AdvanceSolar();
    }

    public static void registerBlock(String name, Block block, Class<? extends BasicSolarTileEntity> te) {
        GameRegistry.registerBlock(block, name);
        GameRegistry.registerTileEntity(te, name+"_tileentity");
    }
}
