package sathvik1709.com.tictactoe.objects;

/**
 * Created by Sathvik on 18/07/15.
 */
public class Cell {

    int id;
    boolean selected;
    int selectedByPlayer;

    public Cell(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getSelectedByPlayer() {
        return selectedByPlayer;
    }

    public void setSelectedByPlayer(int selectedByPlayer) {
        this.selectedByPlayer = selectedByPlayer;
    }
}
