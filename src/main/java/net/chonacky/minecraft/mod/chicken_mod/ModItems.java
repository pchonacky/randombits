package net.chonacky.minecraft.mod.chicken_mod;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;

public class ModItems {
	
	private static List<Item> itemList = new ArrayList<Item>();

	private static void NewItem(String name, ItemGroup tab) {
		Item thisItem = new Item(new Properties().group(tab))
				.setRegistryName(ChickenMod.MODID,name);
		ChickenMod.LOGGER.info("HELLO from NewItems");
		itemList.add(thisItem);
	}
	
	public static List<Item> MakeItems() {
		ChickenMod.LOGGER.info("HELLO from MakeItems");
		NewItem ("test_item", ItemGroup.MISC);
		
		for (Block thisBlock:ChickenMod.BLOCKS) {
			Item thisItem = new ItemBlock(thisBlock, new Properties().group(ChickenMod.ITEMTAB)).setRegistryName(thisBlock.getRegistryName());
			ChickenMod.LOGGER.info("HELLO from MakeItems-> block tab registry" );
			itemList.add(thisItem);
		}
		return itemList;
	}
	
	/*public ModItems(String name) {
		super(new Properties());
		this.setRegistryName(name);
		this.getCreativeTabs().add(ItemGroup.MISC);
		Registry.ITEMS.add(this);
	}*/

//	@Override
//	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
//		return super.onItemRightClick(worldIn, playerIn, handIn);
//	}
	
	

}
