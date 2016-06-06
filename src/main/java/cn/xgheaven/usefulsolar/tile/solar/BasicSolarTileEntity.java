package cn.xgheaven.usefulsolar.tile.solar;

import ic2.api.energy.EnergyNet;
import ic2.api.energy.prefab.BasicSource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ITickable;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

/**
 * Created by xgheaven on 6/5/16.
 */
public abstract class BasicSolarTileEntity extends TileEntity implements ITickable{
    private double generate = this.getMaxGen();
    private BasicSource source = new BasicSource(this, this.getCapacity(), this.getTier());
    private int timer = 0;

    public double getStored() {
        return this.source.getEnergyStored();
    }

    public double getOutput() {
        return EnergyNet.instance.getPowerFromTier(this.source.getTier());
    }

    public double getGenerate() {
        return this.generate;
    }

    public abstract int getTier();
    public abstract double getMaxGen();
    public abstract double getCapacity();

    @Override
    public void onChunkUnload() {
        this.source.onChunkUnload();
        super.onChunkUnload();
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        this.source.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.source.readFromNBT(compound);
    }

    @Override
    public void invalidate() {
        this.source.invalidate();
        super.invalidate();
    }

    @Override
    public void update() {
        this.source.update();
        this.source.addEnergy(this.generate);
        markDirty();

        // to update generate
        this.timer++;
        if (this.timer >= 40) { // 2s
            this.updateGenerate();
            timer = 0;
        }
    }

    private void updateGenerate() {
        World world = this.worldObj;
        BlockPos pos = this.getPos().up();
        int lightSky = world.getLightFor(EnumSkyBlock.SKY, pos);

        if (world.isDaytime()) {
            this.generate = Math.max(0, (int)(this.getMaxGen() * (lightSky-7) / 8));
        } else {
            this.generate = Math.max(0, (int)(this.getMaxGen() * (lightSky-7) / 40));
        }

        System.out.println(world.isRemote + " " + this.source.getEnergyStored());
    }
}
