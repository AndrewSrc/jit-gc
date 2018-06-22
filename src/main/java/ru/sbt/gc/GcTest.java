package ru.sbt.gc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Home on 22.06.2018.
 */
public class GcTest {
    public static void main(String... args) throws IOException {

        while( true ) {
            Thread t = new Thread( new Runnable() {
                public void run() {
                    int count = 100000;

                    Map< Integer, String > map = new HashMap< Integer, String >();
                    for ( int i = 0; i< count; i++ )

                    {
                        if ( i % 1000 == 0 )
                            System.out.println( "value" + i );
                        map.put( i, "value" + i );
                    }
                }
            });

            synchronized ( t ) {
                t.start();
                try {
                    t.wait();
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            }
        }
    }

    // java -XX:+UseParallelGC -cp target/jit-gc.jar ru.sbt.gc.GcTest
    // java -XX:+UseParallelOldGC -cp target/jit-gc.jar ru.sbt.gc.GcTest
    // java -XX:+UseConcMarkSweepGC -cp target/jit-gc.jar ru.sbt.gc.GcTest
    // java -XX:+UseG1GC -cp target/jit-gc.jar ru.sbt.gc.GcTest
}
