package udemy.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Clay on 13/01/15.
 */
@Component
public class Logger
{
    private ConsoleWriter consoleWriter;
    private LogWriter fileWriter;

    @Autowired
    public void setConsoleWriter( ConsoleWriter consoleWriter )
    {
        this.consoleWriter = consoleWriter;
    }

    @Autowired
    @Qualifier( value = "rhino" )
    public void setFileWriter( LogWriter fileWriter )
    {
        this.fileWriter = fileWriter;
    }

    public void writeFile( String text )
    {
        fileWriter.write( text );
    }

    public void writeConsole( String text )
    {
        consoleWriter.write( text );
    }

    @PostConstruct
    public void init()
    {
        System.out.println( "Initializing Logger" );
    }

    @PreDestroy
    public void destroy()
    {
        System.out.println( "Destroying Logger" );
    }
}
