package com.sm.dto;

import com.sm.serializer.MaskValue;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private String name;
    private String email;
}
