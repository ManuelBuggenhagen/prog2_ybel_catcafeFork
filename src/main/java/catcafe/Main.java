package catcafe;

import java.util.NoSuchElementException;

/**
 * Starter for the cat-café task.
 */
public class Main {
    /**
     * And go.
     *
     * @param args command line parameters, not used
     */
    public static void main(String... args) {
        CatCafe cafe = new CatCafe();
        FelineOverLord a = new FelineOverLord("Miss Chief Sooky", 2);
        FelineOverLord b = new FelineOverLord("Gwenapurr Esmeralda", 3);
        FelineOverLord c = new FelineOverLord("Morticia", 3);
        FelineOverLord d = new FelineOverLord("Fitzby Darnsworth", 5);

        cafe.addCat(a);
        cafe.addCat(b);
        cafe.addCat(c);
        cafe.addCat(d);

        System.out.println("\n\nEs schnurren " + cafe.getCatCount() + " Samtpfoetchen.");

        FelineOverLord meow = null;
        try {
            if (cafe.getCatByWeight(3, 4).isPresent()) {
                meow = cafe.getCatByWeight(3, 4).get();
                System.out.println("Gewicht [3,4]: " + meow);
            }

            if (cafe.getCatByName("Morticia").isPresent()) {
                meow = cafe.getCatByName("Morticia").get();
                System.out.println("Name 'Morticia': " + meow);
            }

            if (cafe.getCatByName("Miss Chief Sooky").isPresent()) {
                meow = cafe.getCatByName("Miss Chief Sooky").get();
                System.out.println("Name 'Miss Chief Sooky': " + meow);
            }


        } catch (NoSuchElementException e) {
            System.out.println("noSuchElement: " + e.getMessage());
        } catch (NullPointerException f) {
            System.out.println("nullPunter: " + f.getMessage());
        } catch (Exception x) {
            System.out.println("exception: " + x.getMessage());
        }

        System.out.println("\n\n");
    }
}
