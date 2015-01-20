package udemy.spel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Clay on 15/01/15.
 */
public class SpelApp
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans/spel.xml" );

        Robot robot = ( Robot ) context.getBean( "robot" );
        robot.speak();

        ( ( ClassPathXmlApplicationContext ) context ).close();
    }

}
