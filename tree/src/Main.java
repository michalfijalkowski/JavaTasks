import tree.Tree;
import tree.components.Branch;
import tree.components.Root;
import tree.components.Trunk;
import tree.coniferous.ConiferousTree;
import tree.coniferous.components.Cone;
import tree.coniferous.components.Needle;
import tree.deciduous.DeciduousTree;
import tree.deciduous.components.Leaf;
import tree.implementation.*;

import java.util.List;

public class Main {

    public static void main(String[] args){
        //All tree components
        List<Branch> branches = List.of(new BranchImpl());
        Root root = new RootImpl(10);
        Trunk trunk = new TrunkImpl(7);

        //All natural Trees - Tree interface
        Tree normalTree = new NormalTree(root, trunk, branches);
        normalTree.grow();
        normalTree.cut();

        //All deciduous trees - DeciduousTree interface
        List<Leaf> leaves = List.of(new LeafImpl(500));
        DeciduousTree deciduousTree = new OakTree(root, trunk, branches, leaves);
        deciduousTree.grow();
        deciduousTree.produceLeaf();
        deciduousTree.removeLeaf();
        deciduousTree.cut();

        //All coniferous trees - ConiferousTree interface
        List<Cone> cones = List.of(new ConeImpl(100));
        List<Needle> needles = List.of(new NeedleImpl(), new NeedleImpl());
        ConiferousTree coniferousTree = new SpruceTree(root, trunk, branches, needles, cones);
        coniferousTree.grow();
        coniferousTree.produceCone();
        coniferousTree.produceNeedles();
        coniferousTree.removeNeedles();
        coniferousTree.cut();
    }

}
