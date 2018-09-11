package application.service;

import java.util.ArrayList;

import application.model.Company;
import application.model.Customer;
import application.model.Employee;
import storage.Storage;

public class Service {
    /**
     * Creates a new Company.<br />
     * Requires: hours >= 0.
     */
    public static Company createCompany(String name, int hours) {
        Company company = new Company(name, hours);
        Storage.addCompany(company);
        return company;
    }

    /**
     * Deletes the company.<br />
     * Requires: The company has no employees.
     */
    public static void deleteCompany(Company company) {
        Storage.removeCompany(company);
    }

    /**
     * Updates the company.<br />
     * Requires: hours >= 0.
     */
    public static void updateCompany(Company company, String name, int hours) {
        company.setName(name);
        company.setHours(hours);
    }

    /**
     * Get all the companies
     */
    public static ArrayList<Company> getCompanies() {
        return Storage.getCompanies();
    }

    // -------------------------------------------------------------------------

    /**
     * Creates a new employee.<br />
     * Requires: wage >= 0.
     */
    public static Employee createEmployee(String name, int wage, int employmentYear) {
        Employee employee = new Employee(name, wage, employmentYear);
        Storage.addEmployee(employee);
        return employee;
    }

    /**
     * Creates a new employee.<br />
     * Requires: wage >= 0, company!=null.
     */
    public static Employee createEmployee(String name, int wage, Company company, int employmentYear) {
        Employee employee = new Employee(name, wage, employmentYear);
        company.addEmployee(employee);
        employee.setCompany(company);
        Storage.addEmployee(employee);
        return employee;
    }

    /**
     * Deletes the employee.
     */
    public static void deleteEmployee(Employee employee) {
        Company company = employee.getCompany();
        if (company != null) {
            company.removeEmployee(employee);
            employee.clearCompany();
        }
        Storage.removeEmployee(employee);
    }

    /**
     * Updates the employee.<br />
     * Requires: wage >= 0.
     */
    public static void updateEmployee(Employee employee, String name, int wage, int employmentYear) {
        employee.setName(name);
        employee.setWage(wage);
        employee.setEmploymentYear(employmentYear);
    }

    /**
     * Get all the employees.
     */
    public static ArrayList<Employee> getEmployees() {
        return Storage.getEmployees();
    }

    // -------------------------------------------------------------------------

    /**
     * Updates the employee's company.
     */
    public static void updateCompanyOfEmployee(Employee employee, Company company) {
        Company current = employee.getCompany();
        if (current != null) {
            current.removeEmployee(employee);
            employee.clearCompany();
        }
        employee.setCompany(company);
        company.addEmployee(employee);
    }

    /**
     * Clears the company of the employee.
     */
    public static void clearCompanyOfEmployee(Employee employee) {
        Company company = employee.getCompany();
        if (company != null) {
            company.removeEmployee(employee);
            employee.clearCompany();
        }
    }

    // -------------------------------------------------------------------------

    public static Customer createCustomer(String name, int age) {
        Customer customer = new Customer(name, age);
        Storage.addCustomer(customer);
        return customer;
    }

    public static void removeCustomer(Customer customer) {
        Storage.removeCustomer(customer);
    }

    public static void updateCustomer(Customer customer, String name, int age) {
        customer.setName(name);
        customer.setAge(age);
    }

    public static ArrayList<Customer> getCustomers() {
        return Storage.getCustomers();
    }

    public static void connectCustomerToCompany(Customer customer, Company company) {
        company.addCustomer(customer);
    }

    public static void removeCustomerFromCompany(Customer customer, Company company) {
        company.removeCustomer(customer);
    }

    // -------------------------------------------------------------------------

    /**
     * Initializes the storage with some objects.
     */
    public static void initStorage() {
        Company comp1 = Service.createCompany("IBM", 37);
        Company comp2 = Service.createCompany("AMD", 40);
        Service.createCompany("SLED", 45);
        Service.createCompany("Vector", 32);

        Service.createEmployee("Bob Dole", 210, comp2, 2001);
        Service.createEmployee("Alice Schmidt", 250, comp1, 1997);
        Service.createEmployee("George Down", 150, 2004);
        Service.createEmployee("Rita Uphill", 300, 2001);

        Service.connectCustomerToCompany(Service.createCustomer("John Don", 41), comp1);
        Service.connectCustomerToCompany(Service.createCustomer("Michael Pike", 24), comp2);
        Service.connectCustomerToCompany(Service.createCustomer("Pichael Mike", 23), comp2);
        Service.createCustomer("Steven Michaels", 66);
    }

}
