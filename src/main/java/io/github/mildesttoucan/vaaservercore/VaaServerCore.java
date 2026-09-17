package io.github.mildesttoucan.vaaservercore;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class VaaServerCore implements ModInitializer {
	public static final String MOD_ID = "vaaservercore";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        simpleDebug("Initializing vaaservercore");
	}

    public static void simpleInfo(String message) {
        LOGGER.info(message);
    }

    public static void simpleWarn(String message) {
        LOGGER.warn(message);
    }

    public static void simpleError(String message) {
        LOGGER.error(message);
    }

    public static void simpleDebug(String message) {
        LOGGER.debug(message);
    }

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
