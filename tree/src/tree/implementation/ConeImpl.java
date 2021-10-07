package tree.implementation;

import tree.coniferous.components.Cone;

public class ConeImpl implements Cone {
    private int size;

    public ConeImpl(int size){
        this.size = size;
    }
    @Override
    public int getSize() {
        return this.size;
    }
}
