package testValidator;

public class PhoneNumberCorrectness implements PhoneNumberValidator{

	@Override
	public boolean validatePhoneNumber(String n) {
	    if (n == null || n.length() < 3) {
	        return false;
	    }
	    String start = n.substring(0, 3);
	    return start.equals("021") || start.equals("098");
	}

	@Override
	public String getMessage() {
		return "[Input is not a valid Number]";
	}

}
