package com.example.xiong.xionglearing.xcc.myeventbus;

import java.lang.reflect.Method;

public class MethodSpec<AnnType extends Ann<?>> {

	public final Method method;
	public final Class<?>[] paramTypes;

	public final AnnType ann;

	public MethodSpec(Method method, AnnType ann) {
		this.method = method;
		paramTypes = method.getParameterTypes();
		this.ann = ann;
		method.setAccessible(true);
	}

}