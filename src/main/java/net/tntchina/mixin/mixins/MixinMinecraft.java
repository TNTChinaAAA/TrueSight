package net.tntchina.mixin.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.tntchina.GuiIngameHook;
import net.tntchina.TNTChina;
import net.tntchina.key.KeyLoader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SideOnly(Side.CLIENT)
@Mixin({Minecraft.class})
public abstract class MixinMinecraft {

    @Inject(method = "<init>", at = {@At("RETURN")})
    public void init(CallbackInfo callbackInfo) {
        TNTChina.INSTANCE = new TNTChina();
    }

    @Inject(method = "dispatchKeypresses", at = {@At("HEAD")})
    private void invokeKey(CallbackInfo callbackInfo) {
        KeyLoader.onKeyInput();
    }

    @Inject(method = "startGame", at = {@At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;ingameGUI:Lnet/minecraft/client/gui/GuiIngame;", shift = At.Shift.AFTER)})
    private void startGame(CallbackInfo callbackInfo) {
        setIngameGui(new GuiIngameHook(Minecraft.getMinecraft()));
        new KeyLoader();
    }

    @Accessor("ingameGUI")
    public abstract void setIngameGui(GuiIngame paramGuiIngame);
}
