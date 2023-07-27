package hcity.concurrency;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.RandomUtils;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.Collectors;

public class ForkJoinTest {
    ForkJoinPool forkJoinPool = new ForkJoinPool(3);
    ForkJoinPool forkJoinPool2 = new ForkJoinPool(9);
    Map<String, Integer> mem = new HashMap<>();

    void test1() {
        List<Integer> arrs = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println("===============  实验1：核心线程为3的forkJoin执行情况。观察线程数和执行情况  ===============");
        List<InnerTest01> ins = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            InnerTest01 test01 = new InnerTest01(i + "");
            ins.add(test01);
        }
        long start = System.currentTimeMillis();
        forkJoinPool.submit(() -> ins.parallelStream().forEach(this::addOp)).join();
        System.out.println("耗时 : " + (System.currentTimeMillis() - start));
//        ins.forEach(System.out::println);
        System.out.println("===============  实验1：结束  ===============\n");

        // 根据自己喜好设定实验间隔时间。或者改写单独执行实验。
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("===============  实验2：串行执行，比较耗时  ===============");
        System.out.println("实验1中每个工作线程的总睡眠时间:" + mem); //
        start = System.currentTimeMillis();
        List<Integer> ans3 = ins.stream().map(this::addOp).collect(Collectors.toList());
        System.out.println("耗时" + (System.currentTimeMillis() - start));
        System.out.println(ans3);
        System.out.println("===============  实验2：结束  ===============\n");

        System.out.println("===============  实验3：两个自定义forkJoinPool运行。观察线程数和执行情况  ===============");
        start = System.currentTimeMillis();
        ForkJoinTask<List<Integer>> task1 = forkJoinPool.submit(() -> arrs.parallelStream().map(x -> addOp(x, forkJoinPool)).collect(Collectors.toList()));
        ForkJoinTask<List<Integer>> task2 = forkJoinPool2.submit(() -> arrs.parallelStream().map(x -> addOp(x, forkJoinPool2)).collect(Collectors.toList()));

        List<Integer> ans = task1.join();
        List<Integer> ans2 = task2.join();
        System.out.println("耗时" + (System.currentTimeMillis() - start));
        System.out.println(ans);
        System.out.println(ans2);
        System.out.println("===============  实验3：结束。  ===============");
    }

    private Integer addOp(int x, ForkJoinPool forkJoinPool) {
        Thread t = Thread.currentThread();
        String name = t.getName();
        int stime = RandomUtils.nextInt(200, 1000);
        System.out.println("示例1 Thread:" + name + " value:" + x + " sleep time " + stime + " activeCount :" + forkJoinPool.getActiveThreadCount() + " queueSize " + forkJoinPool.getQueuedTaskCount());
        try {
            Thread.sleep(stime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return x + 1;
    }

    public static void main(String[] args) {
        ForkJoinTest fj = new ForkJoinTest();
        fj.test1();
    }

    @Getter
    @Setter
    @ToString
    static
    class InnerTest01 {
        String a;

        InnerTest01(String a) {
            this.a = a;
        }
    }

    int addOp(InnerTest01 test01) {
        Thread t = Thread.currentThread();
        String name = t.getName();
        int stime = RandomUtils.nextInt(500, 1000);
        System.out.println("示例0 Thread:" + name + " value:" + test01.getA() + " sleep time " + stime + " activeCount :" + forkJoinPool.getActiveThreadCount() + " queueSize " + forkJoinPool.getQueuedTaskCount());
        mem.put(name, mem.getOrDefault(name, 0) + stime);
        try {
            Thread.sleep(stime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int newA = Integer.parseInt(test01.getA()) + 1;

        test01.setA(String.valueOf(newA));
        return newA;
    }
}
