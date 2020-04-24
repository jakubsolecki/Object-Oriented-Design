package pl.agh.edu.dp.labirynth.visualization.analyzer;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.Door;
import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MazeAnalyzer {
    private final Maze maze;
    private final Vector2D[]positionTable;

    public MazeAnalyzer(Maze maze) {
        this.maze = maze;
        this.positionTable = new Vector2D[maze.getRoomNumbers()];
    }

    private void BFS(){
        boolean []visited = new boolean[maze.getRoomNumbers()];
        LinkedList<Room> queue = new LinkedList<Room>();
        LinkedList<Vector2D> vQueue = new LinkedList<Vector2D>();
        int currentX = 0;
        int currentY = 0;
        vQueue.add(new Vector2D(currentX, currentY));

        Room currentRoom = maze.getFirstRoom();
        this.positionTable[currentRoom.getRoomNumber()] = new Vector2D(currentX, currentY);


        visited[currentRoom.getRoomNumber()] = true;
        queue.add(currentRoom);
        while (queue.size() != 0){
            currentRoom = queue.poll();
            Vector2D vector2D = vQueue.poll();
            currentX = vector2D.getX();
            currentY = vector2D.getY();
            this.positionTable[currentRoom.getRoomNumber()] = new Vector2D(currentX, currentY);


            for (Direction dir : Direction.values()){
                if (currentRoom.getSide(dir) instanceof Door){
                    Door door = (Door) currentRoom.getSide(dir);
                    if (door.getRoom2() == currentRoom && !visited[door.getRoom1().getRoomNumber()]){
                        visited[currentRoom.getRoomNumber()] = true;
                        queue.add(door.getRoom1());
                        Vector2D dirVector = dir.toVector();
                        vQueue.add(new Vector2D(currentX + dirVector.getX(), currentY + dirVector.getY()));
                        continue;
                    }
                    if (door.getRoom1() == currentRoom && !visited[door.getRoom2().getRoomNumber()]){
                        visited[currentRoom.getRoomNumber()] = true;
                        queue.add(door.getRoom2());
                        Vector2D dirVector = dir.toVector();
                        vQueue.add(new Vector2D(currentX + dirVector.getX(), currentY + dirVector.getY()));
                    }
                }
            }
        }
    }

    private List<Vector2D> mapToLeftDown(List<Vector2D> list){
        Vector2D downLeft = new Vector2D(Integer.MAX_VALUE, Integer.MAX_VALUE);

        list.forEach(vector2D -> downLeft.setXY(vector2D.lowerLeft(downLeft)));
        list = list.stream().map(vector2D -> vector2D.diff(downLeft)).collect(Collectors.toList());

        return list;
    }

    public List<Vector2D> getPositionList() {
        BFS();
        return mapToLeftDown(new ArrayList<>(Arrays.asList(this.positionTable)));
    }
}
