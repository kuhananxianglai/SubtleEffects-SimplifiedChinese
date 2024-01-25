package einstein.ambient_sleep.init;

import einstein.ambient_sleep.client.particle.FeatherParticle;
import einstein.ambient_sleep.client.particle.SnoringParticle;
import einstein.ambient_sleep.client.particle.SnowballTrailParticle;
import einstein.ambient_sleep.client.particle.SparkParticle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.function.Function;
import java.util.function.Supplier;

import static einstein.ambient_sleep.platform.Services.REGISTRY;

public class ModParticles {

    public static final Supplier<SimpleParticleType> SNORING = register("snoring", SnoringParticle.Provider::new);
    public static final Supplier<SimpleParticleType> LONG_SPARK = register("long_spark", SparkParticle.LongLifeProvider::new);
    public static final Supplier<SimpleParticleType> LONG_SOUL_SPARK = register("long_soul_spark", SparkParticle.LongLifeProvider::new);
    public static final Supplier<SimpleParticleType> SHORT_SPARK = register("short_spark", SparkParticle.ShortLifeProvider::new);
    public static final Supplier<SimpleParticleType> SHORT_SOUL_SPARK = register("short_soul_spark", SparkParticle.ShortLifeProvider::new);
    public static final Supplier<SimpleParticleType> SNOWBALL_TRAIL = register("snowball_trail", SnowballTrailParticle.Provider::new);
    public static final Supplier<SimpleParticleType> CHICKEN_FEATHER = register("chicken_feather", FeatherParticle.Provider::new);
    public static final Supplier<SimpleParticleType> BLUE_PARROT_FEATHER = register("blue_parrot_feather", FeatherParticle.Provider::new);
    public static final Supplier<SimpleParticleType> GRAY_PARROT_FEATHER = register("gray_parrot_feather", FeatherParticle.Provider::new);
    public static final Supplier<SimpleParticleType> GREEN_PARROT_FEATHER = register("green_parrot_feather", FeatherParticle.Provider::new);
    public static final Supplier<SimpleParticleType> RED_BLUE_PARROT_FEATHER = register("red_blue_parrot_feather", FeatherParticle.Provider::new);
    public static final Supplier<SimpleParticleType> YELLOW_BLUE_PARROT_FEATHER = register("yellow_blue_parrot_feather", FeatherParticle.Provider::new);

    public static void init() {
    }
    
    private static Supplier<SimpleParticleType> register(String name, Function<SpriteSet, ParticleProvider<SimpleParticleType>> provider) {
        Supplier<SimpleParticleType> particleType = REGISTRY.registerParticle(name, () -> new SimpleParticleType(false));
        REGISTRY.registerParticleProvider(particleType, provider);
        return particleType;
    }
}