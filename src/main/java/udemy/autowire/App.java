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

        ApplicationContext context = new ClassPathXmlApplicationContext( "beans.xml" );

        Logger logger = ( Logger ) context.getBean( "logger" );

        logger.writeConsole( "oh hai" );
        logger.writeFile( "HAI FILE" );

        ( ( ClassPathXmlApplicationContext ) context ).close();
    }
}
