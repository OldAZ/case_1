package com.web.service;

import com.web.domain.Province;

import java.util.List;

public interface ProvinceService {
    public List<Province> findAll();
    public String findAllJson();
}
