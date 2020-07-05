package it.marcodemartino.teams.commands;

import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public abstract class CommandClass {

    private String name;
    private Map<String, CommandClass> subCommands = new HashMap<>();

    public CommandClass(String name) {
        this.name = name;
    }

    public void registerCommand(String commandName, CommandClass cmd) {
        subCommands.put(commandName, cmd);
    }

    public String getName() {
        return name;
    }

    public void execute(CommandSender sender, String[] args) {
        CommandClass subCommandClass = subCommands.get(args[0].toLowerCase());
        if (subCommandClass != null) {
            subCommandClass.execute(sender, args);
        }

        executeCommand(sender, args);
    }

    public abstract void executeCommand(CommandSender sender, String[] args);

}

