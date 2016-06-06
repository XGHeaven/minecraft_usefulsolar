package cn.xgheaven.usefulsolar.recipe;

import cn.xgheaven.usefulsolar.tile.USBlocks;
import ic2.api.item.IC2Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by xgheaven on 6/6/16.
 */
public class SolarRecipe {
    static void createRecipe() {
        GameRegistry.addRecipe(
                new ItemStack(USBlocks.advance_solar),
                "ABA", "CDC", "CSC",
                'S', IC2Items.getItem("te", "solar_generator"),
                'A', IC2Items.getItem("crafting","carbon_fibre"),
                'B', Blocks.redstone_block,
                'C', Blocks.glass,
                'D', Blocks.glowstone
        );
    }
}
