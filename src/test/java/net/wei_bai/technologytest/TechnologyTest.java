/*
 * Copyright (c) 2018-2020 C4
 *
 * This file is part of Curios, a mod made for Minecraft.
 *
 * Curios is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Curios is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Curios.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.wei_bai.technologytest;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.wei_bai.technologytest.common.ModItems;

import javax.annotation.Nonnull;

@Mod("technologytest")
public class TechnologyTest {


  public static final CreativeModeTab TAB = new CreativeModeTab("technologytest") {
    @Override
    @Nonnull
    public ItemStack makeIcon() {
      return new ItemStack(ModItems.AMULET.get());
    }
  };

  public TechnologyTest() {
    ModItems.init();
  }




}
