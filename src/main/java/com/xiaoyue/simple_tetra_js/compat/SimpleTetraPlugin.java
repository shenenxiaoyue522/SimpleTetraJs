package com.xiaoyue.simple_tetra_js.compat;

import com.xiaoyue.simple_tetra_js.utils.SimpleTetra;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import se.mickelus.tetra.gui.stats.getter.LabelGetterBasic;

public class SimpleTetraPlugin extends KubeJSPlugin {

    @Override
    public void registerBindings(BindingsEvent event) {
        event.add("BasicLabelGetter", LabelGetterBasic.class);
        event.add("SimpleTetra", SimpleTetra.class);
    }
}
