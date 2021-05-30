package com.javacamp.hrms.core.utilities.helpers;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class CodeGenerator {
	public static void CodeGenerate() {
		Random random = new Random();
		int code = random.nextInt(100)+10000;
		System.out.println(code);
	}
}
