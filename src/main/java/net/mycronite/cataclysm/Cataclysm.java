package net.mycronite.cataclysm;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.SidedProxy;
import org.apache.logging.log4j.Logger;

import net.mycronite.cataclysm.proxy.*;

@Mod(modid = Cataclysm.MODID, name = Cataclysm.NAME, version = Cataclysm.VERSION)
public class Cataclysm 
{
    public static final String MODID = "cataclysm";
    public static final String NAME = "Example Mod";
    public static final String VERSION = "0.1";
    
    private static Logger logger;
    
    @SidedProxy(clientSide = "net.mycronite.cataclysm.proxy.ClientProxy", serverSide = "net.mycronite.cataclysm.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event);
        
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("DIRT BLOCK >> {}",  Blocks.DIRT.getRegistryName());
    }
    
}
