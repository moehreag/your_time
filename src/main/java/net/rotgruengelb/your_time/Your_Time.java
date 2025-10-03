package net.rotgruengelb.your_time;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.util.Identifier;
import net.rotgruengelb.your_time.config.ModConfig;
import net.rotgruengelb.your_time.events.TimerGuiOverlay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Your_Time implements ClientModInitializer {
	public static final String MOD_ID = "your_time";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ModConfig CONFIG = ModConfig.createAndLoad();

	@Override
	public void onInitializeClient() {
		HudElementRegistry.attachElementAfter(VanillaHudElements.HOTBAR, Identifier.of(MOD_ID, "timer_gui_overlay"), TimerGuiOverlay::renderOverlay);
	}
}