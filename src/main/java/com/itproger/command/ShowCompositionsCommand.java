package com.itproger.command;
import com.itproger.Disk;

public class ShowCompositionsCommand implements Command {
    private Disk disk;
    public ShowCompositionsCommand(Disk disk) { this.disk = disk; }
    @Override
    public void execute() { disk.showCompositions(); }

    @Override
    public String getDesc() {
        return "Show Compositions ";
    }
}
