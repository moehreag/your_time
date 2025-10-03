package net.rotgruengelb.your_time;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.HudLayerRegistrationCallback;
import net.fabricmc.fabric.api.client.rendering.v1.IdentifiedLayer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
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
		HudLayerRegistrationCallback.EVENT.register(layer ->
				layer.addLayer(new IdentifiedLayer() {
					@Override
					public Identifier id() {
						return Identifier.of(MOD_ID, "timer_gui_overlay");
					}

					@Override
					public void render(DrawContext context, RenderTickCounter tickCounter) {
						TimerGuiOverlay.renderOverlay(context, tickCounter);
					}
				}));
	}
}