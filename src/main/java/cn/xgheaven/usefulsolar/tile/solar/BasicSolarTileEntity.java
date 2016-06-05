package cn.xgheaven.usefulsolar.tile.solar;

import cn.xgheaven.usefulsolar.tile.USBlocks;
import ic2.api.energy.EnergyNet;
import ic2.api.energy.prefab.BasicSource;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ITickable;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.client.model.animation.ITimeValue;

/**
 * Created by xgheaven on 6/5/16.
 */
public class BasicSolarTileEntity extends TileEntity implements ITickable{
    protected double generate;
    protected double maxGen;
    protected double capacity;
    protected int tier;
    private BasicSource source;
    private int timer = 0;

    BasicSolarTileEntity(double capacity, double generate, int tier) {
        super();
        this.maxGen = this.generate = generate;
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
            this.generate = Math.max(0, (int)(this.maxGen * (lightSky-7) / 8));
        } else {
            this.generate = Math.max(0, (int)(this.maxGen * (lightSky-7) / 40));
        }
    }
}
