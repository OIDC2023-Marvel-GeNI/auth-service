package marvel.geni.authservice.dto.member.request;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import marvel.geni.authservice.constant.Gender;
import marvel.geni.authservice.entity.Member;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
public class CreateMemberRequestDTO {

    @NotNull(message = "이메일을 입력해주세요.")
    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(regexp = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "이메일 형식이 아닙니다.")
    private String email;

    @NotNull(message = "비밀번호를 입력해주세요.")
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    @NotNull(message = "이름을 입력해주세요.")
    @NotBlank(message = "이름을 입력해주세요.")
    private String name;

    @NotNull(message = "성별을 입력해주세요.")
    @NotBlank(message = "성별을 입력해주세요.")
    private String gender;

    @NotNull(message = "나이를 입력해주세요.")
    @NotBlank(message = "나이를 입력해주세요.")
    @Min(value=1)
    @Max(value=150)
    private Integer age;

    @NotNull(message = "몸무게를 입력해주세요.")
    @NotBlank(message = "몸무게를 입력해주세요.")
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "200.0", inclusive = true)
    @Digits(integer=3, fraction=1)
    private Float kg;

    @NotNull(message = "키를 입력해주세요.")
    @NotBlank(message = "키를 입력해주세요.")
    @DecimalMin(value = "100.0", inclusive = true)
    @DecimalMax(value = "200.0", inclusive = true)
    @Digits(integer=3, fraction=1)
    private Float cm;

    public static Member toEntity(CreateMemberRequestDTO dto){
        return Member.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .name(dto.getName())
                .gender(Gender.valueOf(dto.getGender()))
                .age(dto.getAge())
                .cm(dto.getCm())
                .kg(dto.getKg())
                .build();
    }

}
