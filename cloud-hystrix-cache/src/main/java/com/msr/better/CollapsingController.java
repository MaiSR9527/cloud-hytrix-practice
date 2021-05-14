package com.msr.better;

import com.msr.better.entity.Animal;
import com.msr.better.service.ICollapsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
@RestController
public class CollapsingController {

    @Autowired
    private ICollapsingService collapsingService;

    /**
     * 请求聚合/合并
     *
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping("/getAnimal")
    public String getAnimal() throws Exception {
        Future<Animal> a1 = collapsingService.collapsing(1);
        Future<Animal> a2 = collapsingService.collapsing(2);
        System.out.println(a1.get().getName());
        System.out.println(a2.get().getName());
        return "Success";
    }

    /**
     * 返回值必须是Future，否则不会进行合并/聚合
     *
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping("/getAnimalSyn")
    public String getAnimalSyn() throws ExecutionException, InterruptedException {
        Animal a1 = collapsingService.collapsingSyn(1);
        Animal a2 = collapsingService.collapsingSyn(2);
        System.out.println(a1.getName());
        System.out.println(a2.getName());
        return "Success";
    }


    /**
     * 请求聚合/合并,整个应用的
     *
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping("/getAnimalGlobal")
    public String getAnimalGlobal() throws Exception {
//        new Thread(()->{
//            Future<Animal> user = collapsingService.collapsingGlobal(1);
//            try {
//                System.out.println(user.get().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(()->{
//            Future<Animal> user2 = collapsingService.collapsingGlobal(2);
//            try {
//                System.out.println(user2.get().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//        }).start();
        Future<Animal> user = collapsingService.collapsingGlobal(1);
        System.out.println(user.get().getName());
        Future<Animal> user2 = collapsingService.collapsingGlobal(2);
        System.out.println(user2.get().getName());
        return "Success";
    }
}
