package net.onesaw.removewardeneffect;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import org.slf4j.LoggerFactory;


public class DarknessRemover implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	@Override
	public void onInitialize() {
		// Register a client tick event listener
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			// Check if the player has the "Darkness" effect
			if (client.player != null) {
				StatusEffectInstance darknessEffect = client.player.getStatusEffect(StatusEffects.DARKNESS);
				if (darknessEffect != null) {
					// Remove the "Darkness" effect
					client.player.removeStatusEffect(StatusEffects.DARKNESS);
				}
			}
		});
	}
}