package com.lumia.web.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import com.lumia.web.entity.ParseExcelDto;
import com.lumia.web.service.ParseExcelService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Slf4j
public class UserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ParseExcelService parseExcelService;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testParseExcel() {
        File file = new File("C:\\Users\\EDZ\\Desktop\\event_fdgfjhfgdk.xlsx");

        ParseExcelDto parseExcelDto = parseExcelService.parseExcel(file);
        System.out.println(parseExcelDto);
    }

    //单线程测试
    @Test
    public void testSingleGetService() {

        List<String> services = CollUtil.newArrayList("sndo", "zall", "ali", "baidu", "tencent");


        int times = 1000;

        for (int i = 0; i < times; i++) {

            try {
                String service = RandomUtil.randomEle(services);

                String url = "/user/findService/" + service;

                MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();
                String contentAsString = mvcResult.getResponse().getContentAsString();

                log.info("请求服务名称 {}，请求返回服务名称 {}",service, contentAsString);

                if (!service.equals(contentAsString)) {
                    log.error("数据源不一致 request: {}, response {}", service, contentAsString);
                }

            } catch (Throwable throwable) {
                log.error(throwable.getMessage(), throwable);
            }

        }

        log.info("执行完毕");

    }


    @Test
    public void testMultiGetService() throws Exception {

        List<String> services = CollUtil.newArrayList("sndo", "zall", "ali", "baidu", "tencent");

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        int times = 1000;

        CountDownLatch countDownLatch = new CountDownLatch(times);
        for (int i = 0; i < times; i++) {
            Runnable runnable = () -> {
                try {
                    String service = RandomUtil.randomEle(services);

                    String url = "/user/findService/" + service;

                    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url)
                            .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                            .andExpect(MockMvcResultMatchers.status().isOk())
                            .andReturn();
                    String contentAsString = mvcResult.getResponse().getContentAsString();

                    log.info("请求服务名称 {}，请求返回服务名称 {}",service, contentAsString);

                    if (!service.equals(contentAsString)) {
                        log.error("数据源不一致 request: {}, response {}", service, contentAsString);
                    }

                    countDownLatch.countDown();

                } catch (Throwable throwable) {

                    countDownLatch.countDown();

                    log.error(throwable.getMessage(), throwable);
                }
            };

            executorService.execute(runnable);
        }

        countDownLatch.await();
        log.info("执行完毕");
    }
}
