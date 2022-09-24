package fox.spiteful.forbidden.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import thaumcraft.common.items.equipment.ItemPrimalCrusher;

public class EnchantmentConsuming extends Enchantment {
    public EnchantmentConsuming(int id) {
        super(id, 5, EnumEnchantmentType.digger);
        setName("consuming");
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean canApplyTogether(Enchantment ench) {
        return super.canApplyTogether(ench) && ench.effectId != Enchantment.silkTouch.effectId;
    }

    @Override
    public boolean canApply(ItemStack item) {
        if (item.getItem() instanceof ItemPickaxe
                || item.getItem() instanceof ItemSpade
                || item.getItem() instanceof ItemPrimalCrusher) return true;
        else return false;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return false;
    }
}
