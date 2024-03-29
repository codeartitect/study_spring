package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1l, "name", Grade.VIP));

        OrderServiceImplTemp orderService = new OrderServiceImplTemp(memberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1l, "i", 1000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }

}