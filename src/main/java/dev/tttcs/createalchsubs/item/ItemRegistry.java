package dev.tttcs.createalchsubs.item;

import com.tterrag.registrate.util.entry.ItemEntry;
import dev.tttcs.createalchsubs.CreateAlchSubs;
import dev.tttcs.createalchsubs.fluid.FluidRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreateAlchSubs.ID);

    public static final RegistryObject<Item> CLEAN_RAW_COPPER = ITEMS.register("clean_raw_copper",
            () ->  new Item(new Item.Properties()
            ));

    public static final RegistryObject<Item> COBALT_NUGGET = ITEMS.register("cobalt_nugget",
            () ->  new Item(new Item.Properties()
                    .tab(CreateAlchSubs.TAB)
            ));

    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot",
            () ->  new Item(new Item.Properties()
                    .tab(CreateAlchSubs.TAB)
            ));

    public static final RegistryObject<Item> COBALT_SHEET = ITEMS.register("cobalt_sheet",
            () ->  new Item(new Item.Properties()
                    .tab(CreateAlchSubs.TAB)
            ));

    public static final RegistryObject<Item> COBALT_CATALYST = ITEMS.register("cobalt_catalyst",
            () ->  new Item(new Item.Properties()
                    .tab(CreateAlchSubs.TAB)
            ));

    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () ->  new Item(new Item.Properties()
                    .tab(CreateAlchSubs.TAB)
            ));

    public static final RegistryObject<Item> ZEOLITE = ITEMS.register("zeolite",
            () ->  new Item(new Item.Properties()
                    .tab(CreateAlchSubs.TAB)
            ));

    public static final RegistryObject<Item> NITROGEN_ZEOLITE = ITEMS.register("nitrogen_zeolite",
            () ->  new Item(new Item.Properties()
                    .tab(CreateAlchSubs.TAB)
            ));

    public static final RegistryObject<Item> FINE_SUGAR = ITEMS.register("fine_sugar",
            () ->  new Item(new Item.Properties()
                    .tab(CreateAlchSubs.TAB)
            ));

    public static final RegistryObject<Item> COMPRESSED_AIR_BUCKET = ITEMS.register("compressed_air_bucket",
            () ->  new Item(new Item.Properties()
                    .tab(CreateAlchSubs.TAB)
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
