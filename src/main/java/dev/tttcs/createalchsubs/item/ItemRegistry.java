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

import static dev.tttcs.createalchsubs.CreateAlchSubs.REGISTRATE;
import static dev.tttcs.createalchsubs.fluid.FluidRegistry.*;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreateAlchSubs.ID);

    public static final RegistryObject<Item> CLEAN_RAW_COPPER = ITEMS.register("clean_raw_copper",
            () ->  new Item(new
                    Item.Properties()
            ));

    public static final RegistryObject<Item> COBALT_NUGGET = ITEMS.register("cobalt_nugget",
            () ->  new Item(new
                    Item.Properties()
                    .tab(CreateAlchSubs.TAB)
            ));

    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot",
            () ->  new Item(new
                    Item.Properties()
                    .tab(CreateAlchSubs.TAB)
            ));

    public static final RegistryObject<Item> SALT = ITEMS.register("salt",
            () ->  new Item(new
                    Item.Properties()
                    .tab(CreateAlchSubs.TAB)
            ));

    public static final RegistryObject<Item> HYDROGEN_GAS_BUCKET = ITEMS.register("hydrogen_gas_bucket",
            () ->  new Item(new
                    Item.Properties()
                    .stacksTo(1)
                    .craftRemainder(Items.BUCKET)
                    .tab(CreateAlchSubs.TAB)
            ));

    public static final RegistryObject<Item> NITROGEN_GAS_BUCKET = ITEMS.register("nitrogen_gas_bucket",
            () ->  new Item(new
                    Item.Properties()
                    .stacksTo(1)
                    .craftRemainder(Items.BUCKET)
                    .tab(CreateAlchSubs.TAB)
            ));

    public static final RegistryObject<Item> CARBON_DIOXIDE_GAS_BUCKET = ITEMS.register("carbon_dioxide_gas_bucket",
            () ->  new Item(new
                    Item.Properties()
                    .stacksTo(1)
                    .craftRemainder(Items.BUCKET)
                    .tab(CreateAlchSubs.TAB)
            ));

    public static final RegistryObject<Item> OXYGEN_GAS_BUCKET = ITEMS.register("oxygen_gas_bucket",
            () ->  new Item(new
                    Item.Properties()
                    .stacksTo(1)
                    .craftRemainder(Items.BUCKET)
                    .tab(CreateAlchSubs.TAB)
            ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
