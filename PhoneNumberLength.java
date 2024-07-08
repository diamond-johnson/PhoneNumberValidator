package testValidator;

public class PhoneNumberLength implements PhoneNumberValidator{
	
	private int min;
    private int max;
	
    public PhoneNumberLength(int min, int max) {
        this.min = min;
        this.max = max;
    }

	@Override
	public boolean validatePhoneNumber(String n) {
		return n.length() >= min && n.length() <= max;	
	}

	@Override
	public String getMessage() {
		 return "Phone Number length is not between [" + min + " , " + max + "]";
	}

}
