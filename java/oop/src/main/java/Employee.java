import java.util.Currency;

interface Timesheet{}
interface Invoice{}

interface Payable{
    void pay();
    class Implementation implements Payable {
        public void pay() {}
    }
}

class Money{ public Money(double value, Currency currency){}}

abstract class Worker {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    public void pay() {
        Money due = getAmountDue();
    }

    abstract protected Money getAmountDue();
}

class Employee extends Worker implements Payable {

    private Timesheet[] unpaidTimesheets;

    public Employee(String name) {
        super(name);
    }

    @Override
    protected Money getAmountDue() {
        return new Money(12.34, Currency.getInstance("USD"));
    }

    public void attachTimesheet(Timesheet timesheet) {}
}

class Contractor implements Payable {
    private Invoice[] invoicesDue;

    private Payable delegate = new Payable.Implementation();

    public Contractor(String name) {

    }

    public void attachInvoice(Invoice invoice){}

    @Override
    public void pay() {
        delegate.pay();
    }
}

class AccountsPaybable {
    private Payable[] creditors;

    AccountsPaybable(Payable[] creditors) {
        this.creditors = creditors;
    }

    public void PayEverybody() {
        for (Payable creditor : creditors) {
            creditor.pay();
        }
    }
}