package net.tntchina.inputFix.impl;

import net.tntchina.inputFix.interfaces.IGuiScreen;
import net.tntchina.inputFix.interfaces.IGuiScreenFix;
import org.lwjgl.input.Keyboard;

public class GuiScreenFixWindows implements IGuiScreenFix {

    public void handleKeyboardInput(IGuiScreen gui) {
        char c = Keyboard.getEventCharacter();
        int k = Keyboard.getEventKey();

        if (Keyboard.getEventKeyState() || (k == 0 && Character.isDefined(c) && k != 209))
            gui.keyTyped(c, k);
    }
}
