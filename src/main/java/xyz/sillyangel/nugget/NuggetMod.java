package xyz.sillyangel.nugget;

import net.fabricmc.api.ModInitializer;
import xyz.sillyangel.nugget.block.ModBlocks;
import xyz.sillyangel.nugget.item.ModItemGroups;
import xyz.sillyangel.nugget.item.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NuggetMod implements ModInitializer {
	public static final String MOD_ID = "nuggetmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
	}
}