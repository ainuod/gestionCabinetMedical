package main.controller;

import java.util.Scanner;
//import main.controller.MedicalManagementController;

public class MedicalManagement {
    private static MedicalManagementController controller;
    private static Scanner scanner = new Scanner(System.in);

    private static String selectLanguage() {
        System.out.println("1. English");
        System.out.println("2. Français");
        System.out.print("Select language: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        return choice == 2 ? "FR" : "EN";
    }

    public static void main(String[] args) {
        String language = selectLanguage();
        controller = new MedicalManagementController(language);

        while (true) {
            if (language.equals("FR")) {
                System.out.println("\nSystème de Gestion Médicale");
                System.out.println("1. Ajouter un patient");
                System.out.println("2. Planifier un rendez-vous");
                System.out.println("3. Voir les rendez-vous");
                System.out.println("4. Ajouter une consultation");
                System.out.println("5. Voir le dossier médical");
                System.out.println("6. Quitter");
                System.out.print("Choisissez une option : ");
            } else {
                System.out.println("\nMedical Management System");
                System.out.println("1. Add Patient");
                System.out.println("2. Schedule Appointment");
                System.out.println("3. View Appointments");
                System.out.println("4. Add Consultation");
                System.out.println("5. View Medical Record");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
            }

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> controller.addPatient();
                    case 2 -> controller.createAppointment();
                    case 3 -> controller.viewAppointments();
                    case 4 -> controller.completeAppointment();
                    case 5 -> controller.viewMedicalRecord();
                    case 6 -> {
                        if (language.equals("FR")) {
                            System.out.println("Au revoir :)");
                        } else {
                            System.out.println("Goodbye :)");
                        }
                        return;
                    }
                    default -> {
                        if (language.equals("FR")) {
                            System.out.println("Option invalide. Veuillez réessayer.");
                        } else {
                            System.out.println("Invalid option. Please try again.");
                        }
                    }
                }
            } catch (Exception e) {
                if (language.equals("FR")) {
                    System.out.println("Entrée invalide. Veuillez saisir un numéro valide.");
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
                scanner.nextLine();
            }
        }
    }
}
