package tree.deciduous;

import tree.Tree;
import tree.deciduous.components.Leaf;

import java.util.List;

public interface DeciduousTree extends Tree {

    void produceLeaf();

    void removeLeaf();

    List<Leaf> getLeaves();

    void rustle();
}
