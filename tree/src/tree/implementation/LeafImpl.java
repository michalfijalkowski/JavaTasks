package tree.implementation;

import tree.deciduous.components.Leaf;

public class LeafImpl implements Leaf {

    private int leafCount;

    public LeafImpl(int leafCount){
        this.leafCount = leafCount;
    }

    @Override
    public int getLeafCount() {
        return this.leafCount;
    }
}
