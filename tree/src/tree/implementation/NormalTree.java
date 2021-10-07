package tree.implementation;

import tree.Tree;
import tree.components.Branch;
import tree.components.Root;
import tree.components.Trunk;

import java.util.ArrayList;
import java.util.List;

public class NormalTree implements Tree {

    private final Root root;
    private final Trunk trunk;
    private final List<Branch> branches = new ArrayList<>();

    public NormalTree(Root root, Trunk trunk, List<Branch> branches) {
        this.root = root;
        this.trunk = trunk;
        this.branches.addAll(branches);
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
}
