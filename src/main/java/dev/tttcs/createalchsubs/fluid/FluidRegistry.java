package dev.tttcs.createalchsubs.fluid;

import com.simibubi.create.AllTags;
import com.simibubi.create.content.fluids.VirtualFluid;
import dev.tttcs.createalchsubs.CreateAlchSubs;
import dev.tttcs.createalchsubs.base.CreateAlchSubsTags;
import dev.tttcs.createalchsubs.base.CreateAlchSubsUtils;
import com.tterrag.registrate.util.entry.FluidEntry;
import dev.tttcs.createalchsubs.base.GasFluidBuilder;
import dev.tttcs.createalchsubs.item.ItemRegistry;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;

import static dev.tttcs.createalchsubs.CreateAlchSubs.REGISTRATE;

public class FluidRegistry {

    public static final FluidEntry<VirtualFluid>
            CARBON_DIOXIDE_GAS = gas("carbon_dioxide_gas", CreateAlchSubsTags.CreateAlchSubsFluidTags.CARBON_DIOXIDE.tag),
            HYDROGEN_GAS = gas("hydrogen_gas", CreateAlchSubsTags.CreateAlchSubsFluidTags.HYDROGEN.tag),
            NITROGEN_GAS= gas("nitrogen_gas", CreateAlchSubsTags.CreateAlchSubsFluidTags.NITROGEN.tag),
            OXYGEN_GAS = gas("oxygen_gas", CreateAlchSubsTags.CreateAlchSubsFluidTags.OXYGEN.tag)
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

    public static void register(IEventBus eventBus) {
    }
}
