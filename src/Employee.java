public class Employee {

    public Employee(String name, double baseSalary) {
        //Should construct a new employee object and take in two parameters, one for the name of the user and one for
        //their base salary
    }

    public double getBaseSalary() {
        //Should return the employee's current salary
    }

    public String getName() {
        //Should return the employee's current name
    }

    public int getEmployeeID() {
        //Should return the employee's ID. The ID should be issued on behalf of the employee at the time they are
        //constructed. The first ever employee should have an ID of "1", the second "2" and so on
    }

    public Employee getManager() {
        //Should return a reference to the Employee object that represents this employee's manager
    }

    public boolean equals(Employee other) {
        //Should return true if the two employee IDs are the same, false otherwise
    }

    public String toString() {
        //Should return a String representation of the employee that is a combination of their id followed by their
        //name. Example: "1 Kasey"
    }

    public String employeeStatus(){
        //Should return a String representation of that Employee's current status. This will be different for every
        //subclass of Employee
    }
}
