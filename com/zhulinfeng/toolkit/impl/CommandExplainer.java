package com.zhulinfeng.toolkit.impl;

import com.zhulinfeng.toolkit.api.CommandExplain;
import com.zhulinfeng.toolkit.api.CommandKeyWords;
import com.zhulinfeng.toolkit.api.ExplainResult;
import com.zhulinfeng.toolkit.exceptions.CommandNotFoundException;
import com.zhulinfeng.toolkit.exceptions.KeyWordNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandExplainer implements CommandExplain {
    private HashMap<String, CommandKeyWords> commandMap = new HashMap<>();

    public CommandExplainer() {
        init();
    }

    private void init() {
        for (CommandKeyWords commandKeyWord : CommandKeyWords.values()) {
            commandMap.put(commandKeyWord.getKeyWord(), commandKeyWord);
        }
    }

    public ExplainResult explain(String commandLine) throws KeyWordNotFoundException, CommandNotFoundException{
        class Explainer {
            private String[] keyWords;

            public Explainer(String commandLine) {
                keyWords = commandLine.split("\\s+");
            }

            public ExplainResult explain() throws KeyWordNotFoundException, CommandNotFoundException {
                if (isCommandLineTooLong()) {
                    throw new CommandNotFoundException();
                } else {
                    if (isCommandLineEmpty()) {
                        return explainEmptyCommand();
                    } else {
                        return explainNormalCommand();
                    }
                }
            }

            private boolean isCommandLineTooLong() {
                return keyWords.length > Long.SIZE / Byte.SIZE;
            }

            private boolean isCommandLineEmpty() {
                return 0 == keyWords.length;
            }

            private ExplainResult explainEmptyCommand() {
                long commandIndex = CommandKeyWords.NEWLINE.getCommandIndex();
                ArrayList<String> args = new ArrayList<>();
                return new ExplainResult(commandIndex, args);
            }

            private ExplainResult explainNormalCommand() throws KeyWordNotFoundException {
                long commandIndex = 0;
                ArrayList<String> args = new ArrayList<>();

                for (String keyWord : keyWords) {
                    commandIndex <<= Byte.SIZE;
                    if (isArgument(keyWord)) {
                        commandIndex += CommandKeyWords.ARG.getCommandIndex();
                        args.add(extractArg(keyWord));
                    } else {
                        commandIndex += getCommandIndexByWord(keyWord);
                    }
                }

                return new ExplainResult(commandIndex, args);
            }
        }

        return new Explainer(commandLine).explain();
    }

    private Long getCommandIndexByWord(String keyWord) throws KeyWordNotFoundException {
        CommandKeyWords commandKeyWords = commandMap.get(keyWord);
        if (null == commandKeyWords) {
            throw new KeyWordNotFoundException(keyWord);
        }
        return commandKeyWords.getCommandIndex();
    }

    private boolean isArgument(String keyWord) {
        Matcher argMatcher = Pattern.compile("\\[[^\\s]+\\]").matcher(keyWord);
        return argMatcher.matches();
    }

    private String extractArg(String keyWord) {
        return keyWord.substring(1, keyWord.length()-1);
    }
}
