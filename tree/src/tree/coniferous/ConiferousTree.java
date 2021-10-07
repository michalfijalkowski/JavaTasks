package tree.coniferous;

import tree.Tree;
import tree.coniferous.components.Cone;
import tree.coniferous.components.Needle;

import java.util.List;

public interface ConiferousTree extends Tree {

    void produceNeedles();

    void removeNeedles();

    List<Needle> getNeedles();

    void produceCone();

    void removeCone();

    List<Cone> getCones();
}
