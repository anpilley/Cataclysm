package net.mycronite.cataclysm.proxy;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.mycronite.cataclysm.CataclysmBlocks;
import net.mycronite.cataclysm.CataclysmItems;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent e) 
    {
        super.preInit(e);
    }
    
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event)
    {
        CataclysmBlocks.initModels();
        CataclysmItems.initModels();
    }
}
        