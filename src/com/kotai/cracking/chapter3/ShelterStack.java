package com.kotai.cracking.chapter3;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import lombok.Getter;

/*
 * An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out
 * " basis. People must adopt either the "oldest" (based on arrival time) of all animals at the
 * shelter, or they can select whether they would prefer a dog or a cat (and will receive the oldest
 * animal of that type). They cannot select which specific animal they would like. Create the data
 * structures to maintain this system and implement operations such as enqueue, dequeueAny,
 * dequeueDog and dequeueCat.You may use the built-in LinkedList data structure
 */
public class ShelterStack {

  private LinkedList<Animal> adoptionList;

  public ShelterStack() {
    adoptionList = new LinkedList<>();
  }

  public Animal dequeue() {
    return adoptionList.isEmpty() ? null : adoptionList.removeFirst();
  }

  public Animal dequeueCat() {
    return adoptAnimalOfType(AnimalType.CAT);
  }

  public Animal dequeueDog() {
    return adoptAnimalOfType(AnimalType.DOG);
  }

  private Animal adoptAnimalOfType(AnimalType typeRequired) {
    Animal animalToAdopt = null;
    Iterator<Animal> adoptionIterator = adoptionList.iterator();
    boolean found = false;
    while (adoptionIterator.hasNext() && !found) {
      Animal currentAnimal = adoptionIterator.next();
      if (currentAnimal.type == typeRequired) {
        found = true;
        adoptionIterator.remove();
        animalToAdopt = currentAnimal;
      }
    }
    return animalToAdopt;
  }


  public void enqueue(Animal animal) {
    adoptionList.addLast(animal);
    Collections.sort(adoptionList, Collections.reverseOrder());
  }

  public static enum AnimalType {
    DOG, CAT
  }


  public static class Animal implements Comparable<Animal> {
    @Getter
    private Integer age;
    @Getter
    private final AnimalType type;

    public Animal(AnimalType type, int age) {
      this.type = type;
      this.age = age;
    }

    @Override
    public int compareTo(Animal otherAnimal) {
      return age.compareTo(otherAnimal.age);
    }

    /**
     * All animals the same type and age are equal
     */
    @Override
    public boolean equals(Object o) {
      if (o instanceof Animal) {
        Animal otherAnimal = (Animal) o;
        if (this.type == otherAnimal.type && this.age == otherAnimal.age) {
          return true;
        }
      }
      return false;
    }

    @Override
    public String toString() {
      return type.toString() + " " + age;
    }
  }
}
