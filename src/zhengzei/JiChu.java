package zhengzei;

/*
   正则基础
 */
public class JiChu {

    public static void main(String[] args) {
        /*
             .  任何字符
            d 	数字：[0-9]
            D   非数字： [^0-9]
            \s 	空白字符：[ \t\n\x0B\f\r]
            \S 	非空白字符：[^\s]
            \w 	单词字符：[a-zA-Z_0-9]
            \W 	非单词字符：[^\w]
         */
        System.out.println("a".matches("."));
        System.out.println("1".matches("\\d"));
        System.out.println("%".matches("\\D"));
        System.out.println("\r".matches("\\s"));
        System.out.println("^".matches("\\S"));
        System.out.println("a".matches("\\w"));

        /*
            Greedy 数量词
            X?	X，一次或一次也没有
            X*	X，零次或多次
            X+	X，一次或多次
            X{n}	X，恰好n次
            X{n,}	X，至少n次
            X{n,m}	X，至少n次，但是不超过m次
        */
        System.out.println("--------------------------");
        System.out.println( "a".matches(".") );
        System.out.println( "a".matches("a") );
        System.out.println("a".matches("a?") );
        System.out.println( "aaa".matches("a*") );
        System.out.println( "".matches("a+") );
        System.out.println( "aaaaa".matches("a{5}") );
        System.out.println( "aaaaaaaaa".matches("a{5,8}") );
        System.out.println( "aaa".matches("a{5,}") );
        System.out.println( "aaaaab".matches("a{5,}") );

        /*
            范围表示
            [abc]	a、b 或 c（简单类）
            [^abc]	任何字符，除了 a、b 或 c（否定）
            [a-zA-Z]	a 到 z 或 A 到 Z，两头的字母包括在内（范围）
        */
        System.out.println("--------------------------");
        System.out.println( "a".matches("[a]") );
        System.out.println( "aa".matches("[a]+") );
        System.out.println( "abc".matches("[abc]{3,}") );
        System.out.println( "abc".matches("[abc]+") );
        System.out.println( "dshfshfu1".matches("[^abc]+") );
        System.out.println( "abcdsaA".matches("[a-z]{5,}") );
        System.out.println( "abcdsaA12".matches("[a-zA-Z]{5,}") );
        System.out.println( "abcdsaA12".matches("[a-zA-Z0-9]{5,}") );
    }

}
