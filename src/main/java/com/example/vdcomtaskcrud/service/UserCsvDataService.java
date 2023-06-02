package com.example.vdcomtaskcrud.service;

import com.example.vdcomtaskcrud.entity.User;
import com.example.vdcomtaskcrud.model.UserCSVRecord;
import com.opencsv.bean.CsvToBeanBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserCsvDataService {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserCsvDataService(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    public void loadCsvData(MultipartFile file) {
        List<User> users = convertToUsers(convertCsv(file));
        userService.saveAll(users);
    }



    private List<User> convertToUsers(List<UserCSVRecord> userCSVRecords) {
        List<User> users = new ArrayList<>();
        for (UserCSVRecord userCSVRecord : userCSVRecords) {
            users.add(convertToUser(userCSVRecord));
        }

        return users;
    }

    private User convertToUser(UserCSVRecord userCSVRecord) {
        return modelMapper.map(userCSVRecord, User.class);
    }

    private List<UserCSVRecord> convertCsv(MultipartFile file) {

        try {
            List<UserCSVRecord> userCSVRecords = new CsvToBeanBuilder<UserCSVRecord>(new InputStreamReader(file.getInputStream()))
                    .withType(UserCSVRecord.class)
                    .build().parse();

            return userCSVRecords;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
