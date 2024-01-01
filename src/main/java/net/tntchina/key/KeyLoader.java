package net.tntchina.key;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.tntchina.TNTChina;

public class KeyLoader {
    public static KeyBinding esp;
    public static KeyBinding trueSight;

    public KeyLoader() {
        esp = new KeyBinding("ESP", TNTChina.getModule("ESP").getKey(), "TrueSight");
        trueSight = new KeyBinding("TrueSight", TNTChina.getModule("TrueSight").getKey(), "TrueSight");
        ClientRegistry.registerKeyBinding(esp);
        ClientRegistry.registerKeyBinding(trueSight);
    }

    public static void onKeyInput() {
        if (esp.isPressed()) {
            TNTChina.getModule("ESP").toggle();
        }

        if (trueSight.isPressed()) {
            TNTChina.getModule("TrueSight").toggle();
        }
    }
}