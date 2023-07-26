package marvel.geni.authservice.repository;

import marvel.geni.authservice.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Boolean existsMemberByEmail(String email);
}
