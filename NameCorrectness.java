package testValidator;

public class NameCorrectness implements NameValidator{
	
		
	public NameCorrectness() {
	}
	
	@Override
	public boolean validate(String n) {
		for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if (!Character.isAlphabetic(c) && !Character.isSpaceChar(c)) {
                return false;
            }
        }
        return true;
	}
	

	@Override
	public String getMessage() {
		return "[Input is not a valid Name]";
	}

}
