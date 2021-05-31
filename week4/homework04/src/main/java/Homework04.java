import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Homework04 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 在这里创建一个线程或线程池，
        //创建并启动线程
        //thread
        new NewThread01().start();
        //runnable
        new NewThread02().run();
        //callable
        NewThread03 callable = new NewThread03();
        FutureTask<Integer> task = new FutureTask<Integer>(callable);
        Thread t3 = new Thread(task);
        t3.run();
        System.out.println("NewThread03 获取结果"+task.get());

        //线程池
        //ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
//      ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++){
            executorService.execute(new NewThread02());
        }
        executorService.shutdown();
    }

}
