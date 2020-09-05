package fr.eno.bettercraft;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(References.MOD_ID)
public class BetterCraft
{
    private static final Logger LOGGER = LogManager.getLogger(References.MOD_NAME);

    public BetterCraft()
    {
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	
    	bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        
        LOGGER.log(Level.DEBUG, "Better Craft Setup");
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    	
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
    	
    }
}