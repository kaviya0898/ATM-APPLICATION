package AtmMachine;
import java.util.*;
import java.lang.*;
import java.sql.SQLException;
public class atmMachine
{
 
	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("\t\t\tWELCOME TO XYZ BANK ATM");
		//System.out.println("ENTER YOUR 3-DIGIT  PIN");
		pinProcess pinObject=new pinProcess();
		pinObject.pinProcess();
      
       
}
}
