package control;

import model.Block;

public class DownCommand implements Command {
    private final Block block;

    public DownCommand(Block block) {
        this.block = block;
    }
    
    @Override
    public void execute() {
        block.down();
    }
}
