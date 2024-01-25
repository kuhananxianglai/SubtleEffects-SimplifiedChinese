package einstein.ambient_sleep.init;

import einstein.ambient_sleep.AmbientSleep;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfigs {

    private static final Pair<ModConfigs, ForgeConfigSpec> SPEC_PAIR = new ForgeConfigSpec.Builder().configure(ModConfigs::new);
    public static final ModConfigs INSTANCE = SPEC_PAIR.getLeft();
    public static final ForgeConfigSpec SPEC = SPEC_PAIR.getRight();

    public final ForgeConfigSpec.BooleanValue disableDefaultCampfireSparks;
    public final ForgeConfigSpec.BooleanValue enableCandleSparks;
    public final ForgeConfigSpec.BooleanValue enableFurnaceSparks;
    public final ForgeConfigSpec.BooleanValue enableFireSparks;
    public final ForgeConfigSpec.BooleanValue enableCampfireSparks;
    public final ForgeConfigSpec.BooleanValue enableTorchSparks;

    public ModConfigs(ForgeConfigSpec.Builder builder) {
        builder.push("Blocks").push("Flaming Blocks");

        disableDefaultCampfireSparks = builder
                .comment("Disables the default lava spark particle from campfires")
                .translation(key("disable_default_campfire_sparks"))
                .define("disableDefaultCampfireSparks", true);

        enableCandleSparks = builder.translation(key("enable_candle_sparks"))
                .define("enableCandleSparks", true);
        enableFurnaceSparks = builder.translation(key("enable_furnace_sparks"))
                .define("enableFurnaceSparks", true);
        enableFireSparks = builder.translation(key("enable_fire_sparks"))
                .define("enableFireSparks", true);
        enableCampfireSparks = builder.translation(key("enable_campfire_sparks"))
                .define("enableCampfireSparks", true);
        enableTorchSparks = builder.translation(key("enable_torch_sparks"))
                .define("enableTorchSparks", true);

        builder.pop();

        builder.pop().push("Entities");
    }

    private static String key(String path) {
        return "config." + AmbientSleep.MOD_ID + "." + path;
    }
}