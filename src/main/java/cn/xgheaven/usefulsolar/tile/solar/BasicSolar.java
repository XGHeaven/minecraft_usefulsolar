package cn.xgheaven.usefulsolar.tile.solar;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by xgheaven on 6/5/16.
 */
public abstract class BasicSolar extends Block implements ITileEntityProvider {
    private double maxStore;
    private double generate;
    private int tier;

    BasicSolar(String unlocalizedName) {
        super(Material.rock);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(3);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) return true;

        BasicSolarTileEntity tile = (BasicSolarTileEntity)worldIn.getTileEntity(pos);

        if (tile != null) {
            playerIn.addChatMessage(new ChatComponentText("stored:" + tile.getStored()));
            playerIn.addChatMessage(new ChatComponentText("maxStore:" + tile.getCapacity()));
            playerIn.addChatMessage(new ChatComponentText("output:" + tile.getOutput()));
            playerIn.addChatMessage(new ChatComponentText("generate:" + tile.getGenerate()));
        }

        return true;
    }
}
