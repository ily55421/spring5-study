package com.xpinjection.java8.misused.stream;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * @author 14688
 * 嵌套 foreach
 */
public class NestedForEach {
    /**
     * 为每个使用外部集合嵌套
     */
    @Ugly
    class NestedForEachWithExternalCollection {
        /**
         * 检索促销规则名称
         * @param transactions
         * @return
         */
        public Set<String> retrievePromoRuleNames(List<BusinessTransaction> transactions) {
            // 带有促销的规则名称组 ruleNamesWithPromo
            Set<String> ruleNamesWithPromo = new HashSet<>();
            transactions.forEach(transaction ->
                    // 获取商业对象的橘色组
                    transaction.getRules().stream()
                            // 过滤是否是促销规则
                    .filter(BusinessRule::isPromotion)
                            // 添加促销规则名 到规则组中
                    .forEach(rule -> ruleNamesWithPromo.add(rule.getRuleName())));
            // 返回 规则对象
            return ruleNamesWithPromo;
        }
    }

    /**
     * 流操作链
     */
    @Good
    class StreamOperationsChain {
        public Set<String> retrievePromoRuleNames(List<BusinessTransaction> transactions) {
            // 生成流
            return transactions.stream()
                    // 平铺映射角色组 为流对象
                    .flatMap(t -> t.getRules().stream())
                    // 过滤促销规则
                    .filter(BusinessRule::isPromotion)
                    // 映射对应规则名称
                    .map(BusinessRule::getRuleName)
                    // 终止操作  收集为set集合返回
                    .collect(toSet());
        }
    }

    /**
     * 商业交易
     */
    class BusinessTransaction {
        /**
         * 商业规则组
         * @return
         */
        List<BusinessRule> getRules() {
            return new ArrayList<>(); //stub 存根
        }
    }

    /**
     * 业务规则
     */
    class BusinessRule {
        String getRuleName() {
            return ""; //stub
        }

        boolean isPromotion() {
            return false; //stub
        }
    }
}
