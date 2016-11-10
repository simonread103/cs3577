package com.simon;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by Simon on 08/11/2016.
 */
public class Details {
    String name;
    String surname;
    LocalDate dob;
    String country;
    String city;
    String gender;

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getSurname() {
        return Optional.ofNullable(surname);
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Optional<LocalDate> getDob() {
        return Optional.ofNullable(dob);
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setDob(String dob) {
//System.out.println(dob+","+dob.substring(6, 10)+","+dob.substring(3, 4)+","+dob.substring(0, 2));
        String[] s = dob.split("/");
        if (dob != null) {
            try {
                Integer year = Integer.parseInt(s[2].substring(0, 4));
                Integer month = s[1].length() == 2 ? Integer.parseInt(s[1].substring(0,2)) :
                        Integer.parseInt(s[1].substring(0,1));
                Integer day = s[0].length() == 2 ? Integer.parseInt(s[0].substring(0,2)) :
                        Integer.parseInt(s[0].substring(0,1));
                this.dob = LocalDate.of(year,
                        month,
                        day);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

    }

    public Optional<String> getCountry() {
        return Optional.ofNullable(country);
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Optional<String> getCity() {
        return Optional.ofNullable(city);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Optional<String> getGender() {
        return Optional.ofNullable(gender);
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Details{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dob=" + dob +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
