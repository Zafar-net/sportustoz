package zafar.net.sportustoz.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zafar.net.sportustoz.entity.AgeType;
import zafar.net.sportustoz.entity.AppUser;
import zafar.net.sportustoz.repository.AgeTypeRepository;
import zafar.net.sportustoz.repository.AppUserRepository;
import zafar.net.sportustoz.dto.AppUserCreateDto;

@Service
@RequiredArgsConstructor
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final AgeTypeRepository ageTypeRepository;

    public AppUser createUser(AppUserCreateDto dto) {
        AgeType ageType = determineAgeType(dto.getAge());
        AppUser user = AppUser.builder()
                .fullName(dto.getFullName())
                .age(dto.getAge())
                .ageType(ageType)
                .build();
        return appUserRepository.save(user);
    }

    public AgeType determineAgeType(int age) {
        if (age <= 27) return ageTypeRepository.findById(1L).orElseThrow();
        else if (age <= 32) return ageTypeRepository.findById(2L).orElseThrow();
        else if (age <= 37) return ageTypeRepository.findById(3L).orElseThrow();
        else if (age <= 42) return ageTypeRepository.findById(4L).orElseThrow();
        else return ageTypeRepository.findById(5L).orElseThrow();
    }
    public AppUser getUserById(Long userId) {
        return appUserRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Foydalanuvchi topilmadi!"));
    }


}