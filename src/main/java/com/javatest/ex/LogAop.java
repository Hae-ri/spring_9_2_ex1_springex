package com.javatest.ex;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {

	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String signatureStr = joinPoint.getSignature().toShortString(); // 타겟 메서드의 signature 정보
		System.out.println(signatureStr + "메서드가 시작되었습니다.");
		long st = System.currentTimeMillis(); // 메서드 호출 전 현재 시간을 long형 변수에 저장
		
		try {
			Object obj = joinPoint.proceed(); // 타겟의 메서드(핵심 기능)를 호출
			return obj;
		}finally {
			long et = System.currentTimeMillis(); // 메서드 호출 후 현재 시간
			System.out.println(signatureStr + "메서드가 종료되었습니다.");
			System.out.println(signatureStr + "메서드의 작업 실행시간 : " + (et - st) + "ms" );
		}
	}
	
	
	
}