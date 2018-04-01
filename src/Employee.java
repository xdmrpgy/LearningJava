import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable{
    private String name;
    private double salary;
    private Date hireDay = new Date();

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee clone() throws CloneNotSupportedException{
        //call Object.clone()
        Employee clone = (Employee) super.clone();

        //clone mutable fields
        clone.hireDay = (Date) hireDay.clone();
        return clone;
    }

    public void setHireDay(int year,int month,int day){
        Date newHireDay = new GregorianCalendar(year,month-1,day).getTime();
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }
}
