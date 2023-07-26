package marvel.geni.authservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import marvel.geni.authservice.dto.member.request.CreateMemberRequestDTO;
import marvel.geni.authservice.dto.member.request.LoginMemberRequestDTO;
import marvel.geni.authservice.entity.Member;
import marvel.geni.authservice.result.ApiError;
import marvel.geni.authservice.result.ApiResult;
import marvel.geni.authservice.result.ApiUtils;
import marvel.geni.authservice.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
 @RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class MemberController {

    private final MemberService memberService;
    @PostMapping("/signup")
    public ApiResult signupController(@Valid @RequestBody CreateMemberRequestDTO dto) {
        if(memberService.isDuplicateEmail(dto.getEmail())) return ApiUtils.error("이미 존재하는 이메일입니다", HttpStatus.INTERNAL_SERVER_ERROR);
        Member member = memberService.registerMember(dto);
        return ApiUtils.success(dto.getName() + "님 회원가입 완료되었습니다");
    }



}
