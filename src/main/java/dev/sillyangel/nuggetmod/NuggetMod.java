package dev.sillyangel.nuggetmod;

import dev.sillyangel.nuggetmod.particle.ModParticles;
import dev.sillyangel.nuggetmod.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;
import dev.sillyangel.nuggetmod.block.ModBlocks;
import dev.sillyangel.nuggetmod.item.ModItemGroups;
import dev.sillyangel.nuggetmod.item.ModItems;
import dev.sillyangel.nuggetmod.sound.ModSounds;
import dev.sillyangel.nuggetmod.world.gen.ModWorldGeneration;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NuggetMod implements ModInitializer {
	public static final String MOD_ID = "nuggetmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Nugget");

		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModSounds.registerSounds();
		ModWorldGeneration.generateModWorldGen();
		ModVillagers.registerVillagers();
		ModParticles.registerParticles();

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, factories -> {
			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 3),
					new ItemStack(ModItems.NUGGET, 8), 7, 2, 0.04f));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.NUGGETER_KEY, 1, factories -> {
			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 5),
					new ItemStack(ModItems.NUGGET, 20), 4, 7, 0.04f));

			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NUGGET, 16),
					new ItemStack(ModItems.NUGGET_HORSE_ARMOR, 1), 4, 7, 0.04f));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.NUGGETER_KEY, 2, factories -> {
			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NUGGET, 10),
					new ItemStack(ModItems.NUGGET_SMITHING_TEMPLATE, 1), 4, 7, 0.04f));

			factories.add((world,entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NUGGET, 10),
					new ItemStack(ModItems.NUGGET_MUSIC_DISC, 1), 3, 12, 0.09f));
		});

		TradeOfferHelper.registerWanderingTraderOffers(factories -> {
			factories.addAll(Identifier.of(NuggetMod.MOD_ID, "emerald_for_nuggetsmithing"), (world, entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 25),
					new ItemStack(ModItems. NUGGET_SMITHING_TEMPLATE, 1), 4, 7, 0.04f));

			factories.addAll(Identifier.of(NuggetMod.MOD_ID, "nuggets_to_musicdisc"), (world, entity, random) -> new TradeOffer(
					new TradedItem(ModItems.NUGGET, 15),
					new ItemStack(ModItems.NUGGET_MUSIC_DISC, 1), 3, 12, 0.09f));
		});
	}
}