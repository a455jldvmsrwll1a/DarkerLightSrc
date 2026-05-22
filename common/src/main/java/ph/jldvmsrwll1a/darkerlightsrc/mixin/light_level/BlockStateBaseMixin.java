package ph.jldvmsrwll1a.darkerlightsrc.mixin.light_level;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import ph.jldvmsrwll1a.darkerlightsrc.DarkerLightSrcCore;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class BlockStateBaseMixin {

    @ModifyReturnValue(method = "getLightEmission", at = @At("RETURN"))
    private int modifyEmissionValue(int original) {
        if (original <= 0 || original > 15) {
            return original;
        }

        BlockBehaviour.BlockStateBase state = (BlockBehaviour.BlockStateBase) (Object) this;
        Block block = state.getBlock();

        int level = DarkerLightSrcCore.BLOCK_LIGHT_LEVELS.getLightCap(block);

        // dirty hack: instead of replacing the level, we cap it.
        // not sure how I will support per-state levels, so this allows i.e.
        // candles to vary light somewhat, and for blocks that are already
        // low-light to remain so.
        if (level >= 0 && level <= 15 && original > level) {
            return level;
        } else {
            return original;
        }
    }
}
