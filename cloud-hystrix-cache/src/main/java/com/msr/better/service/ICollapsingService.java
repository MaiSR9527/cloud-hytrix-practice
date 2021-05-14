package com.msr.better.service;

import com.msr.better.entity.Animal;

import java.util.concurrent.Future;

/**
 * @author MaiShuRen
 * @site https://www.maishuren.top
 * @since 2021-03-20
 */
public interface ICollapsingService {

    Future<Animal> collapsing(Integer id);

    Animal collapsingSyn(Integer id);

    Future<Animal> collapsingGlobal(Integer id);
}
