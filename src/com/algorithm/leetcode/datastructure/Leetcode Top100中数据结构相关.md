# Leetcode Top100中数据结构相关

Leetcode上Top100中关于数据结构的有三题：

155.最小栈

146.LRU缓存

208.前缀树



## 最小栈

![1589995472327](C:\Users\lin\AppData\Roaming\Typora\typora-user-images\1589995472327.png)

```java
class MinStack {

    //最小值
    private int min;
    
    //用栈来保存元素
    private Stack<Integer> stack;
    
    public MinStack() {
        this.min=Integer.MAX_VALUE;
        this.stack=new Stack();
    }
    
    public void push(int x) {
        //注意 这里是的条件是 <=
        if(x<=min){
            //将前一个最小值压入栈中
            stack.push(min);
            //更新最小值
            min=x;
        }
        stack.push(x);
    }
    
    public void pop() {
        //如果pop出来的值等于最小值，那么还要继续pop一次，将最小值更新为前一个最小值
        if(min==stack.pop()){
            min=stack.pop();
        }
    }
    
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
```

