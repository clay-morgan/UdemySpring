package udemy.autowire;

/**
 * Created by Clay on 13/01/15.
 */
public class FileWriter implements LogWriter
{

    public void write( String text )
    {
        // Write to a file here.
        // Dummy implementation
        System.out.println( "Write to file: " + text );

    }
}
