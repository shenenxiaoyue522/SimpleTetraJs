package com.xiaoyue.simple_tetra_js.content;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import se.mickelus.tetra.effect.ItemEffect;
import se.mickelus.tetra.gui.stats.getter.StatGetterEffectLevel;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class SimpleTetraStatGetter extends StatGetterEffectLevel {
    public SimpleTetraStatGetter(ItemEffect effect, double multiplier, double base) {
        super(effect, multiplier);
    }

    public SimpleTetraStatGetter(ItemEffect effect, double multiplier) {
        super(effect, multiplier, 0.0);
    }

    @Override
    public boolean shouldShow(Player player, ItemStack currentStack, ItemStack previewStack) {
        return true;
    }
}
