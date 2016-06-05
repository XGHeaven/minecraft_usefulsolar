package cn.xgheaven.usefulsolar.tile;

import cn.xgheaven.usefulsolar.tile.solar.BasicSolar;
import cn.xgheaven.usefulsolar.tile.solar.BasicSolarTileEntity;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by xgheaven on 6/5/16.
 */
public class USBlocks {
    public static Block advence_solar;
    public static Block hybird_solar;
    public static Block advence_hybird_solar;

    public static void createBlocks() {
        GameRegistry.registerTileEntity(BasicSolarTileEntity.class, "BasicSolarTileEntity");

        advence_solar = new BasicSolar("advence_solar", 32000, 8, 1);
        GameRegistry.registerBlock(advence_solar, "advence_solar");
    }
}
