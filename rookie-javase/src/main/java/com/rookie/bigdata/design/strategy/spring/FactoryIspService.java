//package com.rookie.bigdata.design.strategy.spring;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * 策略工厂环境类
// *
// * @author wliduo[i@dolyw.com]
// * @date 2020/5/11 16:04
// */
////@Slf4j
//@Service
//public class FactoryIspService {
//
//    /**
//     * 策略集合Map
//     */
//    @Autowired
//    private Map<String, IspService> ispServiceMap = new ConcurrentHashMap<>(16);
//
//    /**
//     * 匹配服务商，返回对应服务商策略
//     *
//     * @param ispCode
//     * @return com.isp.service.IspService
//     * @throws Exception e
//     * @author wliduo[i@dolyw.com]
//     * @date 2020/5/11 16:19
//     */
//    public IspService getIsp(String ispCode) throws Exception {
//        IspService ispService = ispService.get(ispCode);
//        if (ispService == null) {
//           // log.error("策略工厂获取对应服务商({})策略出现异常", ispCode);
//            System.out.println("策略工厂获取对应服务商("+ispCode+")策略出现异常");
//            throw new RuntimeException("该服务商(" + ispCode + ")未对接当前系统");
//        }
//        return ispService;
//    }
//}
