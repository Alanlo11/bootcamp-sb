package com.bootcamp.pokemon;

import java.util.HashSet;
import java.util.Set;
import com.bootcamp.pokemon.Moves.Moves;

public abstract class Pokemon<T extends Moves> implements Attackable{
  private String name;
  private PokemonType pokemonType;
  private Set<T> moves;

  public Pokemon(String name, PokemonType type){
    this.name = name;
    this.pokemonType = type;
    this.moves = new HashSet<>();
  }

  public String getName(){
    return this.name;
  }

  public PokemonType getPokemonType(){
    return this.pokemonType;
  }

  public boolean learnMove(T move){
    if(moves.size() < 4 && !moves.contains(move)){
      moves.add(move);
      return true;
    }
    return false;
  }

  public boolean forgetMove(T move){
    return this.moves.remove(move);
  }

  public Set<T> getMoves(){
    return this.moves;
  }

  public abstract String specialAbility();
}
