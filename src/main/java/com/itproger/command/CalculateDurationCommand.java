package com.itproger.command;
import com.itproger.Disk;

public class CalculateDurationCommand implements Command {
    private Disk disk;
    public CalculateDurationCommand(Disk disk) { this.disk = disk; }
    @Override
    public void execute() { disk.calculateDuration(); }

    @Override
    public String getDesc() {
        return "Calculate Duration ";
    }
}