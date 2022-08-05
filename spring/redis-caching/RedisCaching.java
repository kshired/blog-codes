// redis configurations using string redis serializer
@Bean
public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory redisConnectionFactory){
    RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    redisTemplate.setValueSerializer(new StringRedisSerializer());
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    return redisTemplate;
}

// json parsing
public <T> boolean saveData(String key, T data) {
	try {
      ObjectMapper mapper = new ObjectMapper();
      String value = objectMapper.writeValueAsString(data);
      redisTemplate.opsForValue().set(key, value);
      return true;
    } catch(Exception e){
    	log.error(e);
      	return false;
    }
}

public <T> Optional<T> getData(String key, Class<T> classType) {
	String value = redisTemplate.opsForValue().get(key);
    
    if(value == null){
    	return Optional.empty();
    }
    
	try {
    	ObjectMapper mapper = new ObjectMapper();
     	return Optional.of(objectMapper.readValue(value));
    } catch(Exception e){
    	log.error(e);
      	return Optional.empty();
    }
}
