package net.tntchina.truesight;

import com.google.common.eventbus.EventBus;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.LoadController;
import net.minecraftforge.fml.common.ModMetadata;
import net.tntchina.TNTChina;

import java.util.Arrays;

public class ModContainer extends DummyModContainer {

    public ModContainer() {
        super(new ModMetadata());
        ModMetadata data = getMetadata();
        data.modId = TNTChina.MOD_MODID;
        data.name = TNTChina.MOD_NAME;
        data.version = TNTChina.MOD_VERSION;
        data.url = TNTChina.MOD_URL;
        data.authorList = Arrays.asList(new String[]{"[TNTChina]"});
        data.description = "The hack mod by TNTChina.His QQ number is 3274578216";
    }

    public Object getMod() {
        return this;
    }

    public boolean registerBus(EventBus bus, LoadController controller) {
        bus.register(this);
        return true;
    }
}