package com.bootcamp.pokemon.Moves;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FireMove implements Moves{
  ARMOR_CANNON("Armor cannon", MoveCategory.SPECIAL,120 , 9),
  BITTER_BLADE("Bitter Blade", MoveCategory.PHYSICAL, 90, 9);

  private final String name;
  private final MoveCategory moveCategory;
  private final int power;
  private final int generation;

  @Override
  public String getName(){
    return this.name;
  }

  @Override
  public int getPower(){
    return this.power;
  }

  @Override
  public int getGeneration(){
    return this.generation;
  }

  @Override
  public MoveCategory getMoveCategory(){
    return this.moveCategory;
  }

}
