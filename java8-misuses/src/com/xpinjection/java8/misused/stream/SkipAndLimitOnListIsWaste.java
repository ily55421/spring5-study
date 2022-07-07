package com.xpinjection.java8.misused.stream;

import com.xpinjection.java8.misused.User;

import java.util.List;

import static com.xpinjection.java8.misused.Annotations.Good;
import static com.xpinjection.java8.misused.Annotations.Ugly;

/**
 * @author link
 * 跳过 + 限制（截取） 在列表中 是浪费
 */
public class SkipAndLimitOnListIsWaste {
    /**
     * TODO 丑陋的 跳过一些元素，然后取一些进行处理
     */
    @Ugly
    class SkipSomeElementsAndThenTakeSomeForProcessing {
        public void registerUsers(List<User> users) {
            // 跳过5个 截取10个
            users.stream().skip(5).limit(10)
                    // 注册
                    .forEach(SkipAndLimitOnListIsWaste.this::registerUser);
        }
    }

    /**
     * TODO good 子列表不要浪费处理时间
     */
    @Good
    class SublistDoNotWasteProcessingTime {
        public void registerUsers(List<User> users) {
            // 返回此列表在指定fromIndex （包括）和toIndex （不包括）之间部分的视图。
            // 使用list的api  subList 直接截取对应的元素
            users.subList(5, 15)
                    .forEach(SkipAndLimitOnListIsWaste.this::registerUser);
        }
    }

    private void registerUser(User user) {
        //register user
    }
}
