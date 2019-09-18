package aspects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component("logging")
@Aspect
public class LoggingAspect
{
    final static Logger logger = LogManager.getLogger(LoggingAspect.class);

    @After("execution(public java.util.List<model.Movies> getAllShowtimes())")
    public void logAllRequest(JoinPoint jp)
    {
        logger.info("The /getAllShowtimes endpoint was accessed.");
    }

    @After("execution(public model.Movies getMovie(*))")
    public void logMovieRequest(JoinPoint jp)
    {
        logger.info("The /getMovie endpoint was accessed");
    }
}
