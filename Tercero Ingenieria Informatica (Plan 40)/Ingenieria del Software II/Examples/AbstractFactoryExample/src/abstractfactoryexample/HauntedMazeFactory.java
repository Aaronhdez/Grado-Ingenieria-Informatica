/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactoryexample;

/**
 *
 * @author Usuario
 */
public class HauntedMazeFactory extends MazeFactory {

    public HauntedMazeFactory() {
    }
    
        
    //makeMaze de clase
    public Maze makeMaze(){
        Maze maze = new Maze();
        return maze;
    }
    
    @Override
    public Compartment makeCompartment(){
        Compartment compartment = new Compartment();
        return compartment;
    }
    
    public HauntedRoom makeRoom(Spell spell, int roomNumber){
        HauntedRoom room = new HauntedRoom(spell, roomNumber);
        return room;    
    }
    
    @Override
    public Door makeDoor(DOOR_STATUS status, Compartment comp1, Compartment comp2){
        Door door = new Door(status, comp1, comp2);
        return door;     
    }
    
    @Override
    public Wall makeWall(Compartment comp1, Compartment comp2){
        Wall wall = new Wall(comp1, comp2);
        return wall;     
    }
}
