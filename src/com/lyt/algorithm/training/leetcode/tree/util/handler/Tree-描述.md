# 树的描述

通过 new TreeCodec().deserialize("")返序列化一个树结构。

### 有序树

常见树有：

1. 空树 ""
    ```text
     null
    ```
   
1. 一个结点 "1"
    ```text
     1
    ```
   
1. "2,1"

    ```text
       2
      /
     1  
    ```
   
1. "1,null,2"

    ```text
     1
      \
       2
    ```
   
1. "1,null,2,null,3"
    ```text
       1
        \
         2
          \
           3
    ```
   
1. "1,null,3,2"
    ```text
       1
        \
         3
        /
       2
    ```
   
1. "2,1,3"
    ```text
       2
      / \
     1   3
    ```
   
1. "3,2,null,1"
    ```text
         3
        /
       2
      /
     1
    ```
   
1. "3,1,null,null,2"
    ```text
         3
        /
       1
        \
         2
    ```


