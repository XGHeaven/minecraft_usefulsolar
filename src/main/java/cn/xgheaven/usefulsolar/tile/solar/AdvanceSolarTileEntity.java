package cn.xgheaven.usefulsolar.tile.solar;

/**
 * Created by xgheaven on 6/6/16.
 */
public class AdvanceSolarTileEntity extends BasicSolarTileEntity {
    private static double maxGen = 8;
    private static double cap = 32000;
    private static int tier = 1;

    @Override
    public int getTier() {
        return AdvanceSolarTileEntity.tier;
    }

    @Override
    public double getMaxGen() {
        return AdvanceSolarTileEntity.maxGen;
    }

    @Override
    public double getCapacity() {
        return AdvanceSolarTileEntity.cap;
    }
}
