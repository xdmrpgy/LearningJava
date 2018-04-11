/**
 * @description:
 * @author:panguangyi
 * @date: 2018-4-11
 */
public class PairTest3 {
    public static void main(String[] args) {
        Manager ceo = new Manager("Roy",60000,1991,12,30);
        Manager cfo = new Manager("Mike",40000,1990,10,1);
        Pair<Manager> buddies = new Pair<>(ceo,cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);
        Manager[] managers = {ceo,cfo};

        Pair<Employee> result = new Pair<>();
        minmaxBonus(managers,result);
        System.out.println("first:" + result.getFirst().getName() + " second:" + result.getSecond().getName());
        maxminBonus(managers,result);
        System.out.println("first:" + result.getFirst().getName() + " second:" + result.getSecond().getName());
    }

    private static void printBuddies(Pair<Manager> buddies) {
        Employee first = buddies.getFirst();
        Employee second = buddies.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    private static void minmaxBonus(Manager[] managers, Pair<Employee> result) {
        if(managers.length == 0) return;
        Manager min = managers[0];
        Manager max = managers[0];
        for (int i = 0; i < managers.length; i++) {
            if(min.getBonus() > managers[i].getBonus()) min = managers[i];
            if(max.getBonus() < managers[i].getBonus()) max = managers[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    private static void maxminBonus(Manager[] managers, Pair<Employee> result) {
        minmaxBonus(managers,result);
        PairAlg.swap(result);
    }
}

class PairAlg{
    public static boolean hasNulls(Pair<?> p){
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p) { swapHelper(p);}

    public static <T> void swapHelper(Pair<T> p){
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}
