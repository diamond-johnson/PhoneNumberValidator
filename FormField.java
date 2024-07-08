package testValidator;

import java.util.ArrayList;
import java.util.Stack;

public class FormField {
	
	public ArrayList<PhoneNumberValidator> PhoneNumberValidators;
	public ArrayList<NameValidator> NameValidators;
	public String name;
	private String value;
	
	public FormField(String name, String value) {
		PhoneNumberValidators = new ArrayList<PhoneNumberValidator>();
		NameValidators = new ArrayList<NameValidator>();
		this.name = name;
		this.value = value;
	}
	
	public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

	public Stack<String> setValuePhoneNumber(String value) {
		
		Stack<String> errors = new Stack<>();

        this.value = value;

        for (PhoneNumberValidator validator : PhoneNumberValidators) {
            if (!validator.validatePhoneNumber(value)) {
            	errors.push(validator.getMessage());
            }
        }

        return errors;
	}
	
	public Stack<String> setValueName(String value) {

		Stack<String> errors = new Stack<>();
        
        this.value = value;

        for (NameValidator validator : NameValidators) {
            if (!validator.validate(value)) {
            	errors.push(validator.getMessage());
            }
        }

        return errors;
	}

}
