package cn.xgheaven.usefulsolar;

import cn.xgheaven.usefulsolar.common.proxy.CommonProxy;
import cn.xgheaven.usefulsolar.tile.USBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "usefulsolar";
    public static final String VERSION = "0.2.0";

    // proxy
    @SidedProxy(clientSide = "cn.xgheaven.usefulsolar.common.proxy.ClientProxy", serverSide = "cn.xgheaven.usefulsolar.common.proxy.ServerProxy")
    public static CommonProxy proxy;

    // tab
    public static final CreativeTabs USTab = new CreativeTabs("usefulsolartab") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(USBlocks.advance_solar);
        }
    };

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent e) {
		// some example code
        proxy.init(e);
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
