import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private double salary;
    private String department;

    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Сотрудники - {" +
                "Имя: '" + name + '\'' +
                ", Возраст: " + age +
                ", Зарплата: " + salary +
                ", Наименование департамента: '" + department + '\'' +
                '}';
    }
}

class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return Double.compare(emp2.getSalary(), emp1.getSalary());
    }
}

class DepartmentComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getDepartment().compareTo(emp2.getDepartment());
    }
}

public class EmployeeSortingExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John Doe", 30, 5000.0, "Продажи"));
        employees.add(new Employee("Jane Smith", 25, 6000.0, "Маркетинг"));
        employees.add(new Employee("John Doe", 30, 5000.0, "Продажи"));
        employees.add(new Employee("Jane Smith", 25, 6000.0, "Маркетинг"));
        employees.add(new Employee("Alex Johnson", 35, 5500.0, "Финансы"));
        employees.add(new Employee("Emily Brown", 28, 5200.0, "HR"));
        employees.add(new Employee("Michael Davis", 32, 5800.0, "IT"));
        employees.add(new Employee("Olivia Wilson", 29, 5100.0, "Продажи"));
        employees.add(new Employee("William Taylor", 31, 5700.0, "Маркетинг"));
        employees.add(new Employee("Sophia Anderson", 27, 5300.0, "Финансы"));
        employees.add(new Employee("James Martinez", 33, 5900.0, "HR"));
        employees.add(new Employee("Ava Thomas", 26, 5400.0, "IT"));
        employees.add(new Employee("Daniel Garcia", 34, 5600.0, "Продажи"));
        employees.add(new Employee("Mia Lopez", 30, 5200.0, "Маркетинг"));
        employees.add(new Employee("Benjamin Lee", 29, 5800.0, "Финансы"));
        employees.add(new Employee("Charlotte Clark", 32, 5300.0, "HR"));
        employees.add(new Employee("Henry Lewis", 28, 5500.0, "IT"));
        employees.add(new Employee("Amelia Rodriguez", 31, 5100.0, "Продажи"));
        employees.add(new Employee("Ethan Hall", 27, 5900.0, "Маркетинг"));
        employees.add(new Employee("Lily Young", 33, 5400.0, "Финансы"));
        employees.add(new Employee("Alexander Hill", 26, 5700.0, "HR"));
        employees.add(new Employee("Sofia Adams", 34, 5600.0, "IT"));
        // Добавьте остальных сотрудников в список

        // Сортировка по возрастанию возраста (по умолчанию)
        Collections.sort(employees);
        System.out.println("Сортировка по возрастанию возраста:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Сортировка по убыванию зарплаты
        Collections.sort(employees, new SalaryComparator());
        System.out.println("\nСортировка по убыванию зарплаты:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Сортировка по наименованию отдела (в лексикографическом порядке)
        Collections.sort(employees, new DepartmentComparator());
        System.out.println("\nСортировка по наименованию отдела:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}