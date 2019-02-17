# LRU Cache

A simple LRU cache implementation inspired by [LeetCode's problem](https://leetcode.com/problems/lru-cache/)

## Developing

### Build

```sh
./gradlew build
```

### Test

```sh
./gradlew test
```

## Example of Usage

```java
LRUCache<String, String> cache = new LRUCache<>(2 /* capacity */);

cache.put("Hi", "Hi");
cache.put("Bye", "Bye");
cache.put("No", "No"); // deletes "Hi"

cache.get("Hi") // returns null
```
