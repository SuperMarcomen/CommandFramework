package it.marcodemartino.teams.commands;

import org.bukkit.command.CommandSender;

public class HelloCommand extends CommandClass {

    public HelloCommand() {
        super("hello");
    }

    @Override
    public void executeCommand(CommandSender sender, String[] args) {

        sender.sendMessage("Hello World");

    }

}
