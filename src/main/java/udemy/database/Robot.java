package udemy.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Clay on 15/01/15.
 */
@Component( "robot" )
public class Robot
{
    private String id = "Default robot id";
    private String speech = "I am A.W.E.S.O.M.E.O. (default speech)";

    @Autowired
    public void setId( @Value( "${jdbc.username}" ) String id )
    {
        this.id = id;
    }


    @Autowired
    public void setSpeech( @Value( "${jdbc.password}" ) String speech )
    {
        this.speech = speech;
    }

    public void speak()
    {
        System.out.println( id + ": " + speech );
    }

    /**
     * Some other options for SPEL:
     *
     * #{'I like to say: ' + randomText.getText()}
     * #{new java.util.Date().toString()}
     * #{T(Math).PI}                            // access static stuff using T()
     * #{T(Math).sin(T(Math).PI/4) lt 0.8}      // lt > less than, ge > greater than or equal, eq > equals, etc.
     */
}
