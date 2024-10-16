package dev.tttcs.createalchsubs.fluid;

import com.mojang.math.Vector3f;
import com.simibubi.create.AllFluids;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.fluids.VirtualFluid;
import com.simibubi.create.foundation.utility.Color;
import com.simibubi.create.infrastructure.config.AllConfigs;
import com.tterrag.registrate.builders.FluidBuilder;
import dev.tttcs.createalchsubs.CreateAlchSubs;
import dev.tttcs.createalchsubs.base.CreateAlchSubsTags;
import dev.tttcs.createalchsubs.base.CreateAlchSubsUtils;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static dev.tttcs.createalchsubs.CreateAlchSubs.REGISTRATE;

public class FluidRegistry {
    static {
        REGISTRATE.setCreativeTab(CreateAlchSubs.TAB);
    }

    public static final FluidEntry<ForgeFlowingFluid.Flowing> ETHANOL =
            REGISTRATE.standardFluid("ethanol",
                            SolidRenderedPlaceableFluidType.create(0xE6DADECF,
                                    () -> 1f))
                    .lang("Ethanol")
                    .tag(CreateAlchSubsTags.forgeFluidTag("ethanol"))
                    .properties(b -> b.viscosity(5)
                            .density(5).canExtinguish(false))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(4)
                            .slopeFindDistance(2)
                            .explosionResistance(100f))
                    .source(ForgeFlowingFluid.Source::new) // TODO: remove when Registrate fixes FluidBuilder
                    .bucket()
                    .lang("Ethanol Tank")
                    .build()
                    .register();

    public static final FluidEntry<VirtualFluid> AIR = REGISTRATE.virtualFluid("compressed_air", CreateAlchSubs.asResource("fluid/compressed_air"), CreateAlchSubs.asResource("fluid/compressed_air"))
            .lang("Compressed Air")
            .register();

    public static final FluidEntry<VirtualFluid>
            CARBON_DIOXIDE = gas("carbon_dioxide", CreateAlchSubsTags.CreateAlchSubsFluidTags.CARBON_DIOXIDE.tag),
            HYDROGEN = gas("hydrogen", CreateAlchSubsTags.CreateAlchSubsFluidTags.HYDROGEN.tag),
            NITROGEN= gas("nitrogen", CreateAlchSubsTags.CreateAlchSubsFluidTags.NITROGEN.tag),
            OXYGEN = gas("oxygen", CreateAlchSubsTags.CreateAlchSubsFluidTags.OXYGEN.tag),
            AMMONIA = gas("ammonia")
    ;

    @SafeVarargs
    public static FluidEntry<VirtualFluid> gas(String name, TagKey<Fluid>... tags){
        TagKey<Fluid> tag = FluidTags.create(CreateAlchSubs.asResource(name));

        TagKey<Fluid>[] fluidTags = tags;

        if(tags.length==0){

            fluidTags = new TagKey[]{tag};

        }

        return REGISTRATE.virtualFluid(name,CreateAlchSubs.asResource("fluid/"+name),CreateAlchSubs.asResource("fluid/"+name))
                .lang(CreateAlchSubsUtils.fromId(name))
                .tag(tags)
                .tag(CreateAlchSubsTags.CreateAlchSubsFluidTags.GAS.tag)
                .bucket()
                .lang(CreateAlchSubsUtils.fromId(name)+" Tank")
                .tag(AllTags.forgeItemTag("buckets/"+name))
                .build()
                .register();
    }

    private static class SolidRenderedPlaceableFluidType extends AllFluids.TintedFluidType {

        private Vector3f fogColor;
        private Supplier<Float> fogDistance;

        public static FluidBuilder.FluidTypeFactory create(int fogColor, Supplier<Float> fogDistance) {
            return (p, s, f) -> {
                SolidRenderedPlaceableFluidType fluidType = new SolidRenderedPlaceableFluidType(p, s, f);
                fluidType.fogColor = new Color(fogColor, false).asVectorF();
                fluidType.fogDistance = fogDistance;
                return fluidType;
            };
        }

        private SolidRenderedPlaceableFluidType(Properties properties, ResourceLocation stillTexture,
                                                ResourceLocation flowingTexture) {
            super(properties, stillTexture, flowingTexture);
        }
        @Override
        protected int getTintColor(FluidStack stack) {
            return NO_TINT;
        }
        @Override
        public int getTintColor(FluidState state, BlockAndTintGetter world, BlockPos pos) {
            return 0x00ffffff;
        }
        @Override
        protected Vector3f getCustomFogColor() {
            return fogColor;
        }
        @Override
        protected float getFogDistanceModifier() {
            return fogDistance.get();
        }
    }

        public static void register(IEventBus eventBus) {
    }
}
