package pl.sda.poznan.builder;

import java.time.LocalDate;

public class PlayGround {
    public static void main(String[] args) {
//        Reservation reservation = new Reservation();
//        reservation.setCity("Poznan");
//        reservation.setHeadcount(199);
        Reservation.ReservationBuilder rb = Reservation.builder()
                .city("Poznań")
                .headcount(100)
                .price(99d);

        //odczyt z pliku
        rb.date(LocalDate.parse("2018-03-03"));
        //zakończ proces budowania  - zwróć gotowy obiekt
        Reservation build = rb.build();
        System.out.println(build);

        //inny scenariusz - znam wszustkie wartości od razu

        Reservation wroclaw = Reservation.builder()
                .date(LocalDate.parse("2018-03-03"))
                .headcount(100)
                .city("Wroclaw")
                .build();
    }
}
