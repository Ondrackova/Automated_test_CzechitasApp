import com.github.javafaker.Faker;
import java.util.Random;
import static java.lang.System.*;

public class RandomNameGenerator {

        // function for generating random surname
        public static String randomNameGenerator() {
            String[] surnames = {"Smith", "Johnson", "Williams", "Brown", "Jones"};
            Random random = new Random();
            int randomIndex = random.nextInt(surnames.length);  // random index
            return surnames[randomIndex];
        }
    }

