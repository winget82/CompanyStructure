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
            supportTeam.setBusinessLead(this);
            return true;
        } else {
            return false;
        }
    }

    public boolean requestBonus(Employee employee, double bonus) {
        //Should check if the bonus amount requested would fit in current BusinessLead's budget. If it is, that employee
        //should get that bonus, the BusinessLeader's budget should be deducted and true should be returned. False
        //should be returned otherwise
        if (bonus <= this.getBonusBudget()) {
            this.setBonusBudget(this.getBonusBudget() - bonus);
            approveBonus(employee, bonus);
            return true;
        } else {
            return false;
        }
    }

    public boolean approveBonus(Employee employee, double bonus) {
        //This function should look through the Accountants the BusinessLead manages, and if any of them are supporting
        //a TechnicalLead that is the manager of the Employee passed in then the Accountant's (CHANGED TO BUSINESS
        //LEAD'S - SEE COMMENT BELOW) budget should be consulted to see if the bonus could be afforded. If the team can
        //afford the bonus it should be rewarded and true returned, false otherwise
        boolean approved = false;

        for (int i = 0; i < this.directReports.size(); i++) {
            if (this.directReports.get(i).getTeamSupported().getName().equals(employee.getManager())) {

                /*THE ACCOUNTANT'S BUDGET SHOULD BE CONSULTED TO SEE IF THE BONUS CAN BE AFFORDED
                LOGICALLY THIS SEEMS WRONG. EVENTUALLY THIS WOULD CAUSE A PROBLEM WITH THE BUDGET?
                IT SEEMS LIKE THE BUSINESS LEADS BUDGET SHOULD BE CONSULTED SINCE THAT IS WHERE MONEY IS BEING DEDUCTED.
                OR THE MONEY SHOULD BE DEDUCTED FROM THE ACCOUNTANTS BONUS BUDGET INSTEAD OF THE BUSINESS LEAD'S.
                THAT OR THERE SHOULD BE A STATIC BONUS BUDGET THAT IS SHARED BY ALL BUSINESS EMPLOYEES.  I MUST BE
                MISUNDERSTANDING WHAT THEY ARE WANTING OR THERE IS A MISTYPE IN THEIR REQUIREMENTS...  I DECIDED TO
                PROCEED BY COMPARING IT TO THE BUSINESS LEAD'S BONUS BUDGET SINCE THAT IS WHERE IT IS BEING DEDUCTED
                FROM*/

                if (bonus <= this.getBonusBudget()) {
                    approved = true;
                } else {
                    approved = false;
                }

            } else {
                approved = false;
            }
        }

        return approved;
    }

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
