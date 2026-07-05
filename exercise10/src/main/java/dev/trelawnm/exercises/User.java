package dev.trelawnm.exercises;

public final class User {
    private final String name;
    private final Integer age;

    public User(String startName, String startAge) {
        if (startName == null || startName.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        Integer validatedAge;

        try {
            validatedAge = Integer.parseInt(startAge);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Could not parse a number. Please try again");
        }

        if (validatedAge <= 0) {
            throw new IllegalArgumentException("Incorrect input. Age <= 0");
        }

        this.name = startName;
        this.age = validatedAge;
    }


    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}