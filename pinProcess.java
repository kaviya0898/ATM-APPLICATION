package AtmMachine;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import java.util.HashMap;
public class pinProcess
{
	private int  totalamount;
	private int available;
	public int pin;
	public void pinProcess() throws SQLException
	{
		Connection connect1=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","Password08");
	    Statement state1=connect1.createStatement();
		Scanner sc=new Scanner(System.in);
		boolean bool=false;
				while(!bool) {
		System.out.println("ENTER YOUR NUMBER");
		String cusnumber=sc.next();
		ResultSet res=state1.executeQuery("select * from customeracc where (customernumber="+cusnumber+")");
		if(!(res.next()))
		{
			System.out.println("YOU HAVE ENTERED WRONG NUMBER");
			bool=false;
		}
		boolean boole=false;
		while(!bool) {
		System.out.println("ENTER YOUR 3-DIGIT  PIN");
		pin=sc.nextInt();
		ResultSet result=state1.executeQuery("select pin from customeracc where (customernumber="+cusnumber+")");
		if(!(result.next()))
		{
			System.out.println("YOU HAVE ENTERED WRONG PIN");
			boole=false;
		}
		else {
		bool=true;
		}
		
		}
	
	/*HashMap<String,Integer> phoneNumber=new HashMap<String,Integer>();
    phoneNumber.put("7200347556",100);
    phoneNumber.put("6834683245",101);
    phoneNumber.put("8071967856",102);
    phoneNumber.put("9863744613",103);
    phoneNumber.put("7806990887",104);
    phoneNumber.put("9073958448",105);
    phoneNumber.put("9086670054",106);
    phoneNumber.put("8489068709",107);
    phoneNumber.put("9976278045",108);
    phoneNumber.put("9866789244",109);
	
	
	if(pin>=100&&pin<=109)
	{
		 HashMap<Integer,String> list=new HashMap<Integer,String>();
	        list.put(100,"A");
	        list.put(101,"B");
	        list.put(102,"C");
	        list.put(103,"D");
	        list.put(104,"E");
	        list.put(105,"F");
	        list.put(106,"G");
	        list.put(107,"H");
	        list.put(108,"I");
	        list.put(109,"J");
	        if(list.containsKey(pin))
	        {*/
	        	System.out.print("WELCOME");
	        	
	        System.out.println();
	        
	System.out.println("1.DEPOSIT"+"         "+"2.FAST CASH");
	System.out.println("3.CASH WITHDRAWL"+"   "+"4.PINCHANGE");
	System.out.println("5.BALANCE ENQUIRY"+"      "+"6.MINI STATEMENT");
	System.out.println("7.EXIT");
	
	System.out.println("-----------------------");
	
  /* }
	else
	{
		System.out.println("YOU HAVE ENTERED WRONG PIN");
		System.out.println("FORGOT PIN? PRESS 1 TO REset OR 2 TO EXIT");
		int reset=sc.nextInt();
		if(reset==1)
		{
			
			System.out.println("ENTER YOU REGISTERED MOBILE NUMBER");
	    	String number=sc.next();
	    	
	    	if(phoneNumber.containsKey(number))
	    	{
	    		System.out.println("ENTER A THREE DIGIT PIN");
	    		int three=sc.nextInt();
	    		phoneNumber.put(number,three);
	    		System.out.println("PIN SUCCESSFULLY CHANGED");
	    		System.out.println("THANK YOU FOR COMING PLEASE VISIT AGAIN");
	    	}
	    	else
			{
				System.out.println("THIS NUMBER IS NOT REGISTERED WITH OUR BANK");
				System.out.println("PLEASE CONTACT RESPECTIVE BRANCH");
				System.out.println("THANK YOU FOR COMING PLEASE VISIT AGAIN");
			}
		
	    }
		else
		{
			System.out.println("THANK YOU FOR COMING PLEASE VISIT AGAIN");
		}
	
		System.exit(0);
	}*/
	System.out.print("ENTER YOUR OPTION:");
    int option=sc.nextInt();
   /* HashMap<Integer,Integer> balance=new HashMap<Integer,Integer>();
    balance.put(100,1000);
    balance.put(101,4000);
    balance.put(102,2000);
    balance.put(103,6000);
    balance.put(104,7000);
    balance.put(105,9000);
    balance.put(106,12000);
    balance.put(107,10000);
    balance.put(108,1030);
    balance.put(109,1010);*/
    
    switch(option)
    {
    case 1:
    	System.out.println("ENTER THE AMOUNT TO DEPOSIT:");
    	int amount=sc.nextInt();
       state1.executeUpdate("insert into transcation (credit,customernumber) values ("+amount+","+cusnumber+")");
       ResultSet result1=state1.executeQuery("select balance from customeracc where (customernumber="+cusnumber+")");
       int temp=0;
       while(result1.next())
       {
    	  temp= result1.getInt("balance");
    	  temp+=amount;
       }
       state1.executeUpdate("update customeracc set balance="+temp);
    	System.out.println("SUCCESSFULLY DEPOSITED");
    	
    	break;
    case 2:
    	System.out.println("SELECT FROM THE BELOW OPTIONS:");
    	System.out.println("500 2000");
    	System.out.println("5000 10000");
    	int n=sc.nextInt();
    	
    
    	
    		state1.executeUpdate("insert into transcation(debit,customernumber) values ("+n+","+cusnumber+")");
    	       ResultSet result2=state1.executeQuery("select balance from customeracc where (customernumber="+cusnumber+")");
    	       int temp1=0;
    	       while(result2.next())
    	       {
    	    	  temp1= result2.getInt("balance");
    	    	  temp1-=n;
    	       }
    	       state1.executeUpdate("update customeracc set balance="+temp1);
    	    System.out.println("AMOUNT CAN BE WITHDRAWN");
    	break;
    case 3:
    	System.out.println("ENTER THE AMOUNT TO WITHDRAW:");
    	int withdrawamount=sc.nextInt();
    	state1.executeUpdate("insert into transcation(debit,customernumber) values ("+withdrawamount+","+cusnumber+")");
	       ResultSet result3=state1.executeQuery("select balance from customeracc where (customernumber="+cusnumber+")");
	       int temp3=0;
	       while(result3.next())
	       {
	    	  temp3= result3.getInt("balance");
	    	  temp3-=withdrawamount;
	       }
	       state1.executeUpdate("update customeracc set balance="+temp3);
	       ResultSet result10=state1.executeQuery("select balance from customeracc where (customernumber="+cusnumber+")");
	    	while(result10.next())
	    	{
	    		System.out.print("AVAILABLE BALANCE IS:");
	    		System.out.println( result10.getInt("balance"));
	    	}
	    System.out.println("AMOUNT CAN BE WITHDRAWN");
    	break;
    case 4:
    	System.out.println("ENTER YOU REGISTERED MOBILE NUMBER");
    	String number=sc.next();
    	ResultSet result5=state1.executeQuery("select customernumber from customeracc where (customernumber="+cusnumber+")");
    	if(result5.next())
		{
			System.out.println("ENTER A THREE DIGIT PIN");
			int pin=sc.nextInt();
			state1.executeUpdate("update customeracc set pin="+pin);
			System.out.println("PIN CHANGED SUCCESSFULLY");
		}
    	else
    	{
    		System.out.println("YOU HAVE ENTERED WRONG MOBILE NUMBER PLEASE CONTACT RESPECTIVE BANK");
    	}
    	break;
    case 5:
    	System.out.println("AVAILABLE BALANCE IN YOUR ACCOUNT:");
    	ResultSet result6=state1.executeQuery("select balance from customeracc where (customernumber="+cusnumber+")");
    	while(result6.next())
    	{
    		System.out.println( result6.getInt("balance"));
    	}
    	System.out.println("THANK YOU FOR COMING PLEASE VISIT AGAIN");
       break;
    case 6:
    	System.out.println("MINI STATEMENT");
    	System.out.println("CREDIT");
    	ResultSet result7=state1.executeQuery("select credit from transcation where (customernumber="+cusnumber+")");
    	while(result7.next())
    	{
    		System.out.println( result7.getInt("credit"));
    	}
    	System.out.println("--------------------------------------------");
    	System.out.println("DEBIT");
    	ResultSet result8=state1.executeQuery("select debit from transcation where (customernumber="+cusnumber+")");
    	while(result8.next())
    	{
    		System.out.println( result8.getInt("debit"));
    	}
    	ResultSet result11=state1.executeQuery("select balance from customeracc where (customernumber="+cusnumber+")");
    	while(result11.next())
    	{
    		System.out.print("AVAILABLE BALANCE IS:");
    		System.out.println( result11.getInt("balance"));
    	}
    	break;
    
    case 7:
    	System.out.println("THANK YOU FOR COMING PLEASE VISIT AGAIN");
        break;
    	
  
    
 }
	}
 
	}
}


