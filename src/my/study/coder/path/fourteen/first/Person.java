package my.study.coder.path.fourteen.first;

import java.util.StringJoiner;

public class Person {
    private String firstName;
    private String lastName;
    private String patronymic;
    private int age;
    private int weight;
    private WorkLevel workLevel;

    public Person(String firstName, String lastName, String patronymic, int age, int weight, int workLevel) {
        this.firstName = isCorrectString(firstName) ? firstName : null;
        this.lastName = isCorrectString(lastName) ? lastName : null;
        this.patronymic = isCorrectString(patronymic) ? patronymic : null;
        this.age = isCorrectNumber(age) ? age : 0;
        this.weight = isCorrectNumber(weight) ? weight : 0;
        this.workLevel = WorkLevel.valueOfLevel(workLevel);
    }

    public void setFirstName(String firstName) {
        this.firstName = isCorrectString(firstName) ? firstName : null;
    }

    public void setLastName(String lastName) {
        this.lastName = isCorrectString(lastName) ? lastName : null;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = isCorrectString(patronymic) ? patronymic : null;
    }

    public void setAge(int age) {
        this.age = isCorrectNumber(age) ? age : 0;
    }

    public void setWeight(int weight) {
        this.weight = isCorrectNumber(weight) ? weight : 0;
    }

    public void setWorkLevel(int level) {
        this.workLevel = WorkLevel.valueOfLevel(level);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("patronymic='" + patronymic + "'")
                .add("age=" + age)
                .add("weight=" + weight)
                .add("workLevel=" + workLevel)
                .toString();
    }

    private boolean isCorrectNumber(int number) {
        return number >= 30 && number <= 200;
    }

    private boolean isCorrectString(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}
