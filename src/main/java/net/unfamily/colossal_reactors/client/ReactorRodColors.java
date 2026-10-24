package net.unfamily.colossal_reactors.client;

import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.unfamily.colossal_reactors.ClientConfig;
import net.unfamily.colossal_reactors.block.ModBlocks;
import net.unfamily.colossal_reactors.block.ReactorRodBlock;
import net.unfamily.colossal_reactors.blockentity.ReactorRodBlockEntity;
import net.unfamily.colossal_reactors.fuel.FuelDefinition;
import net.unfamily.colossal_reactors.fuel.FuelLoader;

import java.util.List;

/**
 * Dynamic tint for reactor rod inside fill based on contained fuel color (or client fallback).
 */
public final class ReactorRodColors {

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
                    Identifier fuelId = dominantFuelId(rod);
                    if (fuelId != null) {
                        FuelDefinition def = FuelLoader.get(fuelId);
                        if (def != null && def.colorRgb() != null) {
                            rgb = def.colorRgb();
                        }
                    }
                }
            }
            return 0xFF000000 | (rgb & 0xFFFFFF);
        }
    }

    private static Identifier dominantFuelId(ReactorRodBlockEntity rod) {
        Identifier best = null;
        float bestUnits = 0f;
        for (ReactorRodBlockEntity.FuelEntry e : rod.getFuelEntries()) {
            if (e.units() > bestUnits) {
                bestUnits = e.units();
                best = e.id();
            }
        }
        return best;
    }
}
