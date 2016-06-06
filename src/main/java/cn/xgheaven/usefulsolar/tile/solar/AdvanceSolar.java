package cn.xgheaven.usefulsolar.tile.solar;

import cn.xgheaven.usefulsolar.tile.USBlocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by xgheaven on 6/6/16.
 */
public class AdvanceSolar extends BasicSolar{
    public AdvanceSolar() {
        super("advance_solar");
        USBlocks.registerBlock("advance_solar", this, AdvanceSolarTileEntity.class);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new AdvanceSolarTileEntity();
    }
}
