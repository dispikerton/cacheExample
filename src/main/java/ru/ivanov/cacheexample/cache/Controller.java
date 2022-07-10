package ru.ivanov.cacheexample.cache;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
  private final CacheService cacheService;


  public Controller(CacheService cacheService) {
    this.cacheService = cacheService;
  }

  @GetMapping
  public String getData(@RequestParam String lastName, @RequestParam String name){
    return cacheService.getData(lastName, name);
  }

  @GetMapping("/manual")
  public String getMnaulData(@RequestParam String lastName){
    return cacheService.getManualData(lastName);
  }

  @GetMapping("/update")
  public String update(@RequestParam String lastName){
    return cacheService.update(lastName);
  }

  @GetMapping("/evict")
  public void evict(){
    cacheService.evict();
  }
}
