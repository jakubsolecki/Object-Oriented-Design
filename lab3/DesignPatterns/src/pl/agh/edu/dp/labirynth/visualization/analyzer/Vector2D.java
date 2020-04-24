package pl.agh.edu.dp.labirynth.visualization.analyzer;

public class Vector2D {
    private int X;
    private int Y;

    public Vector2D(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public String toString() {
        return "(" + X + ", " + Y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2D vector2D = (Vector2D) o;
        return X == vector2D.X &&
                Y == vector2D.Y;
    }

    public Vector2D lowerLeft(Vector2D other){
        int x;
        int y;

        x = Math.min(this.getX(), other.getX());
        y = Math.min(this.getY(), other.getY());
        return new Vector2D(x, y);
    }

    public Vector2D upperRight(Vector2D other){
        int x;
        int y;

        x = Math.max(this.getX(), other.getX());
        y = Math.max(this.getY(), other.getY());
        return new Vector2D(x, y);
    }



    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public void setXY(Vector2D v){
        Y = v.Y;
        X = v.X;
    }

    public Vector2D diff(Vector2D other){
        return new Vector2D(this.X - other.X, this.Y - other.Y);
    }
}
