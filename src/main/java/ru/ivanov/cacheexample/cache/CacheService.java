package ru.ivanov.cacheexample.cache;

import java.util.Objects;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "data")
public class CacheService {
  private final Dao dao;
  private final CacheManager cacheManager;

  public CacheService(Dao dao, CacheManager cacheManager) {
    this.dao = dao;
    this.cacheManager = cacheManager;
  }

  @Cacheable(key = "#lastName")
  public String getData(String lastName, String name) {
    return dao.getData(lastName);
  }

  public String getManualData(String lastName) {
    Cache data = cacheManager.getCache("data");
    return Objects.requireNonNull(data).get(lastName, String.class);
  }

  @CachePut
  public String update(String lastName) {
    return dao.getData(lastName);
  }

  @CacheEvict(allEntries = true)
  public void evict() { /*При желании можно что-то сюда дописать*/ }
}
