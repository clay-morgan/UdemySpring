package udemy.database;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import java.util.*;

/**
 * Created by Clay on 15/01/15.
 */
public class DBApp
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans/database.xml" );

        OfferDAO offerDAO = ( OfferDAO ) context.getBean( "offerDAO" );
        try
        {
            // delete the offer with id 3
            offerDAO.delete( 3 );

            //runCreatesAndUpdates( offerDAO );

            // run a failing create to test transaction
            List<Offer> failOffers = new ArrayList<Offer>();
            failOffers.add( new Offer( 3, "Nick", "nick@mail.com", "boxing" ) );
            failOffers.add( new Offer( 2, "Chael", "chael@mail.com", "wrestling and stuff" ) );     // duplicate key
            offerDAO.failCreate( failOffers );

            // get all the offers
            List<Offer> offers = offerDAO.getOffers();
            for( Offer offer: offers )
            {
                System.out.println( offer );
            }

            // get the offer with id 2
            System.out.println( "example: retrieving by ID" );
            Offer offer = offerDAO.getOfferById( 1 );
            System.out.println( offer );
        }
        catch( CannotGetJdbcConnectionException e )
        {
            System.out.println( "Check your jdbc.properties file dog" );
        }
        catch( DataAccessException e )
        {
            System.out.println( e.getClass() );
            System.out.println( e.getMessage() );
        }

        ( ( ClassPathXmlApplicationContext ) context ).close();
    }


    private static void runCreatesAndUpdates( OfferDAO offerDAO )
    {
        // create a new offer
        Offer clay = new Offer( "Clay", "clay@email.com", "spring java coding" );
        offerDAO.create( clay );

        Offer ken = new Offer( "Ken", "ken@email.com", "single page apps" );
        if( offerDAO.create( ken ) )
        {
            System.out.println( "created ken successfully" );
        }

        // update an offer
        Offer bob = offerDAO.getOfferById( 1 );
        bob.setName( "Robert" );
        offerDAO.update( bob );

        // create a batch of objects
        List<Offer> offersToCreate = new ArrayList<Offer>();
        offersToCreate.add( new Offer( "Natalie", "nat@mail.com", "services" ) );
        offersToCreate.add( new Offer( "Karen", "karen@mail.com", "interviews and stuff" ) );
        int[] createResults = offerDAO.create( offersToCreate );
        for( int i: createResults )
        {
            System.out.println( i == 1 ? "success" : "fail" );
        }
    }

}
