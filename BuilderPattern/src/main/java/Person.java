import java.util.Objects;

public class Person {

    private String name;
    private String surename;
    private int age;
    private String address;

    public Person(String name, String surename, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.surename = surename;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        } else {
            throw new IllegalStateException("Вы не указали возраст");
        }
    }

    public boolean hasAge() {
        if (age != -1) {
            return true;
        }
        return false;
    }

    public boolean hasAddress() {
        if (address == null) {
            return false;
        }

        return true;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        if (hasAge()) {
            return age;
        }
        throw new IllegalStateException("Возраст не указан");
    }

    public String getAddress() {
        if (hasAddress()) {
            return address;
        }
        throw new IllegalStateException("Адрес не указан");
    }

    public String getSurename() {
        return surename;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setSurename(this.surename);
        childBuilder.setAddress(this.address);
        return childBuilder;
    }

    @Override
    public String toString() {

        return "{" +
                "name= " + name + '\n' +
                "surename= " + surename + '\n' +
                "age= " + (hasAge() ? age : "Возраст не указан") + '\n' +
                "address= " + (hasAddress() ? address : "Адрес не указан") + '\n' +
                                       '}' + '\n';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surename, age, address);
    }
}
