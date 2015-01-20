package udemy.autowire;

import org.springframework.stereotype.Component;

/**
 * Created by Clay on 13/01/15.
 */
@Component
public class ConsoleWriter implements LogWriter
{

    public void write( String text )
    {
        System.out.println( text );
    }

}