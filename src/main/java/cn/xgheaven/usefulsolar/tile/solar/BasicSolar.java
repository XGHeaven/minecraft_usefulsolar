package cn.xgheaven.usefulsolar.tile.solar;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by xgheaven on 6/5/16.
 */
public class BasicSolar extends BlockContainer {
    private double maxStore;
    private double generate;
    private int tier;

    public BasicSolar(String unlocalizeName, double maxStore, double generate, int tier) {
        super(Material.rock);
        this.setUnlocalizedName(unlocalizeName);
        this.setCreativeTab(CreativeTabs.tabBlock);

        this.maxStore = maxStore;
        this.generate = generate;
        this.tier = tier;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return null;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new BasicSolarTileEntity(maxStore, generate, tier);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);

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
