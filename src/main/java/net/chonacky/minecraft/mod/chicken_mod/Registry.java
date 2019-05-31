package net.chonacky.minecraft.mod.chicken_mod;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=ChickenMod.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class Registry {

	//Register Items
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event)  {
		for (Item thisItem : ChickenMod.ITEMS) {
			event.getRegistry().register(thisItem);
			}
		}
	//Register Blocks
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)	{
		for (Block thisBlock : ChickenMod.BLOCKS ) {
			event.getRegistry().register(thisBlock);
			}
	}
//	//Register Entities
//	@SubscribeEvent
//	public static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {
//		for (EntityEntry thisEntity : ChickenMod.ENTITIES) {
//			event.getRegistry().register(thisEntity);	
//		}
//	}
	//Register Models
	@SubscribeEvent
	//TODO - Do this so it only runs on Client
	public static void registerModels(ModelRegistryEvent event) {}
	

	
}