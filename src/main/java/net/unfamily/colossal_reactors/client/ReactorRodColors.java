package net.unfamily.colossal_reactors.client;

import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.unfamily.colossal_reactors.ClientConfig;
import net.unfamily.colossal_reactors.block.ModBlocks;
import net.unfamily.colossal_reactors.block.ReactorRodBlock;
import net.unfamily.colossal_reactors.blockentity.ReactorRodBlockEntity;

import java.util.List;
import java.util.Set;

/**
 * Dynamic tint for reactor rod inside fill from the rod BE synced {@code InsideTint} RGB.
 * Item form uses datapack uranium green via {@code assets/.../items/reactor_rod.json} constant tint.
 */
public final class ReactorRodColors {

    /** Datapack uranium fuel color ({@code reactor_fuel.json} {@code #45c159}). */
    public static final int URANIUM_INSIDE_RGB = ReactorRodBlockEntity.DEFAULT_INSIDE_TINT_RGB;

    private ReactorRodColors() {}

    public static void register(RegisterColorHandlersEvent.BlockTintSources event) {
        event.register(List.of(new RodInsideTintSource()), ModBlocks.REACTOR_ROD.get());
    }

    private static final class RodInsideTintSource implements BlockTintSource {
        @Override
        public int color(BlockState state) {
            return 0xFF000000 | ClientConfig.getRodInsideFallbackColorRgb();
        }

        @Override
        public int colorInWorld(BlockState state, BlockAndTintGetter level, BlockPos pos) {
            if (state.hasProperty(ReactorRodBlock.FILL) && state.getValue(ReactorRodBlock.FILL) == 0) {
                return 0xFF000000 | ClientConfig.getRodInsideFallbackColorRgb();
            }
            int rgb = ClientConfig.getRodInsideFallbackColorRgb();
            if (level != null && pos != null) {
                BlockEntity be = level.getBlockEntity(pos);
                if (be instanceof ReactorRodBlockEntity rod) {
                    rgb = rod.getInsideTintRgb();
                }
            }
            return 0xFF000000 | (rgb & 0xFFFFFF);
        }

        @Override
        public Set<Property<?>> relevantProperties() {
            return Set.of(ReactorRodBlock.FILL);
        }
    }
}
