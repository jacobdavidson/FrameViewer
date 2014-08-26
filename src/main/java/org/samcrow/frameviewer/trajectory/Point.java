package org.samcrow.frameviewer.trajectory;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.samcrow.frameviewer.FrameObject;

/**
 * A point in a trajectory
 * @author Sam Crow
 */
public class Point extends FrameObject {

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the activity
     */
    public Activity getActivity() {
        return activity;
    }

    /**
     * @param activity the activity to set
     */
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public static enum Activity {
        NotCarrying,
        CarryingFood,
        CarryingSomethingElse,
    }
    
    private int x;

    private int y;
    
    private Activity activity;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Constructs a copy of another point
     * @param other 
     */
    public Point(Point other) {
        super(other);
        this.x = other.x;
        this.y = other.y;
        this.activity = other.activity;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.x;
        hash = 31 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point other = (Point) obj;
        if (this.x != other.x) {
            return false;
        }
        return this.y == other.y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    
    public void paint(GraphicsContext gc, double canvasX, double canvasY, boolean hilighted) {
        final int RADIUS = 3;
        if(hilighted) {
            gc.setStroke(Color.RED);
        }
        else {
            gc.setStroke(Color.LIGHTGREEN);
        }
        gc.setLineWidth(2);
        gc.strokeOval(canvasX - RADIUS, canvasY - RADIUS, 2 * RADIUS, 2 * RADIUS);
    }
}
