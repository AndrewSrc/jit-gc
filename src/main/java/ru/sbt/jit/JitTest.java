package ru.sbt.jit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Home on 22.06.2018.
 */
public class JitTest {
    public static void main(String... args) {
        int count = 100000;

        Map<Integer, String> map = new HashMap< Integer, String >();
        for ( int i = 0; i < count; i++ )
            map.put( i, "value" + i );

    }
    //java -XX:+PrintCompilation -cp target/jit-gc.jar ru.sbt.jit.JitTest
    //https://stackoverflow.com/questions/13086690/understanding-the-output-of-xxprintcompilation
    //https://stackoverflow.com/questions/41134037/whats-this-new-column-in-xxprintcompilation-output
    //https://stackoverflow.com/questions/35601841/how-does-the-jvm-decided-to-jit-compile-a-method-categorize-a-method-as-hot/35614237

    //java -XX:+PrintCompilation -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining -cp target/jit-gc.jar ru.sbt.jit.JitTest
    //https://techblug.wordpress.com/2013/08/19/java-jit-compiler-inlining/
    //https://stackoverflow.com/questions/46508393/meaning-of-callee-is-too-large-in-jvm-logcompilation-output
}
