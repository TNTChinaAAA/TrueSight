package net.tntchina.inputFix;

import net.minecraft.client.gui.GuiScreen;
import net.tntchina.inputFix.interfaces.IGuiScreen;
import org.lwjgl.input.Keyboard;

public class GuiScreenFix {

    private static final ThreadLocal<Proxy> proxies = new ThreadLocal<Proxy>() {
        protected GuiScreenFix.Proxy initialValue() {
            return new GuiScreenFix.Proxy();
        }
    };

    public static void handleKeyboardInput(GuiScreen gui) {
        Proxy p = proxies.get().setGui(gui);

        if (InputFixSetup.impl != null) {
            InputFixSetup.impl.handleKeyboardInput(p);
        } else if (Keyboard.getEventKeyState()) {
            p.keyTyped(Keyboard.getEventCharacter(), Keyboard.getEventKey());
        }

        gui.mc.dispatchKeypresses();
    }

    private static class Proxy implements IGuiScreen {
        public GuiScreen gui;

        private Proxy() {
        }

        public void keyTyped(char c, int k) {
            try {
                if (this.gui != null) {
                    ((net.tntchina.mixin.impls.IGuiScreen) this.gui).onKeyTyped(c, k);
                }

            } catch (Throwable t) {
                throw new RuntimeException(t);
            }
        }

        public Proxy setGui(GuiScreen gui) {
            this.gui = gui;
            return this;
        }
    }
}
