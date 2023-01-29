package fox.spiteful.forbidden.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

import thaumcraft.common.items.equipment.ItemPrimalCrusher;

public class EnchantmentCorrupting extends Enchantment {

    public EnchantmentCorrupting(int id) {
        super(id, 1, EnumEnchantmentType.digger);
        setName("corrupting");
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinEnchantability(int par1) {
        return 20;
    }

    @Override
    public int getMaxEnchantability(int par1) {
        return super.getMinEnchantability(par1) + 50;
    }

    @Override
    public boolean canApply(ItemStack item) {
        if (item.getItem() instanceof ItemPickaxe || item.getItem() instanceof ItemPrimalCrusher) return true;
        else return false;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return false;
    }
}
