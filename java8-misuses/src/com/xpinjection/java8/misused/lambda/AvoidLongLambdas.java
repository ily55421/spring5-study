package com.xpinjection.java8.misused.lambda;

import com.xpinjection.java8.misused.Annotations.Good;
import com.xpinjection.java8.misused.Annotations.Ugly;
import com.xpinjection.java8.misused.User;
import com.xpinjection.java8.misused.UserDto;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * @author link
 * 避免长 Lambda表达式
 */
public class AvoidLongLambdas {
    /**
     * TODO ugly  长lambda表达式
     */
    @Ugly
    class LongLambdaInPlace {
        public List<UserDto> convertToDto(List<User> users){
            return users.stream()
                    .map(user -> {
                        UserDto dto = new UserDto();
                        dto.setId(user.getId());
                        dto.setName(user.getName());
                        // it happens to be much more fields and much more logic in terms of remapping these fields
                        // 就重新映射这些字段而言，它恰好是更多的字段和更多的逻辑
                        return dto;
                    })
                    .collect(toList());
        }
    }

    /**
     * TODO good 方法参考而不是 Lambda
     * 将复杂逻辑封装后才能函数方法
     */
    @Good
    class MethodReferenceInsteadOfLambda {
        //particular toDto could be implemented as a separate class or as a lambda function
        private final Function<User, UserDto> toDto = this::convertToDto;

        public List<UserDto> convertToDto(List<User> users){
            return users.stream()
                    // 封装转换方法
                    .map(toDto)
                    .collect(toList());
        }

        private UserDto convertToDto(User user){
            UserDto dto = new UserDto();
            dto.setId(user.getId());
            dto.setName(user.getName());
            return dto;
        }
    }
}
