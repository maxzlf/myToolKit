package com.zhulinfeng.toolkit;

import com.zhulinfeng.toolkit.api.Command;
import com.zhulinfeng.toolkit.api.CommandExplain;
import com.zhulinfeng.toolkit.api.ExecuteOutput;
import com.zhulinfeng.toolkit.api.ExplainResult;
import com.zhulinfeng.toolkit.api.FetchCommand;
import com.zhulinfeng.toolkit.exceptions.CommandNotFoundException;
import com.zhulinfeng.toolkit.exceptions.ExitException;
import com.zhulinfeng.toolkit.exceptions.KeyWordNotFoundException;
import com.zhulinfeng.toolkit.impl.CommandExplainer;
import com.zhulinfeng.toolkit.impl.CommandLineFetcher;
import com.zhulinfeng.toolkit.impl.commands.basic.WelCome;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Start {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private final FetchCommand commandFetcher = new CommandLineFetcher();
    private final CommandExplain explainer = new CommandExplainer();

    public void start() {
        welcome();
        while (run());
    }

    private void welcome() {
        System.out.print(new WelCome().execute(new ArrayList<String>()).getOutput());
    }

    private boolean run() {
        boolean result = true;

        try {
            ExplainResult explainResult = explainer.explain(reader.readLine());
            Command command = commandFetcher.getCommand(explainResult.getCommandIndex());
            ExecuteOutput output = command.execute(explainResult.getArgs());
            System.out.print(output.getOutput());
        } catch (KeyWordNotFoundException | CommandNotFoundException e) {
            System.out.print(e.getMessage());
        } catch (ExitException e) {
            System.out.print(e.getMessage());
            result = false;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
