package com.baiyun.config;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.IllegalSQLInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
    /*  旧版本配置
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }*/
//    @Bean
//    public PaginationInnerInterceptor paginationInterceptor() {
//        PaginationInnerInterceptor performanceInterceptor = new PaginationInnerInterceptor();
//        performanceInterceptor.setDbType(DbType.MYSQL);
//        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
//        // performanceInterceptor.setOverflow(false);
//        // 设置最大单页限制数量，默认 500 条，-1 不受限制
//        // performanceInterceptor.setMaxLimit(500);
//        return performanceInterceptor;
//    }

    /**
     * 自动分页:
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    /**
     * sql性能规范
     */
    @Bean
    public IllegalSQLInnerInterceptor IllegalSQLInnerInterceptor(){
        return new IllegalSQLInnerInterceptor();
    }
    /**
     * 防止全表更新与删除
     * */
    @Bean
    public BlockAttackInnerInterceptor blockAttackInnerInterceptor(){
        return new BlockAttackInnerInterceptor();
    }
}
