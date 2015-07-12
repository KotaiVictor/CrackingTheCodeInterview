package com.kotai.cracking.chapter3.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kotai.cracking.chapter3.ShelterStack;
import com.kotai.cracking.chapter3.ShelterStack.Animal;
import com.kotai.cracking.chapter3.ShelterStack.AnimalType;

public class ShelterStackTest {

  private ShelterStack shelter;

  @Before
  public void setup() {
    shelter = new ShelterStack();
  }

  @Test
  public void cannot_adopt_when_shelter_is_empty() {
    assertThat(shelter.dequeue(), equalTo(null));
    assertThat(shelter.dequeueCat(), equalTo(null));
    assertThat(shelter.dequeueDog(), equalTo(null));
  }

  @Test
  public void adopting_dogs_is_possible() {
    Animal abandonedDog = new Animal(AnimalType.DOG, 5);
    shelter.enqueue(abandonedDog);
    assertThat(shelter.dequeueDog(), equalTo(abandonedDog));
  }

  @Test
  public void adopting_cats_is_possible() {
    Animal abandonedCat = new Animal(AnimalType.CAT, 2);
    shelter.enqueue(abandonedCat);
    assertThat(shelter.dequeueCat(), equalTo(abandonedCat));
  }

  @Test
  public void adopting_an_animal_will_return_the_oldest_one() {
    Animal cat = new Animal(AnimalType.CAT, 5);
    shelter.enqueue(cat);
    Animal dog = new Animal(AnimalType.DOG, 6);
    shelter.enqueue(dog);
    Animal dog2 = new Animal(AnimalType.DOG, 4);
    shelter.enqueue(dog2);

    assertThat(shelter.dequeue(), equalTo(dog));
    assertThat(shelter.dequeue(), equalTo(cat));
    assertThat(shelter.dequeue(), equalTo(dog2));
    assertThat(shelter.dequeue(), equalTo(null));
  }

  @Test
  public void adopting_a_dog_will_return_the_oldest_one() {
    Animal dog = new Animal(AnimalType.DOG, 6);
    shelter.enqueue(dog);
    Animal dog2 = new Animal(AnimalType.DOG, 3);
    shelter.enqueue(dog2);
    Animal dog3 = new Animal(AnimalType.DOG, 4);
    shelter.enqueue(dog3);

    assertThat(shelter.dequeueDog(), equalTo(dog));
  }

  @Test
  public void adopting_a_cat_will_return_the_oldest_one() {
    Animal cat = new Animal(AnimalType.CAT, 4);
    shelter.enqueue(cat);
    Animal cat2 = new Animal(AnimalType.CAT, 5);
    shelter.enqueue(cat2);
    Animal cat3 = new Animal(AnimalType.CAT, 2);
    shelter.enqueue(cat3);

    assertThat(shelter.dequeueCat(), equalTo(cat2));
  }
}
