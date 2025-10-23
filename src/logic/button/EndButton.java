package logic.button;

import logic.GameState;

//end button
public abstract class EndButton extends Button {
    public EndButton(double x, double y, int z, double width, int height) {
        super(x, y, z, width, height);
    }


    @Override
    public boolean isVisible() {
        return GameState.state == GameState.END;
    }
}
