import Services.*;

import java.util.List;


public class App {
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

            String selection = System.console().readLine();

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

            String selection = System.console().readLine();

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
        System.out.println("\tInsert the department identificator:\n");
        String identificator = System.console().readLine();
        List<DepartmentResponseService> dpmntResponse = dpmntService.getAll();
        dpmntResponse.forEach(DepartmentResponseService::print);
    }

    public static void createDepartmentEvent(DepartmentService dpmntService){
        String dpmnt = System.console().readLine();
        DepartmentResponseService dpmntResult = dpmntService.create(dpmnt);
        dpmntResult.print();
    }
}
