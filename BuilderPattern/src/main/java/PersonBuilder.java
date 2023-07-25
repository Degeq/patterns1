public class PersonBuilder implements PersonBuilderInterface {

    private String name;
    private String surename;
    private int age = -1;
    private String address;

    public PersonBuilder() {

    };

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Вы указали невалидный возраст <0");
        } else {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurename(String surename) {
        this.surename = surename;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surename == null) {
            throw new IllegalStateException("Вы не указали Фамилию или Имя");
        } else {
            return new Person(name, surename, age, address);
        }
    }
}
