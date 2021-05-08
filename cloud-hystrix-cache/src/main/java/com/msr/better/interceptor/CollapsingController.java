package com.msr.better.interceptor;

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
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/getAnimal")
    public String getAnimal() throws Exception {
        Future<Animal> user = collapsingService.collapsing(1);
        Future<Animal> user2 = collapsingService.collapsing(2);
        System.out.println(user.get().getName());
        System.out.println(user2.get().getName());
        return "Success";
    }

    /**
     * 返回值必须是Future，否则不会进行合并/聚合
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping("/getAnimalSyn")
    public String getAnimalSyn() throws ExecutionException, InterruptedException {
        Animal user = collapsingService.collapsingSyn(1);
        Animal user2 = collapsingService.collapsingSyn(2);
        System.out.println(user.getName());
        System.out.println(user2.getName());
        return "Success";
    }


    /**
     * 请求聚合/合并,整个应用的
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping("/getAnimalGlobal")
    public String getAnimalGlobal() throws Exception {
        Future<Animal> user = collapsingService.collapsingGlobal(1);
        Future<Animal> user2 = collapsingService.collapsingGlobal(2);
        System.out.println(user.get().getName());
        System.out.println(user2.get().getName());
        return "Success";
    }
}
