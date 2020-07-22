# pcd
Persistent Collection Demo

```
$ mvn verify
$ java -jar target/persistent-collections-demo-1.0-SNAPSHOT.jar
[add|del|pop|quit] [key [value]]
add key1 value1
Adding key1 -> value1
  Handle{map={key1=value1}, reverseMap={value1=[key1]}}
 Handle{map={}, reverseMap={}}
add key2 value2
Adding key2 -> value2
   Handle{map={key1=value1, key2=value2}, reverseMap={value1=[key1], value2=[key2]}}
  Handle{map={key1=value1}, reverseMap={value1=[key1]}}
 Handle{map={}, reverseMap={}}
add key3 value1
Adding key3 -> value1
    Handle{map={key1=value1, key2=value2, key3=value1}, reverseMap={value1=[key1, key3], value2=[key2]}}
   Handle{map={key1=value1, key2=value2}, reverseMap={value1=[key1], value2=[key2]}}
  Handle{map={key1=value1}, reverseMap={value1=[key1]}}
 Handle{map={}, reverseMap={}}
del key2
Deleting key2
     Handle{map={key1=value1, key3=value1}, reverseMap={value1=[key1, key3], value2=[]}}
    Handle{map={key1=value1, key2=value2, key3=value1}, reverseMap={value1=[key1, key3], value2=[key2]}}
   Handle{map={key1=value1, key2=value2}, reverseMap={value1=[key1], value2=[key2]}}
  Handle{map={key1=value1}, reverseMap={value1=[key1]}}
 Handle{map={}, reverseMap={}}
pop
Popping
    Handle{map={key1=value1, key2=value2, key3=value1}, reverseMap={value1=[key1, key3], value2=[key2]}}
   Handle{map={key1=value1, key2=value2}, reverseMap={value1=[key1], value2=[key2]}}
  Handle{map={key1=value1}, reverseMap={value1=[key1]}}
 Handle{map={}, reverseMap={}}
pop
Popping
   Handle{map={key1=value1, key2=value2}, reverseMap={value1=[key1], value2=[key2]}}
  Handle{map={key1=value1}, reverseMap={value1=[key1]}}
 Handle{map={}, reverseMap={}}
pop
Popping
  Handle{map={key1=value1}, reverseMap={value1=[key1]}}
 Handle{map={}, reverseMap={}}
quit
```
