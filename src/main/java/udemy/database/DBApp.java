package udemy.database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Clay on 15/01/15.
 */
public class DBApp
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans/database.xml" );

        Robot robot = ( Robot ) context.getBean( "robot" );
        robot.speak();

        ( ( ClassPathXmlApplicationContext ) context ).close();
    }

}
