package springbasic.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbasic.hello.Service.MemberService;
import springbasic.hello.repository.JDBCMemberRepository;
import springbasic.hello.repository.MemberRepository;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
        return new JDBCMemberRepository(dataSource);
    }
}
