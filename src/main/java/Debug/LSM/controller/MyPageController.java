package Debug.LSM.controller;

import Debug.LSM.service.MyPageService;
import Debug.LSM.DTO.MypageDTO;
import Debug.LSM.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mypage")
public class MyPageController {

    private final MyPageService myPageService;

    public MyPageController(MyPageService myPageService) {
        this.myPageService = myPageService;
    }

    //마이페이지 데이터
    @GetMapping("/getInfo")
    public ResponseEntity<MypageDTO> mypage(Authentication authentication) {

        User user = User.builder()._id(authentication.getName()).build();
        return myPageService.mypageData(user);
    }
}
