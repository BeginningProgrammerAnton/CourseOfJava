package com.my_company;

import java.util.Objects;

public class Authors {
    String name = "Ant";
    String email = "Pol";
    char gender = 'm';

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Authors)) return false;
        Authors authors = (Authors) o;

        return this.name.equals(authors.name) && this.email.equals(authors.email) && this.gender == authors.gender;
    }

    @Override
    public int hashCode() {
        int result = 17;

        result = 31 * result + name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (int)gender;

        return result;
    }
}
