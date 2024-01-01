/*    */
package net.tntchina.truesight;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;
import net.tntchina.inputFix.InputFixSetup;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import java.util.Map;

@TransformerExclusions({"net.tntchina."})
@MCVersion("1.8.9")
public class TrueSight implements IFMLLoadingPlugin {

    public TrueSight() {
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.tntchina.json");
        MixinEnvironment.getDefaultEnvironment().setSide(MixinEnvironment.Side.CLIENT);
    }

    public String[] getASMTransformerClass() {
        return new String[0];
    }

    public String getModContainerClass() {
        return ModContainer.class.getName();
    }

    public String getSetupClass() {
        return InputFixSetup.class.getName();
    }


    public void injectData(Map<String, Object> data) {}

    public String getAccessTransformerClass() {
        return null;
    }
}
