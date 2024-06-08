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

        cafe.addCat(new FelineOverLord("Miss Chief Sooky", 2));
        cafe.addCat(new FelineOverLord("Gwenapurr Esmeralda", 3));
        cafe.addCat(new FelineOverLord("Morticia", 4));
        cafe.addCat(new FelineOverLord("Fitzby Darnsworth", 5));

        System.out.println("\n\nEs schnurren " + cafe.getCatCount() + " Samtpfoetchen.");

        try {
            FelineOverLord meow = cafe.getCatByWeight(3, 4).orElseThrow();
            System.out.println("Gewicht [3,4]: " + meow);

            meow = cafe.getCatByName("Morticia").orElseThrow();
            System.out.println("Name 'Morticia': " + meow);

            meow = cafe.getCatByName("Miss Chief Sooky").orElseThrow();
            System.out.println("Name 'Miss Chief Sooky': " + meow);

        } catch (NoSuchElementException e) {
            System.out.println("noSuchElement: " + e.getMessage());
        } catch (NullPointerException d) {
            System.out.println("nullPunter: " + d.getMessage());
        } catch (Exception x) {
            System.out.println("exception: " + x.getMessage());
        }

        System.out.println("\n\n");
    }
}
