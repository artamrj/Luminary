package de.tudortmund.wt2.luminary.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
public enum UserType {
    ADMIN(1, "admin"),
    USER(2, "user");
    //VERIFIED(3, "verified"), we can have some verified user with blue tick like Twitter!

    private final int index;
    private final String type;

    private static final HashMap<Integer, UserType> fromIntegerMap = new HashMap<>();

    static {
        Arrays.stream(UserType.values()).forEach( value -> {
            fromIntegerMap.put(value.index, value);
        });
    }

    public static Optional<UserType> fromIndex(int index){
        return Optional.ofNullable(fromIntegerMap.get(index));
    }
}