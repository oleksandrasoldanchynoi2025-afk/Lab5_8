package com.itproger.command;
import com.itproger.Disk;

public class SelectDiskCommand implements Command {
    private Disk disk;

    public SelectDiskCommand(Disk disk) {
        this.disk = disk;
    }

    @Override
    public void execute() {
        disk.switchDisk();
    }

    @Override
    public String getDesc() {
        return "Змінити активний диск";
    }
}