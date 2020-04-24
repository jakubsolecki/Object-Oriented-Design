package pl.agh.edu.dp.labirynth;

public class Player {
    private Room currentRoom;

    public Player(Maze maze){
        this.currentRoom = maze.getFirstRoom();
    }

    public void move(Direction direction){
        MapSite site = currentRoom.getSide(direction);
        site.Enter();
        if (site instanceof Door){
            Room nextRoom = null;
            if (currentRoom == ((Door) site).getRoom1()){
                nextRoom = ((Door) site).getRoom2();
            } else {
                nextRoom = ((Door) site).getRoom1();
            }
            nextRoom.Enter();
            System.out.println("Moved from " + currentRoom.getRoomNumber() + " to " +
                    nextRoom.getRoomNumber());
            this.currentRoom = nextRoom;
        }
    }
}
