package abstractfactoryexample;


public class MazeGame {
    public static void main(String[] args) {
        Maze mazeWithoutFactory = createMaze();
        
        Maze mazeWithFactory = createMaze(new MazeFactory());
        
        Maze hauntedMazeWithFactory = createMaze(new HauntedMazeFactory());
    }
    
    // Maze creado sin uso de Factory
    private static Maze createMaze(){
        Maze maze = new Maze();
        Compartment outSideWorld = new Compartment();
        
        Room room23 = new Room(23);
        room23.setBorder(DIRECTION.NORTH, outSideWorld);
        room23.setBorder(DIRECTION.SOUTH, outSideWorld);
        room23.setBorder(DIRECTION.WEST, outSideWorld);
        
        Room room25 = new Room(25);
        room23.setBorder(DIRECTION.NORTH, outSideWorld);
        room23.setBorder(DIRECTION.SOUTH, outSideWorld);
        room23.setBorder(DIRECTION.EAST, outSideWorld);
        
        Door door = new Door(DOOR_STATUS.OPEN, room23, room25);
        
        maze.addCompartment(outSideWorld);
        maze.addCompartment(room23);
        maze.addCompartment(room25);
        maze.addCompartment(door);
        
        return maze;
    }
    
    // Maze creado con MazeFactory
    private static Maze createMaze(MazeFactory mazeFactory){
        Maze maze = mazeFactory.makeStandardMaze();
        Compartment outSideWorld = mazeFactory.makeCompartment();
        
        Room room23 = mazeFactory.makeRoom(23);
        room23.setBorder(DIRECTION.NORTH, outSideWorld);
        room23.setBorder(DIRECTION.SOUTH, outSideWorld);
        room23.setBorder(DIRECTION.WEST, outSideWorld);
        
        Room room25 = mazeFactory.makeRoom(25);
        room23.setBorder(DIRECTION.NORTH, outSideWorld);
        room23.setBorder(DIRECTION.SOUTH, outSideWorld);
        room23.setBorder(DIRECTION.EAST, outSideWorld);
        
        Door door = mazeFactory.makeDoor(DOOR_STATUS.OPEN, room23, room25);
        
        maze.addCompartment(outSideWorld);
        maze.addCompartment(room23);
        maze.addCompartment(room25);
        maze.addCompartment(door);
        
        return maze;
    }
    
    //HuantedMazeFactory con HauntedMazeFactory
    private static Maze createMaze(HauntedMazeFactory mazeFactory){
        Maze maze = mazeFactory.makeStandardMaze();
        Compartment outSideWorld = mazeFactory.makeCompartment();
        
        HauntedRoom hauntedRoom23 = mazeFactory.makeRoom(null,23);
        hauntedRoom23.setBorder(DIRECTION.NORTH, outSideWorld);
        hauntedRoom23.setBorder(DIRECTION.SOUTH, outSideWorld);
        hauntedRoom23.setBorder(DIRECTION.WEST, outSideWorld);
        
        HauntedRoom hauntedRoom25 = mazeFactory.makeRoom(null,25);
        hauntedRoom25.setBorder(DIRECTION.NORTH, outSideWorld);
        hauntedRoom25.setBorder(DIRECTION.SOUTH, outSideWorld);
        hauntedRoom25.setBorder(DIRECTION.EAST, outSideWorld);
        
        Door door = mazeFactory.makeDoor(DOOR_STATUS.OPEN, hauntedRoom23, hauntedRoom25);
        
        maze.addCompartment(outSideWorld);
        maze.addCompartment(hauntedRoom23);
        maze.addCompartment(hauntedRoom25);
        maze.addCompartment(door);
        
        return maze;
    }
}
