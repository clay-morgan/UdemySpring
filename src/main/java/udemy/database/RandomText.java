package udemy.database;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Clay on 15/01/15.
 */
@Component
public class RandomText
{
    private static String[] setOfPossibleTexts =
    {
        "Wubba lubba dub dub",
        "Concentrate on science",
        "Braaaaup",
        null
    };

    public String getText()
    {
        Random random = new Random();
        return setOfPossibleTexts[ random.nextInt( setOfPossibleTexts.length ) ];
    }

}
