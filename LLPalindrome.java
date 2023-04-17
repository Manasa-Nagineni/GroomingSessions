import java.util.*;
import java.lang.*;

public class LLPalindrome {
    public static void main(String args[]) {
        
        LinkedList<String> ll = new LinkedList<>();
        
            ll.add("a");
            ll.add("b");
            ll.add("c");

        
        ListIterator<String> i = ll.listIterator();
        String[] arr= new String[ll.size()];
        int x=0;
        while(i.hasNext()){
            arr[x]= i.next();
            x++;
        }
        x = 0;
        while(i.hasPrevious()){
            if(arr[x] == i.previous()){
                x++;
            }
            else{
                System.out.println("it is not a palindrome");
                break;
            }
        }
        if(x==ll.size()){
            System.out.println("it is a palindrome");
        }
    }
    
}
