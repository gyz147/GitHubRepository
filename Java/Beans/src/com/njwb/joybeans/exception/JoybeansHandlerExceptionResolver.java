package com.njwb.joybeans.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 乐豆系统处理器异常解析器
 * @author Administrator
 *
 */
public class JoybeansHandlerExceptionResolver implements HandlerExceptionResolver{

	/**
	 * 统一处理controller中抛出的异常
	 * 有两类
	 * 1.自定义异常  JoybeansException
	 * 2.未知异常 ---》转成JoybeansException
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		JoybeansException joybeansException = null;
		if(ex instanceof JoybeansException){
			joybeansException = (JoybeansException)ex;
		}else{
			ex.printStackTrace();
			//其他异常 如 空指针   类型转换错误  文件找不到。。。。。----》能给使用者看吗？
			joybeansException = new JoybeansException("系统忙");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("errMsg", joybeansException.getMessage());//约定
		modelAndView.setViewName("prompt/error");
		
		return  modelAndView;
	}

}
