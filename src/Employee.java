public abstract class Employee {
    //FIELDS
    private String name;
    private double baseSalary;
    private static int IDcount = 1;
    private int employeeID = 0;

    //CONSTRUCTOR
    public Employee(String name, double baseSalary) {
        //Should construct a new employee object and take in two parameters, one for the name of the user and one for
        //their base salary
        this.name = name;
        this.baseSalary = baseSalary;
        this.employeeID = IDcount++;
    }

    //BEHAVIORS
    public double getBaseSalary() {//GETTER
        //Should return the employee's current salary
        return baseSalary;
    }

    public void setBaseSalary(double x) {//SETTER
        this.baseSalary = x;
    }

    public String getName() {
        //Should return the employee's current name
        return name;
    }

    public int getEmployeeID() {
        //Should return the employee's ID. The ID should be issued on behalf of the employee at the time they are
        //constructed. The first ever employee should have an ID of "1", the second "2" and so on
        return employeeID;
    }
/*
    public Employee getManager() {
        //Should return a reference to the Employee object that represents this employee's manager
        //Business Lead is Manager of Accountant & Technical Lead is Manager of Software Engineer

    }
*/
    public boolean equals(Employee other) {
        //Should return true if the two employee IDs are the same, false otherwise
        if (this.employeeID == other.employeeID) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        //Should return a String representation of the employee that is a combination of their id followed by their
        //name. Example: "1 Kasey"
        return employeeID + " " + name;
    }
/*
    abstract String employeeStatus();
        //Should return a String representation of that Employee's current status. This will be different for every
        //subclass of Employee
*/
}
