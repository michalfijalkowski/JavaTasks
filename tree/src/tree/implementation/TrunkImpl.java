package tree.implementation;

import tree.components.Trunk;

public class TrunkImpl implements Trunk {
    private int length;

    public TrunkImpl(int length){
        this.length = length;
    }

    @Override
    public int getLength() {
        return this.length;
    }
}
