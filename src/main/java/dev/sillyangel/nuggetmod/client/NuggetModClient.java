package dev.sillyangel.nuggetmod.client;

import dev.sillyangel.nuggetmod.particle.ModParticles;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.api.ClientModInitializer;
import dev.sillyangel.nuggetmod.particle.NuggetParticle;

public class NuggetModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.NUGGET_PARTICLE, NuggetParticle.Factory::new);
    }
}
