package ru.ivanov.cacheexample.cache;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.SneakyThrows;

@Component
public class Dao {
  @SneakyThrows
  public String getData(String lastName) {
    Thread.sleep(2000);
    List<String> strings =
      Files.readAllLines(Path.of("/home/jarvis/IdeaProjects/cacheExample/src/main/resources/" + lastName + ".txt"));
    return String.join(" ", strings);
  }
}
