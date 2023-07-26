package marvel.geni.authservice.service;

import lombok.RequiredArgsConstructor;
import marvel.geni.authservice.dto.member.request.CreateMemberRequestDTO;
import marvel.geni.authservice.entity.Member;
import marvel.geni.authservice.repository.MemberRepository;
import marvel.geni.authservice.result.ApiResult;
import marvel.geni.authservice.result.ApiUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public Member registerMember(CreateMemberRequestDTO dto){
        Member savedMember = memberRepository.save(CreateMemberRequestDTO.toEntity(dto));
        return savedMember;
    }

    public Boolean isDuplicateEmail(String email){
        return memberRepository.existsMemberByEmail(email);
    }
}
