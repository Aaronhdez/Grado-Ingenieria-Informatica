package abstractfactoryexample;

public class MazeFactory {

    public MazeFactory() {
    }
    
    //makeMaze de clase
    public Maze makeStandardMaze(){
        Maze maze = new Maze();
        return maze;
    }
    
    public Compartment makeCompartment(){
        Compartment compartment = new Compartment();
        return compartment;
    }
    
    public Room makeRoom(int roomNumber){
        Room room = new Room(roomNumber);
        return room;    
    }
    
    public Door makeDoor(DOOR_STATUS status, Compartment comp1, Compartment comp2){
        Door door = new Door(status, comp1, comp2);
        return door;     
    }
    
    public Wall makeWall(Compartment comp1, Compartment comp2){
        Wall wall = new Wall(comp1, comp2);
        return wall;     
    }
}
