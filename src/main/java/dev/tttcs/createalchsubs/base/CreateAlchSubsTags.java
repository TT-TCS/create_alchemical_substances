package dev.tttcs.createalchsubs.base;

import com.simibubi.create.foundation.utility.Lang;
import dev.tttcs.createalchsubs.CreateAlchSubs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Collections;

import static dev.tttcs.createalchsubs.base.CreateAlchSubsTags.NameSpace.FORGE;
import static dev.tttcs.createalchsubs.base.CreateAlchSubsTags.NameSpace.MOD;


public class CreateAlchSubsTags {
    public static <T> TagKey<T> optionalTag(IForgeRegistry<T> registry,
                                            ResourceLocation id) {
        return registry.tags()
                .createOptionalTagKey(id, Collections.emptySet());
    }

    public static <T> TagKey<T> forgeTag(IForgeRegistry<T> registry, String path) {
        return optionalTag(registry, new ResourceLocation("forge", path));
    }

    public static TagKey<Block> forgeBlockTag(String path) {
        return forgeTag(ForgeRegistries.BLOCKS, path);
    }

    public static TagKey<Item> forgeItemTag(String path) {
        return forgeTag(ForgeRegistries.ITEMS, path);
    }

    public static TagKey<Fluid> forgeFluidTag(String path) {
        return forgeTag(ForgeRegistries.FLUIDS, path);
    }

    public enum NameSpace {

        MOD(CreateAlchSubs.ID, false, true),
        FORGE("forge")


        ;

        public final String id;
        public final boolean optionalDefault;
        public final boolean alwaysDatagenDefault;

        NameSpace(String id) {
            this(id, true, false);
        }

        NameSpace(String id, boolean optionalDefault, boolean alwaysDatagenDefault) {
            this.id = id;
            this.optionalDefault = optionalDefault;
            this.alwaysDatagenDefault = alwaysDatagenDefault;
        }
    }


    public enum CreateAlchSubsFluidTags {
        GAS(MOD),

        FLAMMABLE(MOD),

        OXYGEN(FORGE),
        HYDROGEN(FORGE),
        NITROGEN(FORGE),
        CARBON_DIOXIDE(FORGE),

        FUEL(FORGE);

        public final TagKey<Fluid> tag;
        public final boolean alwaysDatagen;

        CreateAlchSubsFluidTags() {
            this(MOD);
        }

        CreateAlchSubsFluidTags(CreateAlchSubsTags.NameSpace namespace) {
            this(namespace, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }

        CreateAlchSubsFluidTags(CreateAlchSubsTags.NameSpace namespace, String path) {
            this(namespace, path, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }

        CreateAlchSubsFluidTags(CreateAlchSubsTags.NameSpace namespace, boolean optional, boolean alwaysDatagen) {
            this(namespace, null, optional, alwaysDatagen);
        }

        CreateAlchSubsFluidTags(CreateAlchSubsTags.NameSpace namespace, String path, boolean optional, boolean alwaysDatagen) {
            ResourceLocation id = new ResourceLocation(namespace.id, path == null ? Lang.asId(name()) : path);
            if (optional) {
                tag = optionalTag(ForgeRegistries.FLUIDS, id);
            } else {
                tag = FluidTags.create(id);
            }
            this.alwaysDatagen = alwaysDatagen;
        }

        @SuppressWarnings("deprecation")
        public boolean matches(Fluid fluid) {
            return fluid.is(tag);
        }

        public boolean matches(FluidState state) {
            return state.is(tag);
        }

        private static void init() {
        }

    }

        public static void init() {
            CreateAlchSubsFluidTags.init();
        }

    public static void register(IEventBus bus) {
    }
}