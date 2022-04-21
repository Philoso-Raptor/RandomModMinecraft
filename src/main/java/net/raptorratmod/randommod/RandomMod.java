package net.raptorratmod.randommod;

import net.fabricmc.api.ModInitializer;
import net.raptorratmod.randommod.block.ModBlocks;
import net.raptorratmod.randommod.effect.ModEffects;
import net.raptorratmod.randommod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RandomMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String MOD_ID = "randommod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	//This Should be viewable and should be in package net.raptorratmod.randommod
	// YOOOOOOOOOOO

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.registerModItems();
		ModBlocks.registerModBlock();
		ModEffects.registerEffects();

		LOGGER.info("Hello Fabric world!");
	}
}
