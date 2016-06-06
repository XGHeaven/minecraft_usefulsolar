package cn.xgheaven.usefulsolar.tile;

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

    public static void createBlocks() {
        advance_solar = new AdvanceSolar();
    }

    public static void registerBlock(String name, Block block, Class<? extends BasicSolarTileEntity> te) {
        GameRegistry.registerBlock(block, name);
        GameRegistry.registerTileEntity(te, name+"_tileentity");
    }
}
