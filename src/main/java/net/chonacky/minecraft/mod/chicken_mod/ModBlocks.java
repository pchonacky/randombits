package net.chonacky.minecraft.mod.chicken_mod;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.Block.Properties;
import net.minecraft.block.material.Material;


public class ModBlocks {

	private static List<Block> blockList = new ArrayList<Block>();
	
	private static void NewBlock(String name,Material materialIn) {
	Block thisBlock = new Block(Properties.create(materialIn)).setRegistryName(ChickenMOD.MODID,name);
	blockList.add(thisBlock);	
	ChickenMOD.LOGGER.info("HELLO from MakeBLocks");
	//ChickenMOD.ITEMS.add(thisBlock.asItem());
	}
	
	public static List<Block> MakeBlocks() {
		NewBlock("test_block",Material.IRON);
		return blockList;
	}
	
	/*
	 * Not needed: I originally created private fields and setters to allow for Block variations
	 * Since this class gets cast into the BLock Class, the setters were unavailable
	 */
//	//Default BlockStates:: can be modified by public setters
//	private BlockRenderLayer blockRenderLayer = BlockRenderLayer.SOLID;
//	private boolean opaque = true;
//	private boolean fullCube = true;
	
	
/*	public ModBlocks(String name, Material materialIn) {
		super(Properties.create(materialIn));
		init(name);
	}

	public ModBlocks(String name, Material blockMaterialIn, MaterialColor blockMapColorIn) {
		super(Properties.create(blockMaterialIn, blockMapColorIn));
		init(name);
	}*/




/*
 * The following overrides controls rendering options 
 * as configured, they all produce default results
 * Copy and modify as needed	
 */
	
	
//
//	  // used by the renderer to control the render layer.
//	  @SideOnly(Side.CLIENT)
//	  public BlockRenderLayer getBlockLayer()
//	  {
//	    return BlockRenderLayer.SOLID;
//	  }
//	  
//	  // used by the renderer to control lighting and visibility of other blocks.
//	  @Override
//	  public boolean isOpaqueCube(IBlockState iBlockState) {
//		  return true;
//	  }
//
//	  // used by the renderer to control lighting and visibility of other blocks, also by
//	  // (eg) wall or fence to control whether the fence joins itself to this block
//	  @Override
//	  public boolean isFullCube(IBlockState iBlockState) {
//	    return true;
//	  }

//******************************************************************************//
	
	  
	/*
	 * Not needed: I originally created private fields and setters to allow for Block variations
	 * Since this class gets cast into the BLock Class, the setters were unavailable
	 */  
	  
//	/**
//	 * @param blockRenderLayer sets the Block Render Layer
//	 * default = SOLID (farthest back)
//	 */
//	public void setBlockRenderLayer(BlockRenderLayer blockRenderLayer) {
//		this.blockRenderLayer = blockRenderLayer;
//	}
//
//	/**
//	 * @param opaque
//	 * 	default "TRUE" (block is opaque)
//	 */
//	public void setOpaque(boolean opaque) {
//		this.opaque = opaque;
//	}
//
//	/**
//	 * @param fullCube the fullCube to set
//	 * default "TRUE"
//	 */
//	public void setFullCube(boolean fullCube) {
//		this.fullCube = fullCube;
//	}


}


