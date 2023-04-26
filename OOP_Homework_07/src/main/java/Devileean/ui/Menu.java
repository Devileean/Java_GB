package Devileean.ui;

import java.util.ArrayList;
import java.util.List;
import Devileean.ui.commands.AddHuman;
import Devileean.ui.commands.Exit;
import Devileean.ui.commands.FamilyPrint;
import Devileean.ui.commands.HumanSearch;
import Devileean.ui.commands.Load;
import Devileean.ui.commands.Option;
import Devileean.ui.commands.SaveFamily;
import Devileean.ui.commands.SortName;
import Devileean.ui.commands.SortAge;

public class Menu 
{
    private List<Option> commands;
    private Console console;

    public Menu(Console console) 
    {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new AddHuman(console));
        commands.add(new FamilyPrint(console));
        commands.add(new HumanSearch(console));
        commands.add(new SortName(console));
        commands.add(new SortAge(console));
        commands.add(new SaveFamily(console));
        commands.add(new Load(console));
        commands.add(new Exit(console));
    }

    void execute(int num)
    {
        Option option = commands.get(num-1);
        option.execute();
    }

    public String printMenu()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n\t- =  Меню  = -\n\n");
        for (int i = 0; i < commands.size(); i++) 
        {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    
    public Console getConsole() 
    {
        return console;
    }
}

