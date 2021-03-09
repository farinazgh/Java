import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;
/*
Default -XX:+UseG1GC
Garbage-First (G1) Garbage Collector
-------------------------------
Bean name: G1 Young Generation
	pool name: G1 Eden Space
	pool name: G1 Survivor Space
	pool name: G1 Old Gen
collection time: 0
collection count: 0
Bean name: G1 Old Generation
	pool name: G1 Eden Space
	pool name: G1 Survivor Space
	pool name: G1 Old Gen
collection time: 0
collection count: 0
----------------------------------------------
Serial Collector    -XX:+UseSerialGC
Bean name: Copy
	pool name: Eden Space
	pool name: Survivor Space
collection time: 0
collection count: 0
Bean name: MarkSweepCompact
	pool name: Eden Space
	pool name: Survivor Space
	pool name: Tenured Gen
collection time: 0
collection count: 0
----------------------------------------------
Parallel Collector    -XX:+UseParallelGC
Bean name: PS MarkSweep
	pool name: PS Eden Space
	pool name: PS Survivor Space
	pool name: PS Old Gen
collection time: 0
collection count: 0
Bean name: PS Scavenge
	pool name: PS Eden Space
	pool name: PS Survivor Space
collection time: 0
collection count: 0
----------------------------------------------


 */
public class JmxBean {
    public static void main(String[] args) {
        List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean bean : list) {
            System.out.println("Bean name: " + bean.getName());
            String[] poolNames = bean.getMemoryPoolNames();
            for (String poolName : poolNames) {
                System.out.println("\tpool name: " + poolName);
            }
            System.out.println("collection time: " + bean.getCollectionTime());
            System.out.println("collection count: " + bean.getCollectionCount());
        }
    }
}
