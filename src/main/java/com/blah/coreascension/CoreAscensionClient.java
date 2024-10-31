package com.blah.coreascension;

import com.blah.coreascension.particles.CoreAscensionParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class CoreAscensionClient implements ClientModInitializer {
	public void onInitializeClient() {
		CoreAscensionParticles.ClientRegisterParticles();
	}
}