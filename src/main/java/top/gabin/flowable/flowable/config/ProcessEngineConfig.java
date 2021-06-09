package top.gabin.flowable.flowable.config;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
//import org.activiti.compatibility.spring.SpringFlowable5CompatibilityHandlerFactory;
import org.apache.commons.collections.CollectionUtils;
import org.flowable.common.engine.api.delegate.event.FlowableEventListener;
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.gabin.flowable.flowable.listener.CustomEventListener;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Configuration
@Slf4j
public class ProcessEngineConfig {


    /**
     * 初始化流程引擎
     */
    @Bean
    public EngineConfigurationConfigurer<SpringProcessEngineConfiguration> getCfg(List<CustomEventListener> customEventListeners) {
        return cfg -> {
            // 如果是从5升级的，需要配置
//            cfg.setFlowable5CompatibilityEnabled(true);
//            cfg.setFlowable5CompatibilityHandlerFactory(new SpringFlowable5CompatibilityHandlerFactory());

            if (CollectionUtils.isNotEmpty(customEventListeners)) {
                Map<String, List<CustomEventListener>> typeListMap = customEventListeners.stream()
                        .collect(Collectors.groupingBy(o -> o.getType().name()));
                Map<String, List<FlowableEventListener>> typeMap = Maps.newHashMap();
                typeListMap.forEach((key, customEventListeners1) -> typeMap.put(key, Lists.newArrayList(customEventListeners1)));
                cfg.setTypedEventListeners(typeMap);
            }
        };
    }

}
