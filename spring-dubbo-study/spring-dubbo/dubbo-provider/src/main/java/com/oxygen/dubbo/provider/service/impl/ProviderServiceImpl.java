package com.oxygen.dubbo.provider.service.impl;

import com.oxygen.dubbo.provider.service.ProviderService;

public class ProviderServiceImpl implements ProviderService {

    @Override
    public String SayHello(String word) {
        return word;
    }
}
