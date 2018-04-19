import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Employee implements Cloneable{
    private String name;
    private double salary;
    private Date hireDay = new Date();
    private LocalDate birthDay;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, double salary,int year,int month,int day) {
        this.name = name;
        this.salary = salary;
        this.birthDay = LocalDate.of(year,month,day);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHireDay(int year, int month, int day){
        Date newHireDay = new GregorianCalendar(year,month-1,day).getTime();
        hireDay.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object otherObject){
        if(this == otherObject) return true;
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass()) return false;
        Employee other = (Employee) otherObject;
        return Objects.equals(name,other.name) && salary == other.salary
                && Objects.equals(hireDay,other.hireDay) && Objects.equals(birthDay,other.birthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,salary,hireDay,birthDay);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                ", birthDay=" + birthDay +
                '}';
    }

    @Override
    public Employee clone() throws CloneNotSupportedException{
        //call Object.clone()
        Employee clone = (Employee) super.clone();

        //clone mutable fields
        clone.hireDay = (Date) hireDay.clone();
        return clone;
    }

    public Employee shadowClone() throws CloneNotSupportedException {
        return (Employee) super.clone();
    }
}
