package com.ecommerce.user.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.ecommerce.user.model.*;
import com.ecommerce.validator.EcommerceValidator;

@Component("passwordValidator")
public class PasswordValidator extends EcommerceValidator {


	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {

		
		UserDetailsModel userDetailsBean = (UserDetailsModel) target;
		if(StringUtils.isNotBlank(userDetailsBean.getPassword()) ){
			validatePassword(userDetailsBean.getPassword(), errors,"password");
		}else{
			errors.rejectValue("currentPassword","","Your currentPassword cannot be empty");
		}
		
	}

	private static void validatePassword(String password, Errors errors,
			String passwordField) {

		if (password != null && !("".equals(password))) {

			Pattern pattern;
			Matcher matcher;

			String PASSWORD_PATTERN_LENGTH = "(.{8,20})";
			String PASSWORD_PATTERN_DIGIT = "((?=.*\\d).{8,20})";
			String PASSWORD_PATTERN_LCASE = "((?=.*[a-z]).{8,20})";
			String PASSWORD_PATTERN_UCASE = "((?=.*[A-Z]).{8,20})";
			String PASSWORD_PATTERN_NALAPHA = "((?=.*[*&^%$#@!]).{8,20})";

			pattern = Pattern.compile(PASSWORD_PATTERN_LENGTH);
			matcher = pattern.matcher(password);

			if (!matcher.matches()) {
				errors.rejectValue(passwordField,"","Minimum of 8 characters is must");
				return;
			}

			pattern = Pattern.compile(PASSWORD_PATTERN_DIGIT);
			matcher = pattern.matcher(password);
			if (!matcher.matches()) {
				errors.rejectValue(passwordField,"", "Minimum of 1 Digits is must");
				return;
			}

			pattern = Pattern.compile(PASSWORD_PATTERN_LCASE);
			matcher = pattern.matcher(password);
			if (!matcher.matches()) {
				errors.rejectValue(passwordField,"",
						"Must Contain atleast 1 lowercase");
				return;
			}

			pattern = Pattern.compile(PASSWORD_PATTERN_UCASE);
			matcher = pattern.matcher(password);
			if (!matcher.matches()) {
				errors.rejectValue(passwordField,"",
						"Must Contain atleast 1 uppercase");
				return;
			}

			pattern = Pattern.compile(PASSWORD_PATTERN_NALAPHA);
			matcher = pattern.matcher(password);
			if (!matcher.matches()) {
				errors.rejectValue(passwordField,"",
						"Must Contain atleast 1 *&^%$#@!");
				return;
			}

		} else {
			errors.rejectValue(passwordField, "","Field is Required");
		}

	}

}
