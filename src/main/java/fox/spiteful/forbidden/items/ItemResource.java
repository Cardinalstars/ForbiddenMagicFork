package fox.spiteful.forbidden.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.forbidden.Forbidden;

public class ItemResource extends Item {

    @SideOnly(Side.CLIENT)
    public IIcon[] icons;

    public ItemResource() {
        this.setMaxStackSize(64);
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(Forbidden.tab);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister ir) {
        icons = new IIcon[5];

        icons[0] = ir.registerIcon("forbidden:emerald_nugget");
        icons[1] = ir.registerIcon("forbidden:dye_powder_black");
        icons[2] = ir.registerIcon("forbidden:nuggetmanasteel");
        icons[3] = ir.registerIcon("forbidden:tainted_blood_shard");
        icons[4] = ir.registerIcon("forbidden:nuggetelementium");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int dam) {
        return this.icons[dam % icons.length];
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        // int i = MathHelper.clamp_int(stack.getItemDamage(), 0, 3);
        int i = stack.getItemDamage();
        return super.getUnlocalizedName() + "." + i;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item par1, CreativeTabs xCreativeTabs, List list) {
        for (int j = 0; j < 5; ++j) {
            list.add(new ItemStack(par1, 1, j));
        }
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase yEntityLivingBase) {
        if (yEntityLivingBase instanceof EntitySheep && stack.getItemDamage() == 1) {
            EntitySheep entitysheep = (EntitySheep) yEntityLivingBase;

            if (!entitysheep.getSheared() && entitysheep.getFleeceColor() != 15) {
                entitysheep.setFleeceColor(15);
                --stack.stackSize;
            }

            return true;
        } else {
            return false;
        }
    }
}
