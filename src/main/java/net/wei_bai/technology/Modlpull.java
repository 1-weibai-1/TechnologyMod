package net.wei_bai.technology;


import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import static net.wei_bai.technology.init.TechnologyModItems.ROUGHLONGBOW;


public class Modlpull {

	//添加自定义项目属性
	public static void addCustomItemProperties(){
		makeBow(ROUGHLONGBOW.get());

	}
	//拉弓
	private static void makeBow(Item item) {
		ItemProperties.register(item, new ResourceLocation("pull"), (p_174635_, p_174636_, p_174637_, p_174638_) -> {
			if (p_174637_ == null) {
				return 0.0F;
			} else {
				return p_174637_.getUseItem() != p_174635_ ? 0.0F : (float) (p_174635_.getUseDuration() - p_174637_.getUseItemRemainingTicks()) / 20.0F;
			}
		});
		ItemProperties.register(item, new ResourceLocation("pulling"), (p_174630_, p_174631_, p_174632_, p_174633_) -> {
			return p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F;
		});
	}
	//在Modlpull添加makeItem方法用于创建物品，它接收一个Item参数，并使用ItemProperties.register方法注册了两个自定义属性：pull和pulling。pull属性可以设置1~10的数字每个数字可以显示不同的动画（动画不需要制作，动画会在。json中制作），pulling属性用于判断物品是否正在使用中。

}
