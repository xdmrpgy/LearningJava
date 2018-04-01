public class CloneTest {
    public static void main(String[] args) {
        try{
            Employee original = new Employee("John Q. Public",50000);
            original.setHireDay(2018,4,1);
            Employee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2018,4,2);
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
