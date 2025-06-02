package com.keresman.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class RepositoryFactory {

    private static final Properties properties = new Properties();
    private static final String PATH = "/config/repository.properties";
    private static final Map<Class<?>, Object> repositoryCache = new HashMap<>();

    static {
        try (InputStream is = RepositoryFactory.class.getResourceAsStream(PATH)) {
            properties.load(is);
        } catch (Exception ex) {
            Logger.getLogger(RepositoryFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static <T> T getInstance(Class<T> repoType) throws Exception {

        if (repositoryCache.containsKey(repoType)) {
            return (T) repositoryCache.get(repoType);
        }

        String className = properties.getProperty(repoType.getSimpleName());

        if (className == null) {
            throw new Exception("Repository class not found: %s".formatted(repoType.getSimpleName()));
        }

        T instance = (T) Class.forName(className).getDeclaredConstructor().newInstance();
        repositoryCache.put(repoType, instance);
        return instance;
    }
}
