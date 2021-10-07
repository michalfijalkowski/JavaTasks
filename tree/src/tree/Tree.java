package tree;

import tree.components.Branch;
import tree.components.Root;
import tree.components.Trunk;

import java.util.List;

public interface Tree {

    void grow();

    void cut();

    Root getRoot();

    Trunk getTrunk();

    List<Branch> getBranches();
}
