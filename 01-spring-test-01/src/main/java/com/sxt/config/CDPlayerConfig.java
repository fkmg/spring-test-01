package com.sxt.config;

import com.sxt.service.CompactDisc;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackageClasses = CompactDisc.class)
@Configuration
public class CDPlayerConfig {
}
