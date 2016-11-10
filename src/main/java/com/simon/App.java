package com.simon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class App {

    private static final String FILE_NAME = "d:/city_java/names.txt";
    private static final String URI_NAME = "https://raw.githubusercontent.com/javapapo/cs3577/master/week1/names.txt";

    public static void main(String[] args) {

        new App().readFile();

    }

    void readFile() {

        BufferedReader reader = null;
        ArrayList<Details> list = new ArrayList<>();
        String line = null;

        try {
            URL url = new URL(URI_NAME);
            URLConnection connection = url.openConnection();

            reader = new BufferedReader( new InputStreamReader( connection.getInputStream()));

            // read file locally
            //        try {
            //            reader = new BufferedReader(new FileReader(FILE_NAME));

            while ((line = reader.readLine()) != null) {

                if (line.trim().length() != 0 && !line.trim().substring(0,1).equals("#")) {
                    String[] det = line.split(",");
                    Details details = new Details();
                    details.setName(det[0].trim());
                    details.setSurname(det[1].trim());
                    details.setDob(det[2].trim());
                    details.setCountry(det[3].trim());
                    details.setCity(det[4].trim());
                    details.setGender(det[5].trim());

                    list.add(details);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stream<Details> sortByCountryStream = list.stream();

        sortByCountryStream.sorted(cmp).forEach(System.out::println);

        Stream<Details> ageStream = list.stream();

        ageStream.forEach( a::accept );

    }

    Comparator<Details> cmp = (s1, s2) -> { return s1.getCountry().isPresent() && s2.getCountry().isPresent() ?
            s1.getCountry().get().compareTo(s2.getCountry().get()) : -1; };

    AgeOutputter a = d -> { LocalDate now = LocalDate.now();
        Optional<LocalDate> dob = d.getDob();
        System.out.print(d.getName().get()+", "+
                d.getSurname().get()+", "+
                d.getDob()+", ");
        if (dob.isPresent())
            System.out.println(ChronoUnit.YEARS.between(dob.get(), now));
        else
            System.out.println("");};
}

