package com.seop.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static java.lang.Class.forName;

@SpringBootApplication
public class JwtApplication {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		SpringApplication.run(JwtApplication.class, args);

		Class<?> clazz = forName("com.seop.jwt.reflection.Dog");

		Constructor<?> constructor1 = clazz.getDeclaredConstructor();
		Constructor<?> constructor2 = clazz.getDeclaredConstructor(String.class);
		Constructor<?> constructor3 = clazz.getDeclaredConstructor(String.class, int.class);

		constructor1.setAccessible(true);
		Object dog1 = constructor1.newInstance();
		Object dog2 = constructor2.newInstance("호두");
		Object dog3 = constructor3.newInstance("호두", 5);

		System.out.println(dog1);
		System.out.println(dog2);
		System.out.println(dog3);


	}

}
