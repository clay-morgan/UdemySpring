package udemy.autowire;

/**
 * Created by Clay on 13/01/15.
 */
public class ConsoleWriter implements LogWriter
{

    public void write( String text )
    {
        System.out.println( text );
    }

}