package name.luckyseed;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Environment(EnvType.CLIENT)
public class LuckySeed implements ModInitializer  {
    public static final Logger LOGGER = LogManager.getLogger("luckyseed");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
	}
}