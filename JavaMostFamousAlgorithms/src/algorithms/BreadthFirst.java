package algorithms;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirst {

    static class Employee {
        private String name;
        private List<Employee> employeesList = new ArrayList<>();

        public Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public List<Employee> getEmployees() {
            return employeesList;
        }

        public void isEmployeeOf(Employee e) {
            employeesList.add(e);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class DepthFirstAlgorithm {

        public Employee buildEmployeeGraph() {
            Employee Eva = new Employee("Eva");
            Employee Sophia = new Employee("Sophia");
            Employee Brian = new Employee("Brian");
            Eva.isEmployeeOf(Sophia);
            Eva.isEmployeeOf(Brian);

            Employee Lisa = new Employee("Lisa");
            Employee Tina = new Employee("Tina");
            Employee John = new Employee("John");
            Employee Mike = new Employee("Mike");
            Sophia.isEmployeeOf(Lisa);
            Sophia.isEmployeeOf(John);
            Brian.isEmployeeOf(Tina);
            Brian.isEmployeeOf(Mike);

            return Eva;
        }

        public Employee search(Employee root, String nameToSearchFor) {
            if (nameToSearchFor.equals(root.getName())) {
                return root;
            }

            Employee personFound = null;
            for (Employee employee : root.getEmployees()) {
                personFound = search(employee, nameToSearchFor);
                if (personFound != null) {
                    break;
                }
            }
            return personFound;
        }

        public void traverse(Employee root) {
            System.out.println(root.getName());
            for (Employee employee : root.getEmployees()) {
                traverse(employee);
            }
        }
    }

    public static void main(String[] args) {
        DepthFirstAlgorithm b = new DepthFirstAlgorithm();
        Employee root = b.buildEmployeeGraph();
        System.out.println("Traverse Graph\n------");
        b.traverse(root);

        System.out.println("\nSearch in Graph\n------");
        Employee e = b.search(root, "Eva");
        System.out.println(e == null ? "Employee not found" : e.getName());
        e = b.search(root, "Brian");
        System.out.println(e == null ? "Employee not found" : e.getName());
        e = b.search(root, "Soni");
        System.out.println(e == null ? "Employee not found" : e.getName());
    }
}
