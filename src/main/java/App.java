import Persistence.DepartmentResponse;
import Services.*;

import java.util.List;
import java.util.Scanner;


public class App {
    public static Scanner inputScaner = new Scanner(System.in);

    public static void main (String[] args) {

        StorageService storageService = new StorageService();

        System.out.println("VainitORM up and running...\n\n");

        while(true){
            System.out.println(
                    "Choose an area:\n" +
                            "\td) Deparments.\n" +
                            "\te) Employees.\n" +
                            "\tq) Quit.\n\n"
            );

            String selection = inputScaner.nextLine();

            if (selection.equals("d")) {
                promptDepartment(storageService);
            } else {
                System.out.println("\n\nQuitting the program. Bye...");
                break;
            }

        }

    }

    public static void promptDepartment(StorageService storageService){

        DepartmentService departmentService = new DepartmentService(storageService);
        while(true){
            System.out.println(
                    "\tDeparments\n" +
                            "\t\tr) Read.\n" +
                            "\t\tc) Create.\n" +
                            "\t\tb) Back.\n\n"
            );


            String selection = inputScaner.nextLine();

            if(selection.equals("r"))
                readDepartmentEvent(departmentService);
            if (selection.equals("c"))
                createDepartmentEvent(departmentService);
            else {
                System.out.println("\n\nPrevious...");
                break;
            }

        }

    }

    public static void readDepartmentEvent(DepartmentService dpmntService){
        System.out.println("\nInsert the department identificator:");
        String identificator = inputScaner.nextLine();
        var dpmntResponse = dpmntService.getAll();
        dpmntResponse.forEach(DepartmentResponseService::print);
    }

    public static void createDepartmentEvent(DepartmentService dpmntService){
        System.out.println("\nInsert the deparment Name:");
        String dpmnt = inputScaner.nextLine();
        DepartmentResponseService dpmntResult = dpmntService.create(dpmnt);
        dpmntResult.print();
    }
}
