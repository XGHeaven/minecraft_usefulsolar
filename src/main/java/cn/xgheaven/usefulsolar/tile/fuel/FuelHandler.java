package cn.xgheaven.usefulsolar.tile.fuel;

import cn.xgheaven.usefulsolar.tile.USBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by xgheaven on 6/7/16.
 */
public class FuelHandler implements IFuelHandler {

    private static Block[] fuelList = {
            USBlocks.lava_block,
            USBlocks.lava_coal_block
    };

    public static void registerFuelHandler() {
        GameRegistry.registerFuelHandler(new FuelHandler());
    }

    @Override
    public int getBurnTime(ItemStack stack) {
        Item fuel = stack.getItem();

        for (Block f : FuelHandler.fuelList) {
            if (Item.getItemFromBlock(f) == fuel) return ((USFuel)f).getBurnTime();
        }

        return 0;
    }
}
