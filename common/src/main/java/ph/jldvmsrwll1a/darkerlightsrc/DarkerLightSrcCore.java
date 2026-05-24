package ph.jldvmsrwll1a.darkerlightsrc;

public final class DarkerLightSrcCore {

    public static BlockLightLevels BLOCK_LIGHT_LEVELS = null;

    public static void setTable(BlockLightLevels table) {
        BLOCK_LIGHT_LEVELS = table;

        Constants.LOG.info("Initialised block light table with {} rules.", table.tableSize());
    }
}
