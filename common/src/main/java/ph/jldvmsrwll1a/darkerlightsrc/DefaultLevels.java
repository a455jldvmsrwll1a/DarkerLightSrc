package ph.jldvmsrwll1a.darkerlightsrc;

import java.util.Map;
import net.minecraft.resources.ResourceLocation;

public final class DefaultLevels {

    public static final int PASSTHROUGH = -1;
    public static final int DEFAULT_LEVEL = PASSTHROUGH; // TODO: temporary

    public static final Map<ResourceLocation, Integer> DEFAULT_TABLE = Map.ofEntries(
            // Do not mess with creative light blocks. They would be pointless otherwise.
            entry("light", PASSTHROUGH),
            entry("end_gateway", PASSTHROUGH),
            entry("end_portal", PASSTHROUGH),
            entry("vault", PASSTHROUGH),
            entry("small_amethyst_bud", PASSTHROUGH),
            entry("medium_amethyst_bud", PASSTHROUGH),
            entry("large_amethyst_bud", PASSTHROUGH),
            entry("amethyst_cluster", PASSTHROUGH),
            entry("magma_block", PASSTHROUGH),
            entry("candle_cake", PASSTHROUGH), // TODO: colours
            entry("firefly_bush", PASSTHROUGH), // TODO: colours
            entry("powergrid:light_fixture", PASSTHROUGH),
            entry("createaddition:small_light_connector", PASSTHROUGH),
            entry("torch", 12),
            entry("hardcore_torches:lit_torch", 12),
            entry("copper_torch", 12),
            entry("lantern", 12),
            entry("hardcore_torches:lit_lantern", 12),
            entry("campfire", 12),
            entry("fire", 10),
            entry("furnace", 10),
            entry("blast_furnace", 10),
            entry("smoker", 10),
            entry("pearlescent_froglight", 8),
            entry("verdant_froglight", 8),
            entry("ochre_froglight", 8),
            entry("lava", 8),
            entry("cauldron", 8),
            entry("soul_torch", 6),
            entry("hardcore_torches:lit_soul_torch", 6),
            entry("soul_fire", 6),
            entry("soul_campfire", 6),
            entry("soul_lantern", 6),
            entry("hardcore_torches:lit_soul_lantern", 6),
            entry("respawn_anchor", 6),
            entry("sea_lantern", 5),
            entry("sea_pickle", 5),
            entry("glowstone", 5),
            entry("jack_o_lantern", 5),
            entry("redstone_lamp", 5),
            entry("shroom_light", 5),
            entry("end_rod", 5),
            entry("candle", 5), // TODO: add the other colour variants
            // TODO: add support for matching by tag
            entry("sculk_catalyst", 5),
            entry("copper_bulb", 7),
            entry("exposed_copper_bulb", 6),
            entry("weathered_copper_bulb", 5),
            entry("oxidized_copper_bulb", 4),
            entry("waxed_copper_bulb", 7),
            entry("waxed_exposed_copper_bulb", 6),
            entry("waxed_weathered_copper_bulb", 5),
            entry("waxed_oxidized_copper_bulb", 4),
            entry("cave_vines", 4),
            entry("cave_vines_plant", 4),
            entry("redstone_torch", 4));

    private static Map.Entry<ResourceLocation, Integer> entry(String location, int value) {
        return Map.entry(ResourceLocation.parse(location), value);
    }
}
