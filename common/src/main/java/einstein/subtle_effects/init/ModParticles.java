package einstein.subtle_effects.init;

import com.mojang.serialization.MapCodec;
import einstein.subtle_effects.particle.*;
import einstein.subtle_effects.particle.option.*;
import einstein.subtle_effects.particle.provider.MushroomSporeProvider;
import einstein.subtle_effects.particle.provider.PollenProvider;
import einstein.subtle_effects.particle.provider.SmokeParticleProvider;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

import java.util.function.Function;
import java.util.function.Supplier;

import static einstein.subtle_effects.platform.Services.REGISTRY;

public class ModParticles {

    public static final Supplier<SimpleParticleType> SNORING = register("snoring", SnoringParticle.Provider::new);
    public static final Supplier<SimpleParticleType> FALLING_SNORING = register("falling_snoring", SnoringParticle.FallingProvider::new);
    public static final Supplier<SimpleParticleType> LONG_SPARK = register("long_spark", SparkParticle.LongLifeProvider::new);
    public static final Supplier<SimpleParticleType> LONG_SOUL_SPARK = register("long_soul_spark", SparkParticle.LongLifeProvider::new);
    public static final Supplier<SimpleParticleType> SHORT_SPARK = register("short_spark", SparkParticle.ShortLifeProvider::new);
    public static final Supplier<SimpleParticleType> SHORT_SOUL_SPARK = register("short_soul_spark", SparkParticle.ShortLifeProvider::new);
    public static final Supplier<SimpleParticleType> FLOATING_SPARK = register("floating_spark", SparkParticle.FloatingProvider::new);
    public static final Supplier<SimpleParticleType> FLOATING_SOUL_SPARK = register("floating_soul_spark", SparkParticle.FloatingProvider::new);
    public static final Supplier<SimpleParticleType> METAL_SPARK = register("metal_spark", SparkParticle.MetalProvider::new);
    public static final Supplier<SimpleParticleType> SNOW = register("snow", SnowParticle.Provider::new);
    public static final Supplier<SimpleParticleType> SNOWBALL_TRAIL = register("snowball_trail", SnowParticle.SnowballTrailProvider::new);
    public static final Supplier<SimpleParticleType> CHICKEN_FEATHER = register("chicken_feather", FeatherParticle.Provider::new);
    public static final Supplier<SimpleParticleType> BLUE_PARROT_FEATHER = register("blue_parrot_feather", FeatherParticle.Provider::new);
    public static final Supplier<SimpleParticleType> GRAY_PARROT_FEATHER = register("gray_parrot_feather", FeatherParticle.Provider::new);
    public static final Supplier<SimpleParticleType> GREEN_PARROT_FEATHER = register("green_parrot_feather", FeatherParticle.Provider::new);
    public static final Supplier<SimpleParticleType> RED_BLUE_PARROT_FEATHER = register("red_blue_parrot_feather", FeatherParticle.Provider::new);
    public static final Supplier<SimpleParticleType> YELLOW_BLUE_PARROT_FEATHER = register("yellow_blue_parrot_feather", FeatherParticle.Provider::new);
    public static final Supplier<SimpleParticleType> ALLAY_MAGIC = register("allay_magic", AllayMagicParticle.Provider::new);
    public static final Supplier<ParticleType<BooleanParticleOptions>> VEX_MAGIC = register("vex_magic", BooleanParticleOptions::codec, BooleanParticleOptions::streamCodec, AllayMagicParticle.VexProvider::new);
    public static final Supplier<SimpleParticleType> SMALL_DUST_CLOUD = register("small_dust_cloud", DustCloudParticle.SmallProvider::new);
    public static final Supplier<SimpleParticleType> LARGE_DUST_CLOUD = register("large_dust_cloud", DustCloudParticle.LargeProvider::new);
    public static final Supplier<ParticleType<IntegerParticleOptions>> SHEEP_FLUFF = register("sheep_fluff", IntegerParticleOptions::codec, IntegerParticleOptions::streamCodec, FeatherParticle.SheepFluffProvider::new);
    public static final Supplier<SimpleParticleType> MUSHROOM_SPORE = register("mushroom_spore", MushroomSporeProvider::new);
    public static final Supplier<SimpleParticleType> FIREFLY = register("firefly", sprites -> new InsectParticle.Provider(() -> new ParticleAnimation(sprites, 16, 3), true));
    public static final Supplier<SimpleParticleType> SMOKE = register("smoke", SmokeParticleProvider::new);
    public static final Supplier<SimpleParticleType> POLLEN = register("pollen", PollenProvider::new);
    public static final Supplier<ParticleType<DirectionParticleOptions>> COMMAND_BLOCK = register("command_block", type -> DirectionParticleOptions.CODEC, type -> DirectionParticleOptions.STREAM_CODEC, CommandBlockParticle.Provider::new);
    public static final Supplier<ParticleType<ItemParticleOption>> ITEM_RARITY = register("item_rarity", ItemParticleOption::codec, ItemParticleOption::streamCodec, ItemRarityParticle.Provider::new);
    public static final Supplier<ParticleType<PositionParticleOptions>> BEACON = register("beacon", PositionParticleOptions::codec, PositionParticleOptions::streamCodec, BeaconParticle.Provider::new);
    public static final Supplier<SimpleParticleType> COMPOST = register("compost", CompostParticle.Provider::new);
    public static final Supplier<SimpleParticleType> STEAM = register("steam", SteamParticle.Provider::new);
    public static final Supplier<SimpleParticleType> END_PORTAL = register("end_portal", EndPortalParticle.Provider::new);
    public static final Supplier<SimpleParticleType> END_CRYSTAL = register("end_crystal", EndCrystalParticle.Provider::new);
    public static final Supplier<SimpleParticleType> SCULK_DUST = register("sculk_dust", SculkDustParticle.Provider::new);
    public static final Supplier<ParticleType<FloatParticleOptions>> SLIME_TRAIL = register("slime_trail", FloatParticleOptions::codec, FloatParticleOptions::streamCodec, SlimeTrailParticle.Provider::new);
    public static final Supplier<ParticleType<FloatParticleOptions>> MAGMA_CUBE_TRAIL = register("magma_cube_trail", FloatParticleOptions::codec, FloatParticleOptions::streamCodec, SlimeTrailParticle.Provider::new);

    public static void init() {
    }

    private static Supplier<SimpleParticleType> register(String name, Function<SpriteSet, ParticleProvider<SimpleParticleType>> provider) {
        Supplier<SimpleParticleType> particleType = REGISTRY.registerParticle(name, () -> new SimpleParticleType(false));
        REGISTRY.registerParticleProvider(particleType, provider);
        return particleType;
    }

    @SuppressWarnings("unchecked")
    private static <T extends ParticleType<V>, V extends ParticleOptions> Supplier<T> register(String name, Function<ParticleType<V>, MapCodec<V>> codec, Function<ParticleType<V>, StreamCodec<? super RegistryFriendlyByteBuf, V>> streamCodec, Function<SpriteSet, ParticleProvider<V>> provider) {
        Supplier<T> particleType = (Supplier<T>) REGISTRY.registerParticle(name, () -> new ParticleType<V>(false) {

            @Override
            public MapCodec<V> codec() {
                return codec.apply(this);
            }

            @Override
            public StreamCodec<? super RegistryFriendlyByteBuf, V> streamCodec() {
                return streamCodec.apply(this);
            }
        });
        REGISTRY.registerParticleProvider(particleType, provider);
        return particleType;
    }
}
