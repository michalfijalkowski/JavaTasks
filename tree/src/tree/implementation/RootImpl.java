package tree.implementation;

import tree.components.Root;

public class RootImpl implements Root {

    private int size;

    public RootImpl(int size){
        this.size = size;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
