package nl.novi;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    String middleName;
    String lastName;
    char sex;
    int age;
    Person mother;
    Person father;
    List<Person> siblings;
    List<Person> children;
    List<Pet> pets;
    List grandChildrensPets;
    Person partner;

    public Person(String name, String middleName, String lastName, char sex, int age) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
        this.siblings = new ArrayList<Person>();
        this.children = new ArrayList<Person>();
        this.pets = new ArrayList<Pet>();
        this.grandChildrensPets = new ArrayList<Pet>();
    }

    public Person(String name, String lastName, char sex, int age) {
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
        this.siblings = new ArrayList<Person>();
        this.children = new ArrayList<Person>();
        this.pets = new ArrayList<Pet>();
    }

    // Getters and Setters:
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;

        this.mother.addChild(this);
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;

        this.father.addChild(this);
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;

        for (Person child: this.children) {
            List<Person> otherChildren = new ArrayList<Person>(this.children);
            otherChildren.remove(child);

            child.setSiblings(otherChildren);
        }
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    // Methods:
    public void addParents(Person father, Person mother) {
        setFather(father);
        setMother(mother);

        this.father.addChild(this);
        this.mother.addChild(this);
    }

    public void addChild(Person newChild) {
        children.add(newChild);

        for (Person child : this.children) {
            List<Person> otherChildren = new ArrayList<Person>(this.children);
            otherChildren.remove(child);

            child.setSiblings(otherChildren);
        }
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public void addSibling(Person newSibling) {
        siblings.add(newSibling);
    }

    public List<Person> getGrandChildren() {
        List<Person> grandChildren = new ArrayList<Person>();

        for (Person child : children) {
            List<Person> grandChildList = child.getChildren();

            grandChildren.addAll(grandChildList);
        }

        return grandChildren;
    }

    public List<Pet> getGrandChildrensPets() {
        List<Person> grandChildren = getGrandChildren();
        List<Pet> grandChildrensPets = new ArrayList<Pet>();

        if (grandChildren.size() == 0) {
            return grandChildrensPets;
        }

        for (Person grandChild: grandChildren) {
            List<Pet> grandChildsPets = grandChild.getPets();
            grandChildrensPets.addAll(grandChildsPets);
        }

        return grandChildrensPets;
    }

    public List<Person> getAllNieces() {
        List<Person> nieces = new ArrayList<Person>();
        List<Person> siblings = getSiblings();

        for (Person sibling: siblings) {
            List<Person> siblingsChildren = sibling.getChildren();

            for (Person siblingsChild: siblingsChildren) {
                if (siblingsChild.sex == 'f') {
                    nieces.add(siblingsChild);
                }
            }
        }

        return nieces;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;

        this.partner.setChildren(this.children);
        this.partner.setPets(this.pets);
    }
}
