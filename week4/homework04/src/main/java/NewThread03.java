import java.util.concurrent.Callable;

public class NewThread03 implements Callable<Integer> {
    public Integer call() throws Exception {
        long start=System.currentTimeMillis();
        int result = sum();
        // 确保  拿到result 并输出
        System.out.println("NewThread03 异步计算结果为："+result);
        System.out.println("NewThread03 使用时间："+ (System.currentTimeMillis()-start) + " ms");
        return result;
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
