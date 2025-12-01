package com.itproger.command;
import com.itproger.Disk;

public class FindByDurationRangeCommand implements Command {
    private Disk disk;
    public FindByDurationRangeCommand(Disk disk) { this.disk = disk; }
    @Override
    public void execute() { disk.findByDurationRange(); }

    @Override
    public String getDesc() {
        return "Fin by Duration Range ";
    }
}
