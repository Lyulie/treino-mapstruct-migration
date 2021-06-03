package com.test.migration.service;

import com.test.migration.model.TransferLog;
import com.test.migration.repository.TransferLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransferLogService {

    @Autowired
    private TransferLogRepository transferLogRepository;

    public TransferLog save(TransferLog transferLog) {
        return transferLogRepository.save(transferLog);
    }

    public void clear() {
        transferLogRepository.deleteAll();
    }
}
