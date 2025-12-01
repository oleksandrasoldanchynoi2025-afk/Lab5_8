package com.itproger.command;
import com.itproger.Disk;

public class AddCompositionCommand implements Command {
    private Disk disk;
    public AddCompositionCommand(Disk disk) { this.disk = disk; }
    @Override
    public void execute() { disk.addComposition(); }

    @Override
    public String getDesc() {
        return "Add Composition ";
    }
}