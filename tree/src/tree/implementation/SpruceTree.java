package tree.implementation;

import tree.components.Branch;
import tree.components.Root;
import tree.components.Trunk;
import tree.coniferous.ConiferousTree;
import tree.coniferous.components.Cone;
import tree.coniferous.components.Needle;

import java.util.ArrayList;
import java.util.List;

public class SpruceTree implements ConiferousTree {

    private final Root root;
    private final Trunk trunk;
    private final List<Branch> branches = new ArrayList<>();
    private final List<Needle> needles = new ArrayList<>();
    private final List<Cone> cones = new ArrayList<>();

    public SpruceTree(Root root, Trunk trunk, List<Branch> branches, List<Needle> needles, List<Cone> cones) {
        this.root = root;
        this.trunk = trunk;
        this.branches.addAll(branches);
        this.needles.addAll(needles);
        this.cones.addAll(cones);
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
    public void produceNeedles() {

    }

    @Override
    public void removeNeedles() {
        this.needles.clear();
    }

    @Override
    public List<Needle> getNeedles() {
        return this.needles;
    }

    @Override
    public void produceCone() {

    }

    @Override
    public void removeCone() {

    }

    @Override
    public List<Cone> getCones() {
        return this.cones;
    }
}
