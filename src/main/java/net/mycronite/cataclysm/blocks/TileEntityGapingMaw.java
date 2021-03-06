package net.mycronite.cataclysm.blocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGapingMaw extends TileEntity
{

    private int counter = 0;
    
    public int decrement() {
        counter--;
        markDirty();
        return counter;
    }

    public int increment() {
        counter++;
        markDirty();
        return counter;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        counter = compound.getInteger("counter");
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("counter", counter);
        return compound;
    }

}
