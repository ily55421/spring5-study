package com.xpinjection.java8.misused.stream.collectors;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author link
 * 流可能（也许）被转换为数组
 */
public class StreamMayBeConvertedToArray {
    /**
     * TODO ugly 通过列表转换为数组
     */
    @Ugly
    class ConvertToArrayViaList {
        public String[] getUserNames(List<User> users) {
            //先转换成list
            List<String> names = users.stream()
                    //
                    .map(User::getName)
                    .collect(Collectors.toList());
            // 再转换成array
            return names.toArray(new String[names.size()]);
        }
    }

    /**
     * TODO good 直接转换为数组
     */
    @Good
    class ConvertToArrayDirectly {
        public String[] getUserNames(List<User> users) {
            return users.stream()
                    .map(User::getName)
                    // 直接转换成数组
                    .toArray(String[]::new);
        }
    }
}
