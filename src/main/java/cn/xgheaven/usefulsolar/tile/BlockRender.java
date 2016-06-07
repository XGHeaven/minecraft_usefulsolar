package cn.xgheaven.usefulsolar.tile;

import cn.xgheaven.usefulsolar.Main;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by xgheaven on 6/5/16.
 */
public class BlockRender {
    private final static String modid = Main.MODID;

    private static void reg(Block block) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(
                        Item.getItemFromBlock(block),
                        0,
                        new ModelResourceLocation(modid + ":" + block.getUnlocalizedName().substring(5))
                );
    }

    public static void registerRender() {
        reg(USBlocks.advance_solar);
        reg(USBlocks.lava_block);
        reg(USBlocks.lava_coal_block);
    }
}
