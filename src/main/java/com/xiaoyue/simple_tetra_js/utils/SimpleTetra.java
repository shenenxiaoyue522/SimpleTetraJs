package com.xiaoyue.simple_tetra_js.utils;

import com.xiaoyue.simple_tetra_js.content.SimpleTetraStatGetter;
import net.minecraft.world.item.ItemStack;
import se.mickelus.tetra.blocks.workbench.gui.WorkbenchStatsGui;
import se.mickelus.tetra.effect.ItemEffect;
import se.mickelus.tetra.gui.stats.StatsHelper;
import se.mickelus.tetra.gui.stats.bar.GuiStatBar;
import se.mickelus.tetra.gui.stats.getter.*;
import se.mickelus.tetra.items.modular.ModularItem;
import se.mickelus.tetra.items.modular.impl.holo.gui.craft.HoloStatsGui;

import javax.annotation.Nullable;
import java.util.Collection;

public class SimpleTetra {

    public static ItemEffect getEffectOrCreate(String key) {
        return ItemEffect.get(key);
    }

    @Nullable
    public static Collection<ItemEffect> getAllEffects(ItemStack stack) {
        if (stack.getItem() instanceof ModularItem modular) {
            return modular.getEffects(stack);
        }
        return null;
    }

    public static boolean hasItemEffect(ItemStack stack, ItemEffect effect) {
        if (stack.getItem() instanceof ModularItem modular) {
            return modular.getEffectLevel(stack, effect) > 0;
        }
        return false;
    }

    public static int getEffectLevel(ItemStack stack, ItemEffect effect) {
        if (stack.getItem() instanceof ModularItem modular) {
            return modular.getEffectLevel(stack, effect);
        }
        return 0;
    }

    public static double getEffectEfficiency(ItemStack stack, ItemEffect effect) {
        if (stack.getItem() instanceof ModularItem modular) {
            return modular.getEffectEfficiency(stack, effect);
        }
        return 0;
    }

    public static SimpleTetraStatGetter newStatGetter(String effect, int multiplier) {
        return new SimpleTetraStatGetter(ItemEffect.get(effect), multiplier);
    }

    public static TooltipGetterInteger newTooltipGetter(String key, IStatGetter stat) {
        return new TooltipGetterInteger(key, stat);
    }

    public static GuiStatBar newStatBar(int x, int y, int length, String langKey, boolean segmented, IStatGetter stat, ILabelGetter label, ITooltipGetter tooltip) {
        return new GuiStatBar(x, y, length, langKey, 0, 10000, segmented, stat, label, tooltip);
    }

    public static GuiStatBar newSimpleStatBar(String langKey, String effect, String tooltipKey) {
        var stat = new SimpleTetraStatGetter(ItemEffect.get(effect), 1f);
        var tooltip = new TooltipGetterInteger(tooltipKey, stat);
        return new GuiStatBar(0, 0, StatsHelper.barLength, langKey, 0, 10000, false, stat, LabelGetterBasic.integerLabel, tooltip);
    }

    public static void addGuiBar(GuiStatBar bar) {
        WorkbenchStatsGui.addBar(bar);
    }
}
