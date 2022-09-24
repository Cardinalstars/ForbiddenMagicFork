package fox.spiteful.forbidden.items.scribes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.forbidden.Forbidden;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import thaumcraft.api.IScribeTools;

public class ItemPrimewell extends Item implements IScribeTools {

    @SideOnly(Side.CLIENT)
    public IIcon icon;

    public ItemPrimewell() {
        maxStackSize = 1;
        canRepair = false;
        setMaxDamage(100);
        setCreativeTab(Forbidden.tab);
        setHasSubtypes(false);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister ir) {
        this.icon = ir.registerIcon("forbidden:primewell");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int par1) {
        return this.icon;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.epic;
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        super.setDamage(stack, 0);
    }
}
