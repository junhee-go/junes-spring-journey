package beans;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name = "Lucy";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Parrot: " + name;
    }
}