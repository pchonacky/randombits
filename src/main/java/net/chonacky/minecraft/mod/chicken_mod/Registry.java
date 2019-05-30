package net.chonacky.minecraft.mod.chicken_mod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=ChickenMOD.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class Registry {

	//Register Items
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)  {
		ChickenMOD.LOGGER.info("HELLO from Registry :: ITEMS");
		for (Item thisItem : ChickenMOD.ITEMS) {
			event.getRegistry().register(thisItem);
			}
		}
	//Register Blocks
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)	{
		ChickenMOD.LOGGER.info("HELLO from Registry :: BLOCKS");
		for (Block thisBlock : ChickenMOD.BLOCKS ) {
			event.getRegistry().register(thisBlock);
			}
	}
//	//Register Entities
//	@SubscribeEvent
//	public static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {
//		for (EntityEntry thisEntity : ChickenMOD.ENTITIES) {
//			event.getRegistry().register(thisEntity);	
//		}
//	}
	//Register Models
	@SubscribeEvent
	//TODO - Do this so it only runs on Client
	public static void registerModels(ModelRegistryEvent event) {}
	

	
}