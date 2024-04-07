package mattiaconsiglio.gestionePrenotazioni;

import lombok.extern.slf4j.Slf4j;
import mattiaconsiglio.gestionePrenotazioni.dao.ReservationsService;
import mattiaconsiglio.gestionePrenotazioni.dao.UsersService;
import mattiaconsiglio.gestionePrenotazioni.dao.WorkspacesService;
import mattiaconsiglio.gestionePrenotazioni.entities.Reservation;
import mattiaconsiglio.gestionePrenotazioni.entities.User;
import mattiaconsiglio.gestionePrenotazioni.entities.Workspace;
import mattiaconsiglio.gestionePrenotazioni.entities.WorkspaceType;
import mattiaconsiglio.gestionePrenotazioni.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

import static mattiaconsiglio.gestionePrenotazioni.Utilities.askAndVerifyEnum;
import static mattiaconsiglio.gestionePrenotazioni.Utilities.askAndVerifyString;

@SpringBootApplication
@Slf4j
public class GestionePrenotazioniApplication {


    private static Scanner scanner;

    private static WorkspacesService ws;

    private static Utilities utils;

    private static ReservationsService rs;
    private static UsersService us;


    @Autowired
    //initialize static fields with beans
    public GestionePrenotazioniApplication(Scanner scanner, Utilities utils, WorkspacesService ws, ReservationsService rs, UsersService us) {
        GestionePrenotazioniApplication.scanner = scanner;
        GestionePrenotazioniApplication.utils = utils;
        GestionePrenotazioniApplication.ws = ws;
        GestionePrenotazioniApplication.rs = rs;
        GestionePrenotazioniApplication.us = us;
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionePrenotazioniApplication.class, args);

        mainMenu();
    }

    public static void mainMenu() {

        while (true) {
            System.out.println("--------- Menu principale ---------");
            System.out.println();
            System.out.println("Scegli un'opzione");
            System.out.println("1. Search free workspaces by city");
            System.out.println("2. See your reservations");
            System.out.println("0. Exit");
            System.out.println();


            String option = scanner.nextLine().trim();

            switch (option) {
                case "0": {
                    System.out.println("Closing application...");
                    return;
                }
                case "1": {
                    String city = askAndVerifyString("Insert a city");
                    WorkspaceType type = askAndVerifyEnum("Choose a workspace type", WorkspaceType.class);
                    List<Workspace> workspaces = ws.getAllByBuildingCity(city, type);
                    if (workspaces.isEmpty()) {
                        System.err.println("No workspaces found");
                        break;
                    }
                    System.out.println("Workspaces found:");
                    workspaces.forEach(System.out::println);

                    break;
                }
                case "2": {
                    String emailOrUsername = askAndVerifyString("Insert your email/username");
                    try {
                        User user = us.getByUsernameOrEmail(emailOrUsername);
                        List<Reservation> reservations = rs.getAllByUser(user);
                        if (reservations.isEmpty()) {
                            System.err.println("No reservations found");
                            break;
                        }
                        System.out.println("Reservations found:");
                        reservations.forEach(System.out::println);
                    } catch (RecordNotFoundException e) {
                        log.error("User not found for email/username: {}", emailOrUsername);
                    }

                    break;
                }
                default:
                    System.err.println("Opzione non valida, scegliere un'opzione valida");
            }
        }
    }

}
