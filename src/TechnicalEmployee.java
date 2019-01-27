public abstract class TechnicalEmployee extends Employee {

    //FIELDS
    private int codeCheckIns;

    //CONSTRUCTOR
    public TechnicalEmployee(String name) {
        //Has a default base salary of 75000
        super(name, 75000);
        this.codeCheckIns = codeCheckIns;
    }

    //BEHAVIORS
    public String employeeStatus() {
        //Should return a String representation of this TechnicalEmployee that includes their ID, name and how many
        //successful check ins they have had. Example: "1 Kasey has 10 successful check ins"
        return this.toString() + " has " + this.codeCheckIns + " successful check ins";
    }
}
