/*
 * This file is a part of BSL Language Server.
 *
 * Copyright © 2018-2020
 * Alexey Sosnoviy <labotamy@gmail.com>, Nikita Gryzlov <nixel2007@gmail.com> and contributors
 *
 * SPDX-License-Identifier: LGPL-3.0-or-later
 *
 * BSL Language Server is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * BSL Language Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with BSL Language Server.
 */
package com.github._1c_syntax.bsl.languageserver;

import com.github._1c_syntax.bsl.languageserver.cli.AnalyzeCommand;
import com.github._1c_syntax.bsl.languageserver.cli.FormatCommand;
import com.github._1c_syntax.bsl.languageserver.cli.LanguageServerStartCommand;
import com.github._1c_syntax.bsl.languageserver.cli.VersionCommand;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParameterException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import static picocli.CommandLine.Command;

@Command(
  name = "bsl-language-server",
  subcommands = {
    AnalyzeCommand.class,
    FormatCommand.class,
    VersionCommand.class,
    LanguageServerStartCommand.class
  },
  usageHelpAutoWidth = true,
  synopsisSubcommandLabel = "[COMMAND [ARGS]]",
  footer = "@|green Copyright(c) 2018-2020|@",
  header = "@|green BSL language server|@")
@SpringBootApplication
@Component
@RequiredArgsConstructor
public class BSLLSPLauncher implements Callable<Integer>, CommandLineRunner, ExitCodeGenerator {

  private static final String DEFAULT_COMMAND = "lsp";

  @Option(
    names = {"-h", "--help"},
    usageHelp = true,
    description = "Show this help message and exit")
  private boolean usageHelpRequested;

  @Option(
    names = {"-c", "--configuration"},
    description = "Path to language server configuration file",
    paramLabel = "<path>",
    defaultValue = "")
  private String configurationOption;

  private final CommandLine.IFactory picocliFactory;

  private int exitCode;

  public static void main(String[] args) {
    var applicationContext = SpringApplication.run(BSLLSPLauncher.class, args);
    var launcher = applicationContext.getBean(BSLLSPLauncher.class);
    if (launcher.getExitCode() >= 0) {
      System.exit(
        SpringApplication.exit(applicationContext)
      );
    }
  }

  @Override
  public void run(String[] args) {
    var cmd = new CommandLine(this, picocliFactory);

    // проверка использования дефолтной команды
    // если строка параметров пуста, то это точно вызов команды по умолчанию
    if (args.length == 0) {
      args = addDefaultCommand(args);
    } else {
      // выполнение проверки строки запуска в попытке, т.к. парсер при нахождении
      // неизвестных параметров выдает ошибку
      try {
        var parseResult = cmd.parseArgs(args);
        // если переданы параметры без команды и это не справка
        // то считаем, что параметры для команды по умолчанию
        if (!parseResult.hasSubcommand() && !parseResult.isUsageHelpRequested()) {
          args = addDefaultCommand(args);
        }
      } catch (ParameterException ex) {
        // если поймали ошибку, а имя команды не передано, подставим команду и посмотрим,
        // вдруг заработает
        if (!ex.getCommandLine().getParseResult().hasSubcommand()) {
          args = addDefaultCommand(args);
        }
      }
    }

    exitCode = cmd.execute(args);

  }

  @NotNull
  private static String[] addDefaultCommand(String[] args) {
    List<String> tmpList = new ArrayList<>(Arrays.asList(args));
    tmpList.add(0, DEFAULT_COMMAND);
    args = tmpList.toArray(new String[0]);
    return args;
  }

  @Override
  public int getExitCode() {
    return exitCode;
  }

  public Integer call() {
    // заглушка, командой как таковой не пользуемся
    return 0;
  }
}
