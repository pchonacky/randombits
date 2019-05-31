package net.chonacky.minecraft.mod.chicken_mod;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.material.Material;


public class ModBlocks {

	private static List<Block> blockList = new ArrayList<Block>();
	
	private static void NewBlock(String name,Material materialIn) {
	Block thisBlock = new Block(Properties.create(materialIn)).setRegistryName(ChickenMod.MODID,name);
	blockList.add(thisBlock);	
	//ChickenMod.LOGGER.info("HELLO from MakeBLocks");
	}
	
	public static List<Block> MakeBlocks() {
		NewBlock("test_block",Material.IRON);
		return blockList;
	}
}