package tree.implementation;

import tree.components.Branch;
import tree.components.Root;
import tree.components.Trunk;
import tree.deciduous.DeciduousTree;
import tree.deciduous.components.Leaf;

import java.util.ArrayList;
import java.util.List;

public class OakTree implements DeciduousTree {
    private final Root root;
    private final Trunk trunk;
    private final List<Branch> branches = new ArrayList<>();
    private final List<Leaf> leaves = new ArrayList<>();

    public OakTree(Root root, Trunk trunk, List<Branch> branches, List<Leaf> leaves) {
        this.root = root;
        this.trunk = trunk;
        this.branches.addAll(branches);
        this.leaves.addAll(leaves);
    }
    @Override
    public void grow() {
        System.out.println("Tree growing!");
    }

    @Override
    public void cut() {
        System.out.println("Tree was cut.");
    }

    @Override
    public Root getRoot() {
        return this.root;
    }

    @Override
    public Trunk getTrunk() {
        return this.trunk;
    }

    @Override
    public List<Branch> getBranches() {
        return this.branches;
    }

    @Override
    public void produceLeaf() {

    }

    @Override
    public void removeLeaf() {

    }

    @Override
    public List<Leaf> getLeaves() {
        return this.leaves;
    }

    @Override
    public void rustle() {

    }
}
