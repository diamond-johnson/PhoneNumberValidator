package testValidator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Stack<String> errors;
		ArrayList<PhoneNumberValidator> phoneValidators = new ArrayList<>();
		ArrayList<NameValidator> nameValidators = new ArrayList<>();
		
		PhoneNumberLength phoneNumberLength = new PhoneNumberLength(11,13);
		PhoneNumberCorrectness phoneNumberCorrectness = new PhoneNumberCorrectness();
		phoneValidators.add(phoneNumberLength);
		phoneValidators.add(phoneNumberCorrectness);
		
		NameLength nameLength = new NameLength(3,10);
		NameCorrectness nameCorrectness = new NameCorrectness();
		nameValidators.add(nameLength);
		nameValidators.add(nameCorrectness);
		
		FormField formField = new FormField("Di&hdj", "value");
		formField.PhoneNumberValidators = phoneValidators;
        formField.NameValidators = nameValidators;
		
		Queue<String> phoneNumbers = new LinkedList<>();
		Queue<String> names = new LinkedList<>();
		
		phoneNumbers.add("021565688");
		phoneNumbers.add("8986363265325");
		names.add("@o");
		names.add("Di&hdj");
		
		errors = new Stack<>();
		
		 while (!phoneNumbers.isEmpty()) {
	            String phoneNumber = phoneNumbers.poll();
	            Stack<String> phoneErrors = formField.setValuePhoneNumber(phoneNumber);
	            if (!phoneErrors.isEmpty()) {
	                errors.addAll(phoneErrors);
	                errors.add(phoneNumber);
	            }
	        }

		 
		 System.out.println("errors for phone numbers:");
	     while (!errors.isEmpty()) {
	            System.out.println(errors.pop());
	     }
	     
	     
	     
	     while (!names.isEmpty()) {
	            String name = names.poll();
	            Stack<String> nameErrors = formField.setValueName(name);
	            if (!nameErrors.isEmpty()) {
	            	errors.addAll(nameErrors);
	            	errors.add(name);
	            }
	        }
	         
	      System.out.println("errors for names:");
	        while (!errors.isEmpty()) {
	            System.out.println(errors.pop());
	      }
	}
}
