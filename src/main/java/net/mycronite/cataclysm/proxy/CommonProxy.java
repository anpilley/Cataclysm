package net.mycronite.cataclysm.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.mycronite.cataclysm.blocks.BlockGapingMaw;
import net.mycronite.cataclysm.blocks.TileEntityGapingMaw;
import net.mycronite.cataclysm.Cataclysm;
import net.mycronite.cataclysm.CataclysmBlocks;

@Mod.EventBusSubscriber
public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent e)
    {
        
    }
    
    public void init(FMLInitializationEvent e)
    {
        
    }
    
    public void postInit(FMLPostInitializationEvent e)
    {
        
    }
    

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(new BlockGapingMaw());
        GameRegistry.registerTileEntity(TileEntityGapingMaw.class, Cataclysm.MODID + "_datablock");
    }
    
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new ItemBlock(CataclysmBlocks.blockGapingMaw).setRegistryName(CataclysmBlocks.blockGapingMaw.getRegistryName()));
    }
}