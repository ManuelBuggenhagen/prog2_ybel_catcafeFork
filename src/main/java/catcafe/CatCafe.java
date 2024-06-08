package catcafe;

import static java.util.Objects.requireNonNull;

import java.util.Optional;

import tree.Empty;
import tree.Tree;
import tree.TreeVisitor;

public class CatCafe {
    private Tree<FelineOverLord> clowder = new Empty<>();

    /**
     * adds a cat to the cat clowder
     */
    public void addCat(FelineOverLord cat) {
        clowder = clowder.addData(requireNonNull(cat));
    }

    /**
     * returns amount of cat that currently exists
     */
    public long getCatCount() {
        return clowder.size();
    }

    public Optional<FelineOverLord> getCatByName(String name) {
        if (name == null) throw new NullPointerException("invalid parameter!");
/*
        for (FelineOverLord c : clowder) {
            if (c.name().equals(name)) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
 */
        return clowder.stream()
            .filter(c -> c.name().equals(name))
            .findFirst();
    }


    /**
     * returns a cat that has a certain weight the weight is specified in the parameter
     */
    public Optional<FelineOverLord> getCatByWeight(int minWeight, int maxWeight) {
        if (minWeight < 0) throw new RuntimeException("cat with negative weight dont exist");
        if (maxWeight < minWeight) throw new RuntimeException("that doesnt make sense!");

        /*
        for (FelineOverLord c : clowder) {
            if (c.weight() >= minWeight && c.weight() < maxWeight) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
         */

        return clowder.stream()
            .filter(f -> f.weight() >= minWeight)
            .filter(g -> g.weight() < maxWeight)
            .findFirst();
    }


    /**
     * accept method for visitor pattern
     */
    String accept(TreeVisitor<FelineOverLord> visitor) {
        return clowder.accept(visitor);
    }
}
