package com.itproger.command;
import com.itproger.Disk;

public class CreateDiskCommand implements Command {
    private Disk disk;

    public CreateDiskCommand(Disk disk) {
        this.disk = disk;
    }

    @Override
    public void execute() {
        disk.createDisk();
    }

    @Override
    public String getDesc() {
        return "Створити новий диск";
    }
}