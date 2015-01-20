package udemy.autowire;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Clay on 13/01/15.
 */
@Component( "rhino" )
public class FileWriter implements LogWriter
{

    public void write( String text )
    {
        // Write to a file here.
        // Dummy implementation
        System.out.println( "Write to file: " + text );

    }
}
