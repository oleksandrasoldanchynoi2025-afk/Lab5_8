package com.itproger.command;
import com.itproger.Disk;

public class RemoveDiskCommand implements Command {
    private Disk disk;

    public RemoveDiskCommand(Disk disk) {
        this.disk = disk;
    }

    @Override
    public void execute() {
        disk.removeDisk();
    }

    @Override
    public String getDesc() {
        return "Видалити диск";
    }
}