package catcafe;

import static java.util.Objects.requireNonNull;

import java.util.Optional;
import tree.Empty;
import tree.Tree;
import tree.TreeVisitor;

public class CatCafe {
    private Tree<FelineOverLord> clowder = new Empty<>();

    /** adds a cat to the cat clowder */
    public void addCat(FelineOverLord cat) {
        clowder = clowder.addData(requireNonNull(cat));
    }

    /** returns amount of cat that currently exists */
    public long getCatCount() {
        return clowder.size();
    }

    public FelineOverLord getCatByName(String name) {
        if (name == null) return null;

        for (FelineOverLord c : clowder) {
            if (c.name().equals(name)) return c;
        }

        return null;
    }

    /** returns a cat that has a certain weight the weight is specified in the parameter */
    public FelineOverLord getCatByWeight(int minWeight, int maxWeight) {
        if (minWeight < 0) throw new RuntimeException("cat with negative weight dont exist");
        if (maxWeight < minWeight) throw new RuntimeException("that doesnt make sense!");

        for (FelineOverLord c : clowder) {
            if (c.weight() >= minWeight && c.weight() < maxWeight) return c;
        }

        return null;
    }

    /** accept method for visitor pattern */
    String accept(TreeVisitor<FelineOverLord> visitor) {
        return clowder.accept(visitor);
    }


}
