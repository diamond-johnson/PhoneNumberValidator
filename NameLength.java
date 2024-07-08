package testValidator;

public class NameLength implements NameValidator{
	
	private int min;
    private int max;
	
    public NameLength(int min, int max) {
        this.min = min;
        this.max = max;
    }

	@Override
	public boolean validate(String n) {
		 return n.length() >= min && n.length() <= max;
	}

	@Override
	public String getMessage() {
		return "Name length is not between [" + min + " , " + max + "]";
	}

}
