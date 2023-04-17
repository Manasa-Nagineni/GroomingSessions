import java.util.*;

class techNotAvailableException extends Exception{
	techNotAvailableException(String msg){
		super(msg);
	}
}

class lessExperienceException extends Exception{
	lessExperienceException(String msg){
		super(msg);
	}	
}


class EnumSample{
	enum Tech{
		JAVA(8,"MANAGER"),
		SAP(4,"SR_ASSOCIATE"),
		QA(3,"ASSOCIATE");
		
		int exp ;
		String role;
		
		private Tech(int exp, String role) {
			this.exp = exp;
			this.role = role;
		}
		
		int getExp() {
			return exp;
		}
		
		String getRole() {
			return role;
		}
	}
	
	enum Role{
		ASSOCIATE(20),
		SR_ASSOCIATE(30),
		MANAGER(45);
		
		int inc ;
		
		private Role(int inc) {
			this.inc = inc;
		}
		
		int getInc() {
			return inc;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main (String[] args) {
		String role="" , tech="" ; 
		int expi, expc=0 , inc=0 ; 
        boolean flag = false;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your Technical skill: ");
		tech = s.nextLine();
        try {
		for(Tech t: Tech.values()) {
			
				if(t.name().equals(tech.toUpperCase())) {
					role = t.getRole();
					expc = t.getExp();
                    flag = true;
			    }
			    
		}
        if (flag==false){
        
				throw new techNotAvailableException("Sorry , there are no current openings for your skill : " + tech);
            }
        }catch(techNotAvailableException e) {
				System.out.println(e.getMessage());
		}
			
        

     
		System.out.println("Enter your experience in years:");
	    expi = s.nextInt();
        //System.out.println(expi + " "+ expc );
        try {
		if(expi < expc) {
		 		throw new lessExperienceException("Sorry , we need a minimum of "+ expc + " years of experience");
		 	}
            else{
                for(Role r: Role.values()) {
                    if(role.equals(r.name())) {
                        inc = r.getInc();
                    }
                }
                System.out.println("Enter your current Salary: ");
                int sal = s.nextInt();
               
                sal = sal*(100+inc)/100;
                System.out.println("We would like to offer you with a package of " + sal + " lpa");

            }
		 }catch(lessExperienceException e) {
		 	System.out.println(e.getMessage());
		 }
		
		
		
	}
}