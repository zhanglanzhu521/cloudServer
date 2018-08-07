package com.zlz.DBConfig;

//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title :
 * @Description :生成一套SqlSessionFactory，进行动态切换
 * @Author : zhanglz
 * @Date : 2018/8/7 10:29
 */
//@Configuration
//@ConditionalOnClass({EnableTransactionManagement.class})
//@Import({ DataBaseConfiguration.class})
//@MapperScan(basePackages={"com.hui.readwrite.mapper.master1"})
public class TxxsbatisConfiguration {

//
//    @Value("${spring.datasource.type}")
//    private Class<? extends DataSource> dataSourceType;
//
//
//    @Value("${datasource.readSize}")
//    private String dataSourceSize;
//
//
//    @Resource(name = "writeDataSource")
//    private DataSource dataSource;
//
//
//    @Resource(name = "readDataSources")
//    private List<DataSource> readDataSources;
//
//
//    @Bean
//    @ConditionalOnMissingBean
//    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(roundRobinDataSouceProxy());
//        sqlSessionFactoryBean.setTypeAliasesPackage("com.hui.readwrite.po");
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath:mapper/master1*//*.xml"));
//        sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
//        return sqlSessionFactoryBean.getObject();
//    }
//    /**
//     * 有多少个数据源就要配置多少个bean
//     * @return
//     */
//    @Bean
//    public AbstractRoutingDataSource roundRobinDataSouceProxy() {
//        int size = Integer.parseInt(dataSourceSize);
//        TxxsAbstractRoutingDataSource proxy = new TxxsAbstractRoutingDataSource(size);
//        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
////        targetDataSources.put(DataSourceType.write.getType(),dataSource);
//        for (int i = 0; i < size; i++) {
//            targetDataSources.put(i, readDataSources.get(i));
//        }
//        proxy.setDefaultTargetDataSource(dataSource);
//        proxy.setTargetDataSources(targetDataSources);
//        return proxy;
//    }
}

