package az.edu.orient.msusergroup64.service;

import az.edu.orient.msusergroup64.client.account.AccountClient;
import az.edu.orient.msusergroup64.client.account.AccountCreateRequest;
import az.edu.orient.msusergroup64.entity.UserEntity;
import az.edu.orient.msusergroup64.enums.Currency;
import az.edu.orient.msusergroup64.enums.Status;
import az.edu.orient.msusergroup64.mapper.UserMapper;
import az.edu.orient.msusergroup64.repository.UserRepository;
import az.edu.orient.msusergroup64.request.UserCreateRequest;
import az.edu.orient.msusergroup64.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
    private final AccountClient accountClient;

    public UserResponse addUser(UserCreateRequest request){
        UserEntity entity = mapper.toEntity(request);
        entity.setStatus(Status.ACTIVE);
        UserEntity saved = userRepository.save(entity);
        AccountCreateRequest accountCreateRequest = new AccountCreateRequest();
        accountCreateRequest.setUserId(saved.getId());
        accountCreateRequest.setName(saved.getFirstName());
        accountCreateRequest.setCurrency(Currency.AZN);
        accountCreateRequest.setBalance(BigDecimal.ZERO);
        accountClient.createAccount(accountCreateRequest);
        return mapper.toResponse(saved);
    }

    public UserResponse updateUser(Long id,UserCreateRequest request) {
        UserEntity entity = userRepository.findByIdAndStatus(id,Status.ACTIVE);
        mapper.updateEntityFromRequest(entity,request);
        UserEntity saved = userRepository.save(entity);
        return mapper.toResponse(saved);
    }

    public List<UserResponse> getUserList(){
        List<UserEntity> userEntities = userRepository.findAllByStatus(Status.ACTIVE);
        return mapper.toResponseList(userEntities);
    }

    public UserResponse getById(Long id){
        UserEntity user = userRepository.findByIdAndStatus(id,Status.ACTIVE);
        return mapper.toResponse(user);
    }

    public void deleteUser(Long id){
        UserEntity user = userRepository.findByIdAndStatus(id,Status.ACTIVE);
        user.setStatus(Status.INACTIVE);
        userRepository.save(user);
    }
}
