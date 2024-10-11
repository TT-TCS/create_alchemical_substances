package dev.tttcs.createalchsubs;

import dev.tttcs.createalchsubs.base.CreateAlchSubsRegistrate;
import dev.tttcs.createalchsubs.base.CreateAlchSubsTags;
import dev.tttcs.createalchsubs.base.CreateAlchSubsUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import dev.tttcs.createalchsubs.fluid.FluidRegistry;
import dev.tttcs.createalchsubs.item.ItemRegistry;
import org.jetbrains.annotations.NotNull;

@Mod(CreateAlchSubs.ID)
public class CreateAlchSubs {
    public static final String ID = "create_alchemical_substances";

    public static final CreateAlchSubsRegistrate REGISTRATE = CreateAlchSubsRegistrate.create();

    public CreateAlchSubs() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ItemRegistry.register(eventBus);
        FluidRegistry.register(eventBus);
        CreateAlchSubsUtils.register(eventBus);
        CreateAlchSubsTags.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static final CreativeModeTab TAB = new CreativeModeTab(ID) {
        @Override
        public @NotNull ItemStack makeIcon() {
            return ItemRegistry.OXYGEN_GAS_BUCKET.get().getDefaultInstance();
        }
    };

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(ID, path);
    }
}
