package net.tntchina;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.GuiIngameForge;
import java.util.concurrent.atomic.AtomicInteger;

public class GuiIngameHook extends GuiIngameForge {

    public GuiIngameHook(Minecraft mc) {
        super(mc);
    }

    public void renderGameOverlay(float partialTicks) {
        super.renderGameOverlay(partialTicks);
        ScaledResolution sr = new ScaledResolution(this.mc);
        int width = sr.getScaledWidth();
        int height = sr.getScaledHeight();
        GlStateManager.pushMatrix();
        AtomicInteger index = new AtomicInteger();
        int i = height - 2 - TNTChina.MODULES.size() * 12;

        for (Module m : TNTChina.MODULES) {
            int color = TNTChina.rainbow(index.get() * 320);
            int x = 2;
            String str = m.getName() + ": " + (m.getState() ? "Enabled" : "Disabled");
            GuiUtil.drawRect((x + 2), (i + 1), (this.mc.fontRendererObj.getStringWidth(str) + 1), 10.0D, 1073741824);
            this.mc.fontRendererObj.drawStringWithShadow(str, (x + 3), (i + 1), color);
            i += 12;
            index.getAndIncrement();
        }

        GlStateManager.popMatrix();
    }
}
