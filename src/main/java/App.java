import Services.*;


public class App {
    public static void main (String[] args) {
        System.out.println("VainitORM up and running...\n\n");

        DepartmentService dpmntService = new DepartmentService();
        DepartmentResponseService dpmntResult = dpmntService.create("IT");
        dpmntResult.print();
    }
}
