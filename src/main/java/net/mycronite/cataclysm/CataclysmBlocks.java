package net.mycronite.cataclysm;

import net.mycronite.cataclysm.blocks.BlockGapingMaw;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CataclysmBlocks
{
    @GameRegistry.ObjectHolder(Cataclysm.MODID +":blockgapingmaw")
    public static BlockGapingMaw blockGapingMaw;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        blockGapingMaw.initModel();
    }
}