import java.util.Scanner;
import java.util.regex.*;
import java.lang.*;

class NotValidName extends Exception{
    NotValidName(String s){
        super(s);
    }
}

class NotValidDate extends Exception{
    NotValidDate(String s){
        super(s);
    }
}

class NotValidAadhar extends Exception{
    NotValidAadhar(String s){
        super(s);
    }
}


public class Username {
    static String validateName(String name) {
        
        Pattern p = Pattern.compile("^[a-zA-Z\\s]{5,30}$");
        Matcher m = p.matcher(name);
        boolean flag = m.find();
        try{
        if(flag == true){
            String delimiter = "\\s";
            Pattern p1 = Pattern.compile(delimiter);
            String names[] = p1.split(name);
            try{
            if(names.length < 2){
                throw new NotValidName("Enter your valid full name separated by space");
            }else{
                System.out.println("FirstName : " + names[0] + "\nLastname : " + names[names.length-1] );
            }
            }
            catch(NotValidName e){
                System.out.println(e.getMessage());
                Scanner s1 = new Scanner(System.in);
                name = s1.nextLine();
                validateName(name);
            }
        }else{
            throw new NotValidName("Your full name should have a minimum length of 5 and maximum length of 30 characters\nEnter your full name without speacial characters or digits");
        }
        }catch(NotValidName e){
            System.out.println(e.getMessage());
            Scanner s1 = new Scanner(System.in);
            name = s1.nextLine();
            validateName(name);
        }
        String res = name.replaceAll("\\s",""); 
        return res.substring(0, 4);
        
    }


    static String validateDate(String date){
        String regex = "^(3[01]|[12][0-9]|0[1-9])-(1[0-2]|0[1-9])-[0-9]{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
        try{
        if(!matcher.find()){
            throw new NotValidDate("Sorry , Please enter valid date:");
        

        }
        }catch(NotValidDate e){
            System.out.println(e.getMessage());
            Scanner s2 = new Scanner(System.in);
            date = s2.nextLine();
            validateDate(date);
        }
        return date.substring(0,2)+date.substring(6,10);
    }

    static String validateAadhar(String aadhar){
        String r = "^[2-9]{1}[0-9]{11}$";
        Pattern p = Pattern.compile(r);
        Matcher m = p.matcher(aadhar);
        try{
            if(!m.find()){
                throw new NotValidAadhar("Please enter a valid Aadhar number with 12 digits");
            
    
            }
            }catch(NotValidAadhar e){
                System.out.println(e.getMessage());
                Scanner s3 = new Scanner(System.in);
                aadhar = s3.nextLine();
                validateAadhar(aadhar);
            }
        return aadhar.substring(0,4);
    } 
    public static void main(String[] args){
        String name;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter your Full name: ");
        name = s.nextLine();
        String s1 = validateName(name);
        System.out.println("Enter your date of birth in dd-mm-yyyy format:");
        String date = s.nextLine();
        String s2 = validateDate(date);
        //System.out.println(s2);
        System.out.println("Enter your aadhar number :");
        String aadhar = s.nextLine();
        String s3 = validateAadhar(aadhar);
        String username = s1 + s2 + s3 ;
        System.out.println("Your Username is : " + username);

        
    }
}
