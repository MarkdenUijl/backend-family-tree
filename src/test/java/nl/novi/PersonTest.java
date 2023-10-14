package nl.novi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class PersonTest {
    Person me;

    @BeforeEach
    void setUp() {
        me = new Person("Mark", "den Uijl", 'm', 30);
    }

    @AfterEach
    void tearDown() {
        me = null;
    }

    @Test
    void getName() {
        // arrange
        String expectedName = "Mark";

        // act
        String name = me.getName();

        // assert
        assertEquals(expectedName, name);
    }

    @Test
    void setName() {
        // arrange
        String newName = "Marcel";

        // act
        me.setName(newName);

        // assert
        assertEquals(newName, me.getName());
    }

    @Test
    void getMiddleName() {
        // assert
        assertNull(me.getMiddleName());
    }

    @Test
    void setMiddleName() {
        // arrange
        String newMiddleName = "Marie";

        // act
        me.setMiddleName(newMiddleName);

        // assert
        assertEquals(newMiddleName, me.getMiddleName());
    }

    @Test
    void getLastName() {
        // arrange
        String expectedLastName = "den Uijl";

        // act
        String lastName = me.getLastName();

        // assert
        assertEquals(expectedLastName, lastName);
    }

    @Test
    void setLastName() {
        // arrange
        String newLastName = "Uijlemans";

        // act
        me.setLastName(newLastName);

        // assert
        assertEquals(newLastName, me.getLastName());
    }

    @Test
    void getSex() {
        // arrange
        char expectedSex = 'm';

        // act
        char sex = me.getSex();

        // assert
        assertEquals(expectedSex, sex);
    }

    @Test
    void setSex() {
        // arrange
        char newSex = 'f';

        // act
        me.setSex(newSex);

        // assert
        assertEquals(newSex, me.getSex());
    }

    @Test
    void getAge() {
        // arrange
        int expectedAge = 30;

        // act
        int age = me.getAge();

        // assert
        assertEquals(expectedAge, age);
    }

    @Test
    void setAge() {
        // arrange
        int newAge = 34;

        // act
        me.setAge(newAge);

        // assert
        assertEquals(newAge, me.getAge());
    }

    @Test
    void getMother() {
        // arrange
        Person mother = new Person("Moeder", "den Uijl", 'f', 53);

        // act
        me.setMother(mother);
        Person actualMother = me.getMother();

        // assert
        assertEquals(mother, actualMother);
    }

    @Test
    void setMother() {
        // arrange
        Person mother = new Person("Moeder", "den Uijl", 'f', 53);

        // act
        me.setMother(mother);

        // assert
        assertEquals(mother, me.getMother());
    }

    @Test
    void getFather() {
        // arrange
        Person father = new Person("Vader", "den Uijl", 'm', 60);

        // act
        me.setFather(father);
        Person actualFather = me.getFather();

        // assert
        assertEquals(father, actualFather);
    }

    @Test
    void setFather() {
        // arrange
        Person father = new Person("Vader", "den Uijl", 'm', 60);

        // act
        me.setFather(father);

        // assert
        assertEquals(father, me.getFather());
    }

    @Test
    void getSiblings() {
        // arrange
        Person sibling = new Person("Broer", "den Uijl", 'm', 31);

        // act
        me.addSibling(sibling);
        List<Person> siblings = me.getSiblings();
        Person actualSibling = siblings.get(0);

        // assert
        assertEquals(actualSibling, sibling);
    }

    @Test
    void setSiblings() {
        // arrange
        Person olderSibling = new Person("Broer", "den Uijl", 'm', 31);
        Person youngerSibling = new Person("Zus", "den Uijl", 'f', 29);
        List<Person> siblings = new ArrayList<Person>();
        siblings.add(youngerSibling);
        siblings.add(olderSibling);

        // act
        me.setSiblings(siblings);
        List<Person> actualSiblings = me.getSiblings();

        // assert
        assertEquals(siblings, actualSiblings);
    }

    @Test
    void getChildren() {
        // arrange
        Person child = new Person("Kind", "den Uijl", 'm', 2);

        // act
        me.addChild(child);
        List<Person> children = me.getChildren();
        Person actualChild = children.get(0);

        // assert
        assertEquals(actualChild, child);
    }

    @Test
    void setChildren() {
        // arrange
        Person olderChild = new Person("Zoon", "den Uijl", 'm', 2);
        Person youngerChild = new Person("Dochter", "den Uijl", 'f', 1);
        List<Person> children = new ArrayList<Person>();
        children.add(youngerChild);
        children.add(olderChild);

        // act
        me.setChildren(children);
        List<Person> actualChildren = me.getChildren();

        // assert
        assertEquals(children, actualChildren);
    }

    @Test
    void getPets() {
        // arrange
        Pet dog = new Pet("Luna", 5, "Dog");

        // act
        me.addPet(dog);
        List<Pet> pets = me.getPets();

        // assert
        assertEquals(1, pets.size());
    }

    @Test
    void setPets() {
        // arrange
        Pet dog = new Pet("Luna", 5, "Dog");
        Pet cat = new Pet("Dexter", 15, "Cat");
        List<Pet> pets = new ArrayList<Pet>();
        pets.add(cat);
        pets.add(dog);

        // act
        me.setPets(pets);
        List<Pet> actualPets = me.getPets();

        // assert
        assertEquals(pets,actualPets);
    }

    @Test
    void addParents() {
        // arrange
        Person father = new Person("Vader", "den Uijl", 'm', 60);
        Person mother = new Person("Moeder", "den Uijl", 'f', 52);

        // act
        me.addParents(father, mother);
        Person actualFather = me.getFather();
        Person actualMother = me.getMother();
        
        // assert
        assertEquals(father, actualFather);
        assertEquals(mother, actualMother);
    }

    @Test
    void addChild() {
        // arrange
        Person child = new Person("Zoon", "den Uijl", 'm', 2);

        // act
        me.addChild(child);
        List<Person> children = me.getChildren();

        // assert
        assertEquals(1, children.size());
    }

    @Test
    void addPet() {
        // arrange
        Pet dog = new Pet("Luna", 5, "Dog");

        // act
        me.addPet(dog);
        List<Pet> pets = me.getPets();

        // assert
        assertEquals(1, pets.size());
    }

    @Test
    void addSibling() {
        // arrange
        Person brother = new Person("Broer", "den Uijl", 'm', 31);

        // act
        me.addSibling(brother);
        List<Person> siblings = me.getSiblings();

        // assert
        assertEquals(1, siblings.size());
    }

    @Test
    void getGrandChildren() {
        // arrange
        Person father = new Person("Vader", "den Uijl", 'm', 60);
        Person child = new Person("Zoon", "den Uijl", 'm', 2);

        // act
        me.setFather(father);
        me.addChild(child);
        List<Person> fathersGrandChildren = father.getGrandChildren();
        Person actualGrandChild = fathersGrandChildren.get(0);

        // assert
        assertEquals(child, actualGrandChild);
    }
}