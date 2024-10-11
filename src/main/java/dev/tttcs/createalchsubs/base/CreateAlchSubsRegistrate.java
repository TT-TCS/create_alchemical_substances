package dev.tttcs.createalchsubs.base;

import com.simibubi.create.foundation.data.CreateRegistrate;
import dev.tttcs.createalchsubs.CreateAlchSubs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraftforge.registries.ForgeRegistries;

public class CreateAlchSubsRegistrate extends CreateRegistrate {

    public static String autoLang(String id) {
        StringBuilder builder = new StringBuilder();
        boolean b = true;
        for (char c : id.toCharArray()) {
            if (c == '_') {
                builder.append(' ');
                b = true;
            } else {
                builder.append(b ? String.valueOf(c).toUpperCase() : c);
                b = false;
            }
        }
        return builder.toString();
    }

    protected CreateAlchSubsRegistrate() {
        super(CreateAlchSubs.ID);
    }

    public static CreateAlchSubsRegistrate create() {
        return new CreateAlchSubsRegistrate();
    }

    public static Block getBlock(String name) {
        return CreateAlchSubs.REGISTRATE.get(name, ForgeRegistries.BLOCKS.getRegistryKey()).get();
    }

    public static Item getItem(String name) {
        return CreateAlchSubs.REGISTRATE.get(name, ForgeRegistries.ITEMS.getRegistryKey()).get();
    }

    public static Item getBucket(String name) {
        return CreateAlchSubs.REGISTRATE.get(name + "_bucket", ForgeRegistries.ITEMS.getRegistryKey()).get();
    }
}