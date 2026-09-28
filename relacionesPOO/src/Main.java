import aggregation.Department;
import aggregation.Institute;
import aggregation.Student;
import association.Bank;
import association.Employee;
import composition.House;
import composition.Room;


void associationExample() {
    // Creating Employee objects
    Employee emp1 = new Employee("Ridhi");
    Employee emp2 = new Employee("Vijay");

    // adding the employees to a set
    Set<Employee> employees = new HashSet<>();
    employees.add(emp1);
    employees.add(emp2);

    // Creating a Bank object
    Bank bank = new Bank("ICICI");

    // setting the employees for the Bank object
    bank.setEmployees(employees);

    // traversing and displaying the bank employees
    for (Employee emp : bank.getEmployees()) {
        IO.println(emp.getEmployeeName()
                + " belongs to bank "
                + bank.getBankName());
    }
}

void aggregationExample() {
    // Creating independent Student objects
    Student s1 = new Student("Parul", 1);
    Student s2 = new Student("Sachin", 2);
    Student s3 = new Student("Priya", 1);
    Student s4 = new Student("Rahul", 2);

    // Creating an list of CSE Students
    List<Student> cse_students = new ArrayList<Student>();
    cse_students.add(s1);
    cse_students.add(s2);

    // Creating an initial list of EE Students
    List<Student> ee_students = new ArrayList<Student>();
    ee_students.add(s3);
    ee_students.add(s4);

    // Creating Department object with a Students list
    // using Aggregation (Department "has" students)
    Department CSE = new Department("CSE", cse_students);
    Department EE = new Department("EE", ee_students);

    // Creating an initial list of Departments
    List<Department> departments = new ArrayList<Department>();
    departments.add(CSE);
    departments.add(EE);

    // Creating an Institute object with Departments list
    // using Aggregation (Institute "has" Departments)
    Institute institute = new Institute("BITS", departments);

    // Display message for better readability
    IO.print("Total students in institute: ");

    // Calling method to get total number of students
    // in the institute and printing on console
    IO.print(
            institute.getTotalStudentsInInstitute());
}

void compositionExample() {
    House house = new House("Dream House");

    house.addRoom(new Room("Living Room"));
    house.addRoom(new Room("Bedroom"));
    house.addRoom(new Room("Kitchen"));
    house.addRoom(new Room("Bathroom"));

    int r = house.getTotalRooms();
    IO.println("Total Rooms: " + r);

    IO.println("Room names: ");
    for (Room room : house.getRooms()) {
        IO.println("- " + room.getRoomName());
    }
}

void menu() {
    IO.println("\n====RELACIONES POO====");
    IO.println("1) Asociación");
    IO.println("2) Agregación");
    IO.println("3) Composición");
    IO.println("4) Salir");
    IO.print("opcion: ");

}


void main() {
    Scanner in = new Scanner(System.in);
    int opcion;

    do {

        menu();

        opcion = in.nextInt();

        switch (opcion) {
            case 1:
                associationExample();
                break;
            case 2:
                aggregationExample();
                break;
            case 3:
                compositionExample();
                break;
            default:
        }
    } while (opcion != 4);
}


