package ph.jldvmsrwll1a.darkerlightsrc;

import java.util.Map;
import net.minecraft.resources.ResourceLocation;

public final class DefaultLevels {

    public static final int DEFAULT_LEVEL = 8;

    public static final Map<ResourceLocation, Integer> DEFAULT_TABLE = Map.ofEntries(
            // Do not mess with creative light blocks. They would be pointless otherwise.
            pass("light"),
            pass("end_gateway"),
            pass("end_portal"),
            pass("vault"),
            pass("small_amethyst_bud"),
            pass("medium_amethyst_bud"),
            pass("large_amethyst_bud"),
            pass("amethyst_cluster"),
            pass("magma_block"),
            pass("candle_cake"), // TODO: colours
            pass("firefly_bush"), // TODO: colours
            pass("powergrid:light_fixture"),
            pass("createaddition:small_light_connector"),
            limit("torch", 12),
            limit("hardcore_torches:lit_torch", 12),
            limit("copper_torch", 12),
            limit("lantern", 12),
            limit("hardcore_torches:lit_lantern", 12),
            limit("campfire", 12),
            limit("fire", 10),
            limit("furnace", 10),
            limit("blast_furnace", 10),
            limit("smoker", 10),
            limit("pearlescent_froglight", 8),
            limit("verdant_froglight", 8),
            limit("ochre_froglight", 8),
            limit("lava", 8),
            limit("cauldron", 8),
            limit("soul_torch", 6),
            limit("hardcore_torches:lit_soul_torch", 6),
            limit("soul_fire", 6),
            limit("soul_campfire", 6),
            limit("soul_lantern", 6),
            limit("hardcore_torches:lit_soul_lantern", 6),
            limit("respawn_anchor", 6),
            limit("sea_lantern", 5),
            limit("sea_pickle", 5),
            limit("glowstone", 5),
            limit("jack_o_lantern", 5),
            limit("redstone_lamp", 5),
            limit("shroom_light", 5),
            limit("end_rod", 5),
            limit("candle", 5), // TODO: add the other colour variants
            // TODO: add support for matching by tag
            limit("sculk_catalyst", 5),
            limit("copper_bulb", 7),
            limit("exposed_copper_bulb", 6),
            limit("weathered_copper_bulb", 5),
            limit("oxidized_copper_bulb", 4),
            limit("waxed_copper_bulb", 7),
            limit("waxed_exposed_copper_bulb", 6),
            limit("waxed_weathered_copper_bulb", 5),
            limit("waxed_oxidized_copper_bulb", 4),
            limit("cave_vines", 4),
            limit("cave_vines_plant", 4),
            limit("redstone_torch", 4));

    private static Map.Entry<ResourceLocation, Integer> pass(String location) {
        return Map.entry(ResourceLocation.parse(location), 15);
    }

    private static Map.Entry<ResourceLocation, Integer> limit(String location, int value) {
        return Map.entry(ResourceLocation.parse(location), value);
    }
}
