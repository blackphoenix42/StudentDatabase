package validation;

import java.util.regex.Pattern;

public class NameValidation {
	public boolean validate(String name){
		boolean b = Pattern.matches("[a-zA-Z]+", name);
		return b;
	}
}
