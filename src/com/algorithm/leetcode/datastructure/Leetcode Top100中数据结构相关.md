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



## LRUCache

![1590076136592](C:\Users\lin\AppData\Roaming\Typora\typora-user-images\1590076136592.png)

**思路：** 哈希表+双向链表

```java
public class LRUCache {


    private DoubleLinkedList cache;

    private Map<Integer,Node> map;

    private int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.cache = new DoubleLinkedList();
    }


    public void put(int key, int val) {
        Node node = new Node(key, val);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
        }else {
            if (cache.getSize() == capacity) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
        }
        cache.addFirst(node);
        map.put(key, node);
    }


    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        int val=node.val;
        put(key, val);
        return val;
    }


    private class DoubleLinkedList{

        private int size;

        private LRUCache.Node head;

        private LRUCache.Node tail;

        public DoubleLinkedList(){
            this.head = new LRUCache.Node(-1, -1);
            this.tail = new LRUCache.Node(-1, -1);
            this.head.next=tail;
            this.tail.front=head;
        }


        public void addFirst(LRUCache.Node node){
            this.head.next.front=node;
            node.next=this.head.next;
            this.head.next=node;
            node.front = this.head;
            size++;
        }


        public void remove(LRUCache.Node node) {
            node.front.next=node.next;
            node.next.front = node.front;
            size--;
        }


        public LRUCache.Node removeLast(){
            if (tail.front == head) {
                return null;
            }
            LRUCache.Node last = tail.front;
            remove(last);
            return last;
        }

        public int getSize(){
            return size;
        }


    }

    private class Node{
        int key;
        int val;
        Node front;
        Node next;

        public Node(int key,int val){
            this.key = key;
            this.val = val;
            this.front = null;
            this.next = null;
        }
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}
```





## 实现Trie（前缀树）

 ![1590078117493](C:\Users\lin\AppData\Roaming\Typora\typora-user-images\1590078117493.png)

先看了官方题解还是云里雾里，最后还是看了这位B站上的小姐姐的视频才豁然开朗的，具体链接如下：

`https://www.bilibili.com/video/BV1UE4114795?from=search&seid=4956537258037679326`

```java
public class Trie {
    
 
    
   private TrieNode root;
    
    public Trie(){
        this.root=new TrieNode(' ');//以 ' '空字节为val
    }
    
    public void insert(String word){
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(cur.children[c-'a']==null){
                cur.children[c-'a']=new TrieNode(c);
            }
            cur=cur.children[c-'a'];
        }
        cur.isWord=true;
    }
    
    
    public boolean search(String word){
        TrieNode cur=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(cur.children[c-'a']==null){
                return false;
            }
            cur=cur.children[c-'a'];
        }
        return cur.isWord;
    }
    
    
    public boolean startsWith(String prefix){
        TrieNode cur=root;
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if(cur.children[c-'a']==null){
                return false;
            }
            cur=cur.children[c-'a'];
        }
        return true;
    }
    
    private class TrieNode{
        //前缀节点由三部分组成，字节val，前缀节点数组children，以及是否是完整单词的标记isWord
        char val;
        TrieNode[] children;
        boolean isWord;
        
        
        public TrieNode(char val){
            this.val=val;
            this.children=new TrieNode[26];
            this.isWord=false;
        }
    }
}
```

可以看出，前缀树的三个方法相似度极高，记住其中一个方法，再稍作修改，就可以写出其他两个方法了。



