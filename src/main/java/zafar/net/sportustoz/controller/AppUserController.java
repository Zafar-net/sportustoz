package zafar.net.sportustoz.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zafar.net.sportustoz.dto.AppUserCreateDto;
import zafar.net.sportustoz.entity.AppUser;
import zafar.net.sportustoz.service.AppUserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserService appUserService;

    @PostMapping
    public ResponseEntity<AppUser> createUser(@RequestBody AppUserCreateDto dto) {
        return ResponseEntity.ok(appUserService.createUser(dto));
    }
}