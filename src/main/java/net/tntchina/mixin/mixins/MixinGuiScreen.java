package net.tntchina.mixin.mixins;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.tntchina.inputFix.GuiScreenFix;
import net.tntchina.mixin.impls.IGuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

@SideOnly(Side.CLIENT)
@Mixin({GuiScreen.class})
public abstract class MixinGuiScreen implements IGuiScreen {
    @Shadow
    public Minecraft mc;

    public GuiScreen gui;

    @Inject(method = "<init>", at = {@At("RETURN")})
    public void onInit(CallbackInfo callbackInfo) {
        this.gui = (GuiScreen) ((Object) this);
    }

    @Inject(method = "handleKeyboardInput", at = {@At("HEAD")}, cancellable = true)
    public void handleKeyboardInput(CallbackInfo callbackInfo) {
        GuiScreenFix.handleKeyboardInput(this.gui);
        callbackInfo.cancel();
    }

    public void onKeyTyped(char paramChar, int paramInt) throws IOException {
        this.keyTyped(paramChar, paramInt);
    }

    @Shadow
    public abstract void keyTyped(char paramChar, int paramInt) throws IOException;
}
