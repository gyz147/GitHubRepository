package com.njwb.joybeans.controller.validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class JoybeansValidator {
	public static Map<String, String> getErrMsg(BindingResult bindingResult){
		Map<String, String> errMap = new HashMap<String, String>();
		//取出错误
		List<FieldError> fieldErrors =  bindingResult.getFieldErrors();
		for(FieldError fieldError : fieldErrors){
			//fieldError.getField()--出错的参数name值
			//fieldError.getDefaultMessage()--具体的错误信息  来自于校验资源文件中的value值
//			System.out.println(fieldError.getField() + "--" + fieldError.getDefaultMessage());
			errMap.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return errMap;
	}
}
