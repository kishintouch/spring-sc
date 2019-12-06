package com.ecommerce.validator;

import org.springframework.stereotype.Component;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


@Component
public class ValidatorFactory implements ApplicationContextAware {

	private static Map<String, EcommerceValidator> validator;
	
	@SuppressWarnings("unchecked")
	public static <T extends EcommerceValidator> T get(Class<T> clazz) {
		T validtor=(T) validator.get(StringUtils.uncapitalize(clazz.getSimpleName()));
		return validtor;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		validator=applicationContext.getBeansOfType(EcommerceValidator.class);
		
	}
}
