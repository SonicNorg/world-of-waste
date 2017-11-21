package com.norg.worldofwaste.actions;

public class MultiplyAction extends AbstractAction {
    @Override
    public double result(boolean reverse) {
        return reverse ? modifiable / modifier : modifiable * modifier ;
    }
}
