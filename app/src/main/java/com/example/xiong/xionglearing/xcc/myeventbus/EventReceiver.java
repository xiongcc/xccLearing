package com.example.xiong.xionglearing.xcc.myeventbus;

public interface EventReceiver<T> {

	void onEvent(String name, T data);

}
