package link.hiroshisprojects.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 *	Pointcut that matches all repositories, services, and controllers declared by Spring
	 * */
	@Pointcut("within(@org.springframework.stereotype.Repository *)" +
		" || within(@org.springframework.stereotype.Service *)" + 
		" || within(@org.springframework.web.bind.annotation.RestController *)")
	public void springBeanPointcut() {}

}	
