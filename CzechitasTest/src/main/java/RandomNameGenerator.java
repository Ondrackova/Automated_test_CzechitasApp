import java.util.Random;

public class RandomNameGenerator {

        // function for generating random surname
        public static String randomNameGenerator() {
            String[] surnames = {"Novak", "Stastny", "Novotny", "Hrubes", "Sova" , "Hruda" , "Bobes" , "Luza" , "Peroutka" , "Chaloupka" , "Sovak" , "Brabec" , "Hrubec" , "Gudas" , "Pasternak" , "Zilka" , "Janak" , "Kanonyr" , "Jednicka" , "Vomacka" , "Opustil", "Veverka"};
            Random random = new Random();
            int randomIndex = random.nextInt(surnames.length);  // random index
            return surnames[randomIndex];
        }
    }

