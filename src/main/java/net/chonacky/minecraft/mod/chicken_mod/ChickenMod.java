package net.chonacky.minecraft.mod.chicken_mod;



//import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
//import net.minecraft.block.Block.Properties;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
//import net.minecraft.item.Item.Properties;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ObjectHolder;




/**
 * 
 * @author philip
 *
 */
@Mod(value = ChickenMod.MODID)
public class ChickenMod 
{
	
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    
    
	public static final String MODID = "chicken_mod";
	public static final String VERSION = "0.4";
	public static final String NAME = "Chicken Mod";
	public static final String ACCEPTED_VERSIONS = "[1.13.2]";
	public static final ItemGroup ITEMTAB = ItemGroup.MISC;

	//put this before Items so that ModItems can create ItemBlocks

	
//	public  List<EntityEntry> ENTITIES = new ArrayList<EntityEntry>();

    public ChickenMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    
	
    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        //LOGGER.info("HELLO FROM PREINIT");
    }



    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        //LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }
    
    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        //InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
//        LOGGER.info("Got IMC {}", event.getIMCStream().
//                map(m->m.getMessageSupplier().get()).
//                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        // LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(modid=ChickenMod.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
    @ObjectHolder(ChickenMod.MODID)
    public static class RegistryEvents {
    	
    	public static final Block test_block=null;
    	public static final Item test_item=null;
    	
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
    			blockRegistryEvent.getRegistry().registerAll(
    					new Block(Block.Properties.create(Material.IRON)).setRegistryName(ChickenMod.MODID,"test_block")); 
        }
        
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
        	itemRegistryEvent.getRegistry().registerAll(
        			(Item)new ItemBlock(test_block,new Item.Properties().group(ChickenMod.ITEMTAB)).setRegistryName(test_block.getRegistryName()),
        			new Item(new Item.Properties().group(ITEMTAB)).setRegistryName(ChickenMod.MODID,"test_item")
        			);
        }
        
        
        //List<Item> ITEMS = ModItems.MakeItems();
    }
    

}
    
    