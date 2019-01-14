public class SoftwareEngineer extends TechnicalEmployee {

    //FIELDS
    private boolean codeAccess;
    private int codeCheckIns;

    //CONSTRUCTOR
    public SoftwareEngineer(String name) {
        //Should start without access to code and with 0 code check ins
        super(name);
        this.codeAccess = false;
        this.codeCheckIns = 0;
    }

    //BEHAVIORS
    public boolean getCodeAccess() {//GETTER
        //Should return whether or not this SoftwareEngineer has access to make changes to the code base
        return codeAccess;
    }
/*
    public void setCodeAcess(boolean access) {//SETTER
        //Should allow an external piece of code to update the SoftwareEngineer's code privileges to either true or false

    }
*/
    public int getSuccessfulCheckins() {
        //Should return the current count of how many times this SoftwareEngineer has successfully checked in code
        return codeCheckIns;
    }
/*
    public boolean checkInCode() {
        //Should check if this SoftwareEngineer's manager approves of their check in. If the check in is approved their
        //successful checkin count should be increased and the method should return "true". If the manager does not
        //approve the check in the SoftwareEngineer's code access should be changed to false and the method should
        //return "false"
    }
*/
}
