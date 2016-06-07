package cn.xgheaven.usefulsolar.recipe;

import cn.xgheaven.usefulsolar.tile.USBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by xgheaven on 6/7/16.
 */
public class FuelRecipe {
    static void createRecipe() {
        GameRegistry.addShapelessRecipe(
                new ItemStack(USBlocks.lava_block),
                Items.lava_bucket,
                Blocks.stone
        );
        GameRegistry.addShapelessRecipe(
                new ItemStack(USBlocks.lava_coal_block),
                Blocks.coal_block,
                USBlocks.lava_block
        );
    }
}
