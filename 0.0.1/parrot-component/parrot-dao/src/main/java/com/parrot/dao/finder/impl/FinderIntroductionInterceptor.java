package com.parrot.dao.finder.impl;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

import com.parrot.dao.finder.FinderExecutor;

/**
 * Connects the Spring AOP magic with the Hibernate DAO magic For any method
 * beginning with "find" this interceptor will use the FinderExecutor to call a
 * Hibernate named query
 */
public class FinderIntroductionInterceptor implements IntroductionInterceptor {

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {

		FinderExecutor executor = (FinderExecutor) methodInvocation.getThis();

		String methodName = methodInvocation.getMethod().getName();
		if (methodName.startsWith("find")) {
			Object[] arguments = methodInvocation.getArguments();
			return executor.executeFinder(methodInvocation.getMethod(),
					arguments);
		} else if (methodName.startsWith("iterate")) {
			Object[] arguments = methodInvocation.getArguments();
			return executor.iterateFinder(methodInvocation.getMethod(),
					arguments);
		}
		// else if(methodName.startsWith("scroll"))
		// {
		// Object[] arguments = methodInvocation.getArguments();
		// return executor.scrollFinder(methodInvocation.getMethod(),
		// arguments);
		// }
		else {
			return methodInvocation.proceed();
		}
	}

	public boolean implementsInterface(Class intf) {
		return intf.isInterface()
				&& FinderExecutor.class.isAssignableFrom(intf);
	}
}
