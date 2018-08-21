package com.garfield.wechatorder.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by konie on 16-8-23.
 */
public class JsonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static ObjectMapper objectMapperInstance;

    /**
     * 获取ObjectMapper
     *
     * @return
     */
    public static ObjectMapper objectMapper() {
        if (objectMapperInstance == null) {
            objectMapperInstance = new ObjectMapper();
        }

        return objectMapperInstance;
    }

    public static String toJsonString(Object object) {
        ObjectMapper objectMapper = objectMapper();

        String json = null;

        try {
            json = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error("toJsonString err:", e);
        }

        return json;
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        ObjectMapper mapper = JsonUtil.objectMapper();
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    /**
     * Deprecated, please use {@link JsonUtil#toJsonString(Object)} replace.
     * @param value
     * @return
     */
    @Deprecated
    public static String valueToString(Object value) {
        if (value == null) {
            return null;
        }

        ObjectMapper mapper = JsonUtil.objectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error when writeValueAsString", e);
        }

        return result;
    }

    /**
     * Deprecated, please use {@link JsonUtil#parseToMap(String, Class, Class)}  replace
     * @param value
     * @param clazz
     * @param <T>
     * @return
     */
    @Deprecated
    public static <T> T getObjectFromHeader(String value, Class<T> clazz) {
        Object object = new Object();
        if (value == null) {
            return (T) object;
        }
        ObjectMapper objectMapper = JsonUtil.objectMapper();
        try {
            object = objectMapper.readValue(value, clazz);
        } catch (Exception e) {
            LOGGER.error("Resolve device info from header:", e);
        }
        return (T) object;
    }

    /**
     * json字符串转map
     * @param value
     * @param clazzKey
     * @param classValue
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Map<K, V> parseToMap(String value, Class<K> clazzKey, Class<V> classValue) {
        if (value == null) {
            return new HashMap<>();
        }

        try {
            return objectMapper().readValue(value, getCollectionType(Map.class, clazzKey, classValue));
        } catch (IOException e) {
            LOGGER.error("Parse json string to map failed", e);
            return new HashMap<>();
        }
    }

    /**
     * json字符串转object，遇到异常捕获后返回null
     * @param value
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T parseToObject(String value, Class<T> clazz) {
        if (value == null) {
            return null;
        }

        try {
            return objectMapper().readValue(value, clazz);
        } catch (IOException e) {
            LOGGER.error("Parse json string to object failed", e);
            return null;
        }
    }

    /**
     * json字符串转object，遇到异常捕获后返回null
     * @param value
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T parseToObject(String value, TypeReference<T> type) {
        if (value == null) {
            return null;
        }

        try {
            return objectMapper().readValue(value, type);
        } catch (IOException e) {
            LOGGER.error("Parse json string to object failed", e);
            return null;
        }
    }

    /**
     * json字符串转object，遇到异常抛出
     * @param value
     * @param clazz
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T parseToObjectSafe(String value, Class<T> clazz) throws IOException {
        if (value == null) {
            throw new NullPointerException("Argument value can't be null");
        }

        try {
            return objectMapper().readValue(value, clazz);
        } catch (IOException e) {
            LOGGER.error("Parse json string to object failed", e);
            throw e;
        }
    }

    /**
     * json字符串转object，遇到异常抛出
     * @param value
     * @param type
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T> T parseToObjectSafe(String value, TypeReference<T> type) throws IOException {
        if (value == null) {
            throw new NullPointerException("Argument value can't be null");
        }

        try {
            return objectMapper().readValue(value, type);
        } catch (IOException e) {
            LOGGER.error("Parse json string to object failed", e);
            throw e;
        }
    }

}
