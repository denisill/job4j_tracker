package ru.job4j.stream;

public class Engineer {
    private String name;
    private String surname;
    private byte age;
    private String education;
    private String degree;
    private String gender;

    static class Builder {
        private String name;
        private String surname;
        private byte age;
        private String education;
        private String degree;
        private String gender;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildEducation(String education) {
            this.education = education;
            return this;
        }

        Builder buildDegree(String degree) {
            this.degree = degree;
            return this;
        }

        Builder buildGender(String gender) {
            this.gender = gender;
            return this;
        }

        Engineer build() {
            Engineer engineer = new Engineer();
            engineer.name = name;
            engineer.surname = surname;
            engineer.age = age;
            engineer.education = education;
            engineer.degree = degree;
            engineer.gender = gender;
            return engineer;
        }
    }

    public static void main(String[] args) {
        Engineer engineer = new Builder().buildName("Bob")
                .buildSurname("Petrov")
                .buildAge((byte) 35)
                .buildEducation("Higher")
                .buildDegree("Master")
                .buildGender("Man")
                .build();
        System.out.println(engineer);
    }

    @Override
    public String toString() {
        return "Engineer{" + "name='"
                + name + '\''
                + ", surname='" + surname + '\''
                + ", age=" + age + ", education='"
                + education + '\''
                + ", degree='" + degree + '\''
                + ", gender='" + gender + '\'' + '}';
    }
}
