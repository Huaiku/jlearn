[TOC]

# Java Map

## Java Map Interface 接口

### 1.0 Map Interface

 Map 是一种特殊的数据结构,一个Map对象包含多个键值对，每一个具体的键对应一个具体的值,Map对象中不允许包含相同的键,在Java Map中一个键最多对应一个值,这是程序对一个数学函数的抽象`f(key) = address ==> value`

 一个Map对象所代表的数据结构模型是这个样子的`[{key:k1,value:v1},{key:k2,value:v2},{key:k3,value:v3}]`

 在Java Map接口中定义了一些操作Map的方法`put(key,value) | get(key) | remove(e) | containKey(key) | containValue(value) | size() | empty()`每个方法的作用都如其名称所表示的那样，除了这些基本的操作方法之外，还定义了批量处理操作`putAll|clear`和对应的集合视图`keySet|entrySet|values`
 Java平台下包含了三个Map的通用实现类: `HashMap|TreeMap|LinkedHashMap`

#### 1.1 Map Interface Basic Operations 基本操作

> ```java
> import java.util.HashMap;
> import java.util.Map;
> 
> public class MapOperations {
>     public static void main(String[] args) {
>         Map<String, Integer> map = new HashMap<>();
>         // 条目添加
>         map.put("Java", 1000);
>         map.put("Python", 3000);
>         map.put("JavaScript", 4000);
>         // 第一种 遍历条目,通过entrySet遍历，每一个entry代表一个键值对对象
>         for (Map.Entry<String, Integer> entry : map.entrySet()) {
>             System.out.println("健：" + entry.getKey() + ",值：" + entry.getValue());
>         }
>         // 第二种 遍历条目,通过遍历keySet获取键，然后通过键从map中获取值
>         for (String key : map.keySet()) {
>             System.out.println("健：" + key + ",值：" + map.get(key));
>         }
> 
>     }
> }
> ```
>
> 在上面例子中,该map对象为`[Java=1000,Python=3000,JavaScript=4000]`。

#### 1.2 Collection Views 集合视图

视图方法(view method)允许我们将Map 视为 一个集合(List|Set),视为并非转换为,当Map对应的集合视图改变时Map会随之改变。有三个方法可以实现

- `keySet()` -- map中包含的所有键，返回一个`Set<T>`类型集合，因为key是不允许重复的
- `values` -- map中包含的所有值，返回一个`Collection<T>`集合因为值是允许重复的，所以不能用`Set<T>`
- `entrySet` -- map中包含的所有键值对,返回的是`Set<Map.Entry<T,E>>`每一个`Map.Entry`代表一个具体的键值对,通过`entry.getKey()|entry.getValue()`方法来操作。