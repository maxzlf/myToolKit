package com.zhulinfeng.toolkit.impl;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.CommandKeyWords;
import com.zhulinfeng.toolkit.api.FetchCommand;
import com.zhulinfeng.toolkit.exceptions.CommandNotFoundException;
import com.zhulinfeng.toolkit.impl.commands.basic.Exit;
import com.zhulinfeng.toolkit.impl.commands.basic.Help;
import com.zhulinfeng.toolkit.impl.commands.basic.NewLine;
import com.zhulinfeng.toolkit.impl.commands.basic.Quit;
import com.zhulinfeng.toolkit.impl.commands.constant.InfoOfAllBasicType;
import com.zhulinfeng.toolkit.impl.commands.constant.InfoOfByte;
import com.zhulinfeng.toolkit.impl.commands.constant.InfoOfChar;
import com.zhulinfeng.toolkit.impl.commands.constant.InfoOfDouble;
import com.zhulinfeng.toolkit.impl.commands.constant.InfoOfFloat;
import com.zhulinfeng.toolkit.impl.commands.constant.InfoOfInt;
import com.zhulinfeng.toolkit.impl.commands.constant.InfoOfLong;
import com.zhulinfeng.toolkit.impl.commands.constant.InfoOfShort;
import com.zhulinfeng.toolkit.impl.commands.constant.MaxValueOfByte;
import com.zhulinfeng.toolkit.impl.commands.constant.MaxValueOfChar;
import com.zhulinfeng.toolkit.impl.commands.constant.MaxValueOfDouble;
import com.zhulinfeng.toolkit.impl.commands.constant.MaxValueOfFloat;
import com.zhulinfeng.toolkit.impl.commands.constant.MaxValueOfInt;
import com.zhulinfeng.toolkit.impl.commands.constant.MaxValueOfLong;
import com.zhulinfeng.toolkit.impl.commands.constant.MaxValueOfShort;
import com.zhulinfeng.toolkit.impl.commands.constant.MinValueOfByte;
import com.zhulinfeng.toolkit.impl.commands.constant.MinValueOfChar;
import com.zhulinfeng.toolkit.impl.commands.constant.MinValueOfDouble;
import com.zhulinfeng.toolkit.impl.commands.constant.MinValueOfFloat;
import com.zhulinfeng.toolkit.impl.commands.constant.MinValueOfInt;
import com.zhulinfeng.toolkit.impl.commands.constant.MinValueOfLong;
import com.zhulinfeng.toolkit.impl.commands.constant.MinValueOfShort;
import com.zhulinfeng.toolkit.impl.commands.constant.SizeOfByte;
import com.zhulinfeng.toolkit.impl.commands.constant.SizeOfChar;
import com.zhulinfeng.toolkit.impl.commands.constant.SizeOfDouble;
import com.zhulinfeng.toolkit.impl.commands.constant.SizeOfFloat;
import com.zhulinfeng.toolkit.impl.commands.constant.SizeOfInt;
import com.zhulinfeng.toolkit.impl.commands.constant.SizeOfLong;
import com.zhulinfeng.toolkit.impl.commands.constant.SizeOfShort;
import com.zhulinfeng.toolkit.impl.commands.convert.IntToAsciiChar;
import com.zhulinfeng.toolkit.impl.commands.convert.IntToBinary;
import com.zhulinfeng.toolkit.impl.commands.convert.IntToHex;
import com.zhulinfeng.toolkit.impl.commands.convert.Ipv4IntValueToString;
import com.zhulinfeng.toolkit.impl.commands.convert.Ipv4StringValueToInt;
import com.zhulinfeng.toolkit.impl.commands.convert.Ipv4StringValueToUInt;
import com.zhulinfeng.toolkit.impl.commands.convert.StringToBinary;
import com.zhulinfeng.toolkit.impl.commands.convert.StringToHex;
import com.zhulinfeng.toolkit.impl.commands.convert.ValueOfAsciiChar;

import java.util.ArrayList;
import java.util.HashMap;

import static com.zhulinfeng.toolkit.api.CommandKeyWords.ALL;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.ARG;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.ASCII;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.BASIC;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.BINARY;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.BYTE;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.CHAR;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.DOUBLE;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.EXIT;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.FLOAT;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.HELP;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.HEX;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.INFO;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.INT;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.IPV4;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.LONG;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.MAX;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.MIN;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.NEWLINE;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.OF;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.QUIT;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.SHORT;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.SIZE;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.STRING;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.TO;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.TYPE;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.UNSIGNED;
import static com.zhulinfeng.toolkit.api.CommandKeyWords.VALUE;

public class CommandLineFetcher implements FetchCommand {
    private HashMap<Long, Command> commandMap = new HashMap<>();
    private ArrayList<Command> commandArray = new ArrayList<>();

    public CommandLineFetcher() {
        init();
    }

    private void init() {
        initBasic();
        initConstant();
        initConvert();
    }

    private void initBasic() {
        {
            CommandKeyWords[] k = {EXIT};
            CommandLine c = new CommandLine(k, Exit.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {QUIT};
            CommandLine c = new CommandLine(k, Quit.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {HELP};
            CommandLine c = new CommandLine(k, Help.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {NEWLINE};
            CommandLine c = new CommandLine(k, NewLine.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
    }

    private void initConstant() {
        {
            CommandKeyWords[] k = {MIN, VALUE, OF, CHAR};
            CommandLine c = new CommandLine(k, MinValueOfChar.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {MAX, VALUE, OF, CHAR};
            CommandLine c = new CommandLine(k, MaxValueOfChar.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {SIZE, OF, CHAR};
            CommandLine c = new CommandLine(k, SizeOfChar.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }

        {
            CommandKeyWords[] k = {MIN, VALUE, OF, BYTE};
            CommandLine c = new CommandLine(k, MinValueOfByte.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {MAX, VALUE, OF, BYTE};
            CommandLine c = new CommandLine(k, MaxValueOfByte.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {SIZE, OF, BYTE};
            CommandLine c = new CommandLine(k, SizeOfByte.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }

        {
            CommandKeyWords[] k = {MIN, VALUE, OF, SHORT};
            CommandLine c = new CommandLine(k, MinValueOfShort.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {MAX, VALUE, OF, SHORT};
            CommandLine c = new CommandLine(k, MaxValueOfShort.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {SIZE, OF, SHORT};
            CommandLine c = new CommandLine(k, SizeOfShort.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }

        {
            CommandKeyWords[] k = {MIN, VALUE, OF, INT};
            CommandLine c = new CommandLine(k, MinValueOfInt.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {MAX, VALUE, OF, INT};
            CommandLine c = new CommandLine(k, MaxValueOfInt.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {SIZE, OF, INT};
            CommandLine c = new CommandLine(k, SizeOfInt.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }

        {
            CommandKeyWords[] k = {MIN, VALUE, OF, LONG};
            CommandLine c = new CommandLine(k, MinValueOfLong.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {MAX, VALUE, OF, LONG};
            CommandLine c = new CommandLine(k, MaxValueOfLong.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {SIZE, OF, LONG};
            CommandLine c = new CommandLine(k, SizeOfLong.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }

        {
            CommandKeyWords[] k = {MIN, VALUE, OF, FLOAT};
            CommandLine c = new CommandLine(k, MinValueOfFloat.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {MAX, VALUE, OF, FLOAT};
            CommandLine c = new CommandLine(k, MaxValueOfFloat.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {SIZE, OF, FLOAT};
            CommandLine c = new CommandLine(k, SizeOfFloat.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }

        {
            CommandKeyWords[] k = {MIN, VALUE, OF, DOUBLE};
            CommandLine c = new CommandLine(k, MinValueOfDouble.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {MAX, VALUE, OF, DOUBLE};
            CommandLine c = new CommandLine(k, MaxValueOfDouble.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {SIZE, OF, DOUBLE};
            CommandLine c = new CommandLine(k, SizeOfDouble.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }

        {
            CommandKeyWords[] k = {INFO, OF, CHAR};
            CommandLine c = new CommandLine(k, InfoOfChar.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {INFO, OF, BYTE};
            CommandLine c = new CommandLine(k, InfoOfByte.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {INFO, OF, SHORT};
            CommandLine c = new CommandLine(k, InfoOfShort.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {INFO, OF, INT};
            CommandLine c = new CommandLine(k, InfoOfInt.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {INFO, OF, LONG};
            CommandLine c = new CommandLine(k, InfoOfLong.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {INFO, OF, FLOAT};
            CommandLine c = new CommandLine(k, InfoOfFloat.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {INFO, OF, DOUBLE};
            CommandLine c = new CommandLine(k, InfoOfDouble.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {INFO, OF, ALL, BASIC, TYPE};
            CommandLine c = new CommandLine(k, InfoOfAllBasicType.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
    }

    private void initConvert() {
        {
            CommandKeyWords[] k = {INT, VALUE, ARG, TO, BINARY};
            CommandLine c = new CommandLine(k, IntToBinary.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {INT, VALUE, ARG, TO, HEX};
            CommandLine c = new CommandLine(k, IntToHex.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {STRING, VALUE, ARG, TO, BINARY};
            CommandLine c = new CommandLine(k, StringToBinary.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {STRING, VALUE, ARG, TO, HEX};
            CommandLine c = new CommandLine(k, StringToHex.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {INT, VALUE, ARG, TO, ASCII, CHAR};
            CommandLine c = new CommandLine(k, IntToAsciiChar.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {VALUE, OF, ASCII, CHAR, ARG};
            CommandLine c = new CommandLine(k, ValueOfAsciiChar.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        /*----------------------------------------------------------------*/
        {
            CommandKeyWords[] k = {IPV4, INT, VALUE, ARG, TO, STRING};
            CommandLine c = new CommandLine(k, Ipv4IntValueToString.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {IPV4, STRING, VALUE, ARG, TO, INT};
            CommandLine c = new CommandLine(k, Ipv4StringValueToInt.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
        {
            CommandKeyWords[] k = {IPV4, STRING, VALUE, ARG, TO, UNSIGNED, INT};
            CommandLine c = new CommandLine(k, Ipv4StringValueToUInt.class);
            commandMap.put(c.getCommandIndex(), c);
            commandArray.add(c);
        }
    }

    public Command getCommand(long commandIndex) throws CommandNotFoundException {
        Command command = commandMap.get(commandIndex);
        if (null == command) {
            throw new CommandNotFoundException();
        }
        return command;
    }

    public String getHelp() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Command command : commandArray) {
            stringBuilder.append(command.help());
        }
        return stringBuilder.toString();
    }
}
