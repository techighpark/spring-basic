package springbasic.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbasic.hello.AOP.TimeTraceAop;
import springbasic.hello.Service.MemberService;
import springbasic.hello.repository.MemberRepository;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
//    @Bean
//    public MemberRepository memberRepository(){
////        return new MemoryMemberRepository();
////        return new JDBCMemberRepository(dataSource);
////        return new JDBCTemplateMemberRepository(dataSource);
////        return new JpaMemberRepository(em);
//
//    }

    @Bean
    public TimeTraceAop TimeTraceAop() {
        return new TimeTraceAop();
    }

}
