public class NewThread02 implements Runnable {
    public void run(){
        long start=System.currentTimeMillis();
        int result = sum();
        // 确保  拿到result 并输出
        System.out.println("NewThread02 异步计算结果为："+result);

        System.out.println("NewThread02 使用时间："+ (System.currentTimeMillis()-start) + " ms");
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
