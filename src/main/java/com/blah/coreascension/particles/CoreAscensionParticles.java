package com.blah.coreascension.particles;

import com.blah.coreascension.CoreAscension;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class CoreAscensionParticles {
    public static final DefaultParticleType ETHEREAL_FLAME = registerParticle("ethereal_flame", FabricParticleTypes.simple());

    public static DefaultParticleType registerParticle(String name, DefaultParticleType particle) {
        return Registry.register(Registries.PARTICLE_TYPE, new Identifier(CoreAscension.MOD_ID, name), particle);
    }

    public static void RegisterParticles() {
        CoreAscension.LOGGER.info("Registering Particles for " + CoreAscension.MOD_ID);
    }

    public static void ClientRegisterParticles() {
        ParticleFactoryRegistry.getInstance().register(CoreAscensionParticles.ETHEREAL_FLAME, FlameParticle.Factory::new);
    }
}
