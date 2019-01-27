import java.util.*;

public class BusinessLead extends BusinessEmployee {

    //FIELDS
    private int headCount;
    private Accountant acct;
    private ArrayList <Accountant> directReports;

    //CONSTRUCTOR
    public BusinessLead(String name) {
        //Should create a new BusinessLead that is a Manager. The BusinessLead's base salary should be twice that of an
        //Accountant. They should start with a head count of 10.
        super(name);
        this.setBaseSalary(this.getBaseSalary() * 2);
        this.directReports = new ArrayList<>();
        this.headCount = 10;
    }

    //BEHAVIORS
    public boolean hasHeadCount() {
        //Should return true if the number of direct reports this manager has is less than their headcount.
        if (this.directReports.size() < headCount) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        //Should accept the reference to an Accountant object, and if the BusinessLead has head count left should add
        //this employee to their list of direct reports. If the employee is successfully added to the BusinessLead's
        //direct reports true should be returned, false should be returned otherwise. Each time a report is added the
        //BusinessLead's bonus budget should be increased by 1.1 times that new employee's base salary. That employee's
        //team they are supporting should be updated to reflect the reference to the TechnicalLead given. If the
        //employee is successfully added true should be returned, false otherwise.
        this.acct = e;
        if (this.hasHeadCount()) {
            this.directReports.add(e);
            e.setManager(this);
            double newBudget = this.getBonusBudget() + (1.1 * e.getBaseSalary());
            this.setBonusBudget(newBudget);
            e.supportTeam(supportTeam);
            return true;
        } else {
            return false;
        }

    }
/*
    public boolean requestBonus(Employee, double bonus) {
        //Should check if the bonus amount requested would fit in current BusinessLead's budget. If it is, that employee
        //should get that bonus, the BusinessLeader's budget should be deducted and true should be returned. False
        //should be returned otherwise
    }

    public boolean approveBonus(Employee, double bonus) {
        //This function should look through the Accountants the BusinessLead manages, and if any of them are supporting
        //a the TechnicalLead that is the manager of the Employee passed in then the Accountant's budget should be
        //consulted to see if the bonus could be afforded. If the team can afford the bonus it should be rewarded and
        //true returned, false otherwise
    }
*/
    public String getTeamStatus() {
        if (this.directReports.size() == 0) {
            return this.employeeStatus() + "and no direct reports yet.";
        } else {
            String teamStatus[] = new String[directReports.size()];
            for (int i = 0; i < this.directReports.size(); i++) {
                teamStatus[i] = this.directReports.get(i).employeeStatus() + "\n";
            }
            String finished = "";
            for (int i = 0; i < teamStatus.length; i++) {
                finished += teamStatus[i];
            }

            String x =  this.employeeStatus() + " and is managing: \n" + Arrays.toString(teamStatus);
            x = x.replace("[", "");
            x = x.replace("]","");
            x = x.replace(",","");
            String finalString = x.trim();
            return finalString;
        }
    }

    public String employeeStatus() {
        //Should return a String representation of this BusinessEmployee that includes their ID, name and the size of
        //their currently managed budget. Example: "1 Kasey with a budget of 22500.0"
        return this.toString() + " with a budget of " + this.getBonusBudget();
    }

}
