
package net.wei_bai.technology.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import net.wei_bai.technology.init.TechnologyModItems;
import net.wei_bai.technology.init.TechnologyModTabs;

public abstract class Granitecrushedstone_kuijia_armorArmorItem extends ArmorItem {
	public Granitecrushedstone_kuijia_armorArmorItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 8;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{(int) 1.5, (int)3.0, (int)4.5, (int) 1.5}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 9;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(TechnologyModItems.GRANITECRUSHEDSTONE.get()));
			}

			@Override
			public String getName() {
				return "granitecrushedstone_kuijia_armor_armor";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, slot, properties);
	}

	public static class Helmet extends Granitecrushedstone_kuijia_armorArmorItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(TechnologyModTabs.TAB_TECHNOLOGYTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "technology:textures/models/armor/granitecrushedstone_kuijia_armor_layer_1.png";
		}
	}

	public static class Chestplate extends Granitecrushedstone_kuijia_armorArmorItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(TechnologyModTabs.TAB_TECHNOLOGYTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "technology:textures/models/armor/granitecrushedstone_kuijia_armor_layer_1.png";
		}
	}

	public static class Leggings extends Granitecrushedstone_kuijia_armorArmorItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(TechnologyModTabs.TAB_TECHNOLOGYTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "technology:textures/models/armor/granitecrushedstone_kuijia_armor_layer_2.png";
		}
	}

	public static class Boots extends Granitecrushedstone_kuijia_armorArmorItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(TechnologyModTabs.TAB_TECHNOLOGYTAB));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "technology:textures/models/armor/granitecrushedstone_kuijia_armor_layer_1.png";
		}
	}
}
