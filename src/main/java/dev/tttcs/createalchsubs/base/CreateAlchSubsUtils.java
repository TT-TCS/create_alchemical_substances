package dev.tttcs.createalchsubs.base;

import net.minecraftforge.eventbus.api.IEventBus;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CreateAlchSubsUtils {
    public static String fromId(String key) {
        String s = key.replaceAll("_", " ");
        s = Arrays.stream(StringUtils.splitByCharacterTypeCamelCase(s)).map(StringUtils::capitalize).collect(Collectors.joining(" "));
        s = StringUtils.normalizeSpace(s);
        return s;
    }

    public static void register(IEventBus eventBus) {
    }
}
