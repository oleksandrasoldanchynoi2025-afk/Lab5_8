package com.itproger.command;
import com.itproger.Disk;

public class FindByArtistCommand implements Command {
    private Disk disk;
    public FindByArtistCommand(Disk disk) { this.disk = disk; }
    @Override
    public void execute() { disk.findByArtist(); }

    @Override
    public String getDesc() {
        return "Find by Artist";
    }
}
