package cn.xgheaven.usefulsolar.tile.solar;

import ic2.api.energy.EnergyNet;
import ic2.api.energy.prefab.BasicSource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

/**
 * Created by xgheaven on 6/5/16.
 */
public class BasicSolarTileEntity extends TileEntity implements ITickable {
    protected double generate;
    protected double capacity;
    protected int tier;
    private BasicSource source;

    BasicSolarTileEntity(double capacity, double generate, int tier) {
        super();
        this.generate = generate;
        this.tier = tier;
        this.capacity = capacity;
        this.source = new BasicSource(this, capacity, tier);
    }

    public double getStored() {
        return this.source.getEnergyStored();
    }

    public double getOutput() {
        return EnergyNet.instance.getPowerFromTier(this.source.getTier());
    }

    public int getTier() {
        return source.getTier();
    }

    public double getGenerate() {
        return this.generate;
    }

    public double getCapacity() {
        return this.capacity;
    }

//    @Override
//    public double getOfferedEnergy() {
//        return Math.min(Math.max(this.stored, this.generate), this.output);
//    }

    @Override
    public void onChunkUnload() {
        this.source.onChunkUnload();
        super.onChunkUnload();
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        source.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        source.readFromNBT(compound);
    }

    @Override
    public void invalidate() {
        this.source.invalidate();
        super.invalidate();
    }

    @Override
    public void update() {
        source.update();
        source.addEnergy(this.generate);
    }
}
