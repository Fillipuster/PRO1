package gui;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import model.Arrangement;
import model.Tutor;
import service.Service;

public class MainApp {

    public static <T> void printArrayList(ArrayList<T> arl) {
        for (T t : arl) {
            System.out.print(t.toString());
            if (t != arl.get(arl.size() - 1)) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Service.initStorage();

        System.out.println("Hold Uden Tutorer:");
        printArrayList(Service.holdUdenTutorer());
        System.out.println();

        System.out.println("Tutor Oversigt:");
        printArrayList(Service.getUddannelses().get(0).tutorOversigt());
        System.out.println();

        System.out.println("Tutor oversigt fil oprettelse...");
        Service.tutorOversigtTilFil("tutoroversigt_test.txt");
        System.out.println("Oprettet." + "\n");

        Arrangement a0 = Service.createArrangement("A1", LocalDate.now(), LocalTime.of(10, 00), LocalTime.of(15, 00),
                100);
        Arrangement a1 = Service.createArrangement("A2", LocalDate.now(), LocalTime.of(9, 00), LocalTime.of(16, 00),
                100);

        Tutor t = Service.createTutor("Jonas", "mail");

        Service.linkTutorArrangement(t, a0);
        Service.linkTutorArrangement(t, a1);

        System.out.println(t.getArrangements());
    }

}
