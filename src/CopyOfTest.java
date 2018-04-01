import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * This program demonstrates the use of reflection for manipulating arrays.
 * @author roypan
 * @date 2018/4/1 下午2:49
 */
public class CopyOfTest {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        a = (int[]) goodCopyOf(a,10);
        System.out.println(Arrays.toString(a));
        String[] b = {"Tom","Dick","Harry"};
        b = (String[]) goodCopyOf(b,10);
        System.out.println(Arrays.toString(b));

    }

    /**
     * This method grows an array by allocating a new array of the same type
     * and copying all elements.
     * @date 2018/4/1 下午2:46
     * @param [a, newLength]
     * @return Object
     */
    public static Object goodCopyOf(Object a,int newLength){
        Class cl = a.getClass();
        if(!cl.isArray()) return null;
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType,length);
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }
}
