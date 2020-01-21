package org.tequilacat.tcexpences.client.services;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ServicePool {
  private static Map<Class<?>,Object> interfaces = new HashMap<>();
  
  public static <T> T get(Class<T> clazz, Supplier<T> supplier) {
    @SuppressWarnings("unchecked")
    T instance = (T) interfaces.get(clazz);
    
    if(instance == null) {
      instance = supplier.get();
      interfaces.put(clazz, instance);
    }
    
    return instance;
  }
}
