package nl.novi;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    }

    @Test
    void setSiblings() {
    }

    @Test
    void getChildren() {
    }

    @Test
    void setChildren() {
    }

    @Test
    void getPets() {
    }

    @Test
    void setPets() {
    }

    @Test
    void addParents() {
    }

    @Test
    void addChild() {
    }

    @Test
    void addPet() {
    }

    @Test
    void addSibling() {
    }

    @Test
    void getGrandChildren() {
    }
}