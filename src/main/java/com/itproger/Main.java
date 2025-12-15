package com.itproger;
import com.itproger.command.*;

public class Main {
    public static void main(String[] args) {
        Disk disk = new Disk();
        Menu menu = new Menu();

        menu.setCommand(1, new AddCompositionCommand(disk));
        menu.setCommand(2, new ShowCompositionsCommand(disk));
        menu.setCommand(3, new CalculateDurationCommand(disk));
        menu.setCommand(4, new SortByStyleCommand(disk));
        menu.setCommand(5, new FindByArtistCommand(disk));
        menu.setCommand(6, new FindByDurationRangeCommand(disk));
        menu.setCommand(7, new SelectDiskCommand(disk));
        menu.setCommand(8, new CreateDiskCommand(disk));
        menu.setCommand(9, new RemoveDiskCommand(disk));
        menu.show();
    }
}