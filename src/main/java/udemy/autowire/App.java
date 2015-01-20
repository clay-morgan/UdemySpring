package udemy.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Clay on 13/01/15.
 */
public class App
{
    public static void main( String[] args )
    {

        ApplicationContext context = new ClassPathXmlApplicationContext( "beans/beans.xml" );

        Logger logger = ( Logger ) context.getBean( "logger" );

        logger.writeConsole( "oh hai console" );
        logger.writeFile( "HAI FILE!!1" );

        ( ( ClassPathXmlApplicationContext ) context ).close();
    }
}
