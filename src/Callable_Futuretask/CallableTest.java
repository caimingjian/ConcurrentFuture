package Callable_Futuretask;

import callable_future.CallableDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by Administrator on 2017/4/17.
 */
public class CallableTest {
    public static void main(String[] args) {
        ExecutorService es= Executors.newSingleThreadExecutor();
        CallableDemo calTask=new CallableDemo();
        FutureTask<Integer>  futureTask=new FutureTask<>(calTask);
        es.submit(futureTask);
        es.shutdown();
      try {
          Thread.sleep(2000);
          System.out.println("主线程在执行其他任务");
          if(futureTask.get()!=null){
              System.out.println("futureTask.get()-->"+futureTask.get());
          }else{
              System.out.println("futureTask.get()未获得结果");
          }
      }catch (Exception e){
          e.printStackTrace();
      }
      System.out.println("主线程执行完成");
    }
}
