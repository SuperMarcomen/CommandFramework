package it.marcodemartino.teams.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class CommandManager implements CommandExecutor {

    private Map<String, CommandClass> commands = new HashMap<>();

    public void registerCommand(String commandName, CommandClass cmd) {
        commands.put(commandName, cmd);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        CommandClass commandClass = commands.get(cmd.getName().toLowerCase());
        if (commandClass != null){
            commandClass.execute(sender, args);
            return true;
        }

        return false;
    }
}
