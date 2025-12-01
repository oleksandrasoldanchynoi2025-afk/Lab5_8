package com.itproger.command;
import com.itproger.Disk;

    public class SortByStyleCommand implements Command {
        private Disk disk;
        public SortByStyleCommand(Disk disk) { this.disk = disk; }
        @Override
        public void execute() { disk.sortByStyle(); }

        @Override
        public String getDesc() {
            return "Sort by Style ";
        }
    }

