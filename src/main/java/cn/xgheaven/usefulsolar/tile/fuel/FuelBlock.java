package cn.xgheaven.usefulsolar.tile.fuel;

import cn.xgheaven.usefulsolar.tile.USBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by xgheaven on 6/7/16.
 */
public class FuelBlock extends Block implements USFuel {
    private int burnTime = 0;

    public FuelBlock(String name, int burnTime) {
        super(Material.rock);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(2);
        this.setHarvestLevel("pickaxe", 1);

        this.burnTime = burnTime;

        USBlocks.registerBlock(name, this);
    }

    public FuelBlock(String name, int burnTime, float light) {
        this(name, burnTime);
        this.setLightLevel(light);
    }

    @Override
    public int getBurnTime() {
        return this.burnTime;
    }
}
