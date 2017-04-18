package callable_future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2017/4/17.
 */
public class CallableTest {
    public static void main(String[] args) {
        ExecutorService es= Executors.newSingleThreadExecutor();
        CallableDemo calTask=new CallableDemo();
        Future<Integer>   future=es.submit(calTask);
        es.shutdown();
        try{
            Thread.sleep(2000);
            System.out.println("主线程在执行其他任务");
            if(future.get()!=null){
                System.out.println("future.get()-->"+future.get());
            }else{
                System.out.println("future.get()-->未获取到结果");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("主线程执行完成");
    }
}
