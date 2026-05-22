package ph.jldvmsrwll1a.darkerlightsrc.mixin.light_level;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import ph.jldvmsrwll1a.darkerlightsrc.DarkerLightSrcCore;

@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class BlockStateBaseMixin {

    @ModifyReturnValue(method = "getLightEmission", at = @At("RETURN"))
    private int modifyEmissionValue(int original) {
        if (original == 0) {
            return original;
        }

        BlockBehaviour.BlockStateBase state = (BlockBehaviour.BlockStateBase) (Object) this;
        int level = DarkerLightSrcCore.BLOCK_LIGHT_LEVELS.getLightCap(state);

        return Math.min(original, level);
    }
}
