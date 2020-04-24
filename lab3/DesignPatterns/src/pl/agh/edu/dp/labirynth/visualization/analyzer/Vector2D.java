package pl.agh.edu.dp.labirynth.visualization.analyzer;

public class Vector2D {
    private final int X;
    private final int Y;

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

}
